package com.dm.searchplatform.service;

import com.dm.searchplatform.bean.Book;
import com.dm.searchplatform.core.Service;

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
  * @ClassName:BookSerice 
  * @Description:TODO
  * @author dm
  * @date 2020/1/10
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
public interface BookService extends Service<Book>{

    public int queryByCount();

    public List<Book> getPageList(int page, int size);

}
