package com.dm.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
  *                  ,;,,;
  *                ,;;'(    
  *      __      ,;;' ' \   
  *   /'  '\'~~'~' \ /'\.)  
  * ,;(      )    /  |.     
  *,;' \    /-.,,(   ) \    
  *     ) /       ) / )|    
  *     ||        ||  \)     
  *    (_\       (_\
  * @ClassName:ElasticsearchConfig 
  * @Description:TODO
  * @author dm
  * @date 2020/1/6
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
@Configuration
public class ElasticsearchConfig {

    /**
     * elk集群地址
     */
    @Value("${elasticsearch.ip}")
    private String hostName;
    /**
     * 端口
     */
    @Value("${elasticsearch.port}")
    private String port;
    /**
     * 集群名称
     */
    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    /**
     * 连接池
     */
    @Value("${elasticsearch.pool}")
    private String poolSize;

    @Bean
    public TransportClient init() {

        TransportClient transportClient = null;

        try {
            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("cluster.name", clusterName)
                    .put("client.transport.sniff", true)//增加嗅探机制，找到ES集群
                    .put("thread_pool.search.size", Integer.parseInt(poolSize))//增加线程池个数，暂时设为5
                    .build();

            transportClient = new PreBuiltTransportClient(esSetting);
            TransportAddress inetSocketTransportAddress = new TransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port));
            transportClient.addTransportAddresses(inetSocketTransportAddress);

        } catch (Exception e) {
            System.out.println("elasticsearch TransportClient create error!!!"+e);
        }

        return transportClient;
    }

}
