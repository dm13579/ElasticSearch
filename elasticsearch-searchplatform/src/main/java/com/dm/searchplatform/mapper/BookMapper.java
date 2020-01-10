package com.dm.searchplatform.mapper;

import com.dm.searchplatform.bean.Book;
import com.dm.searchplatform.core.Mapper;
import org.apache.ibatis.annotations.Param;

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
  * @InterfaceName:BookMapper
  * @Description:TODO
  * @author dm
  * @date 2020/1/6
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
public interface BookMapper extends Mapper<Book> {

    public List<Book> getPageList(@Param("start") Integer start, @Param("size")Integer size);

    int queryByList();

    Integer countAll();
}
