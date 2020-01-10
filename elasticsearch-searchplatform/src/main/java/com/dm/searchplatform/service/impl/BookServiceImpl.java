package com.dm.searchplatform.service.impl;

import com.dm.searchplatform.bean.Book;
import com.dm.searchplatform.core.AbstractService;
import com.dm.searchplatform.mapper.BookMapper;
import com.dm.searchplatform.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
  * @ClassName:BookServiceImpl 
  * @Description:TODO
  * @author dm
  * @date 2020/1/10
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
@Service
@Transactional
public class BookServiceImpl extends AbstractService<Book> implements BookService{

    @Resource
    private BookMapper bookMapper;

    @Override
    public int queryByCount() {
        return bookMapper.countAll();
    }

    @Override
    public List<Book> getPageList(int page, int size) {
        int start = (page - 1) * size;
        return bookMapper.getPageList((page - 1) * size,size);
    }
}
