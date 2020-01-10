package com.dm.searchplatform.core;
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
  * @ClassName:ServiceException 
  * @Description:服务（业务）异常
  * @author dm
  * @date 2020/1/10
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
public class ServiceException extends RuntimeException{

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
