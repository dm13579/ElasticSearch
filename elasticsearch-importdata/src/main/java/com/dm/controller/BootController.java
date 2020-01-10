package com.dm.controller;

import com.dm.bean.Book;
import com.dm.mapper.BookMapper;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:BootController
 * @Description:TODO
 * @date 2019/4/1
 */
@RestController
@RequestMapping("/")
public class BootController {

    private static final Logger logger = LogManager.getLogger(BootController.class);

    @Autowired
    private BookMapper bookMapper;

    // 每次建索引个数
    private static  Integer number = 1000;

    @RequestMapping("/import")
    public String importData(){
        try {
            long startTime = System.currentTimeMillis();
            writeMysqlDataToES("book");

            logger.info(" use time: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
            return "ok";
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 将mysql 数据查出组装成es需要的map格式，通过批量写入es中
     *
     * @param tableName
     */
    public void writeMysqlDataToES(String tableName) {

        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.186.131", 19200, "http")));// 初始化
        BulkProcessor bulkProcessor = getBulkProcessor(client);

        List<Book> books = bookMapper.queryByList();

        try {

            List<HashMap<String, Object>> dataList = new ArrayList<>();

            // bulkProcessor 添加的数据支持的方式并不多，查看其api发现其支持map键值对的方式，故笔者在此将查出来的数据转换成hashMap方式
            HashMap<String, Object> map = null;
            int count = 0;
            for(Book book:books){
                count++;
                map.put("bookId",book.getId());
                map.put("bookName",book.getName());
                map.put("bookEnName",book.getEnName());
                map.put("author",book.getAuthor());
                map.put("imgUrl",book.getImgurl());
                map.put("createTime",book.getCreateTime());
                map.put("status",book.getStatus());
                map.put("discription",book.getDiscription());
                map.put("price",book.getPrice());
                map.put("category",book.getCategory());
                map.put("commentNum",book.getCommentNum());

                dataList.add(map);
            }
            for (HashMap<String, Object> hashMap2 : dataList) {
                bulkProcessor.add(new IndexRequest(tableName.toLowerCase(), "gzdc", hashMap2.get("bookId").toString())
                        .source(hashMap2));
            }
            // 每提交一次便将map与list清空
            map.clear();
            dataList.clear();

            logger.info("-------------------------- Finally insert number total : " + count);
            // 将数据刷新到es, 注意这一步执行后并不会立即生效，取决于bulkProcessor设置的刷新时间
            bulkProcessor.flush();

        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            try {
                boolean terminatedFlag = bulkProcessor.awaitClose(150L, TimeUnit.SECONDS);
                client.close();
                logger.info(terminatedFlag);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    /**
     * 创建bulkProcessor并初始化
     * @param client
     * @return
     */
    private static BulkProcessor getBulkProcessor(RestHighLevelClient client) {

        BulkProcessor bulkProcessor = null;
        try {

            BulkProcessor.Listener listener = new BulkProcessor.Listener() {
                @Override
                public void beforeBulk(long executionId, BulkRequest request) {
                    logger.info("Try to insert data number : " + request.numberOfActions());
                }

                @Override
                public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                    logger.info("************** Success insert data number : " + request.numberOfActions() + " , id: "
                            + executionId);
                }

                @Override
                public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                    logger.error("Bulk is unsuccess : " + failure + ", executionId: " + executionId);
                }
            };

            BiConsumer<BulkRequest, ActionListener<BulkResponse>> bulkConsumer = (request, bulkListener) -> client
                    .bulkAsync(request, RequestOptions.DEFAULT, bulkListener);

            //	bulkProcessor = BulkProcessor.builder(bulkConsumer, listener).build();
            BulkProcessor.Builder builder = BulkProcessor.builder(bulkConsumer, listener);
            builder.setBulkActions(5000);
            builder.setBulkSize(new ByteSizeValue(100L, ByteSizeUnit.MB));
            builder.setConcurrentRequests(10);
            builder.setFlushInterval(TimeValue.timeValueSeconds(100L));
            builder.setBackoffPolicy(BackoffPolicy.constantBackoff(TimeValue.timeValueSeconds(1L), 3));

            bulkProcessor = builder.build();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                bulkProcessor.awaitClose(100L, TimeUnit.SECONDS);
                client.close();
            } catch (Exception e1) {
                logger.error(e1.getMessage());
            }
        }
        return bulkProcessor;
    }
}
