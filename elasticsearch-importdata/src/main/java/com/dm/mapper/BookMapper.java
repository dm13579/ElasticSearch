package com.dm.mapper;

import com.dm.bean.Book;
import org.springframework.stereotype.Repository;

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
  * @ClassName:BookMapper 
  * @Description:TODO
  * @author dm
  * @date 2020/1/6
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
@Repository
public interface BookMapper {

    List<Book> queryByList();

    Integer countAll();
}
