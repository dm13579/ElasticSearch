package com.dm.searchplatform.core;

import org.apache.ibatis.exceptions.TooManyResultsException;

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
  * @InterfaceName:Service 
  * @Description: Service层基础接口，所有Service继承
  * @author dm
  * @date 2020/1/10
  * @slogan: 天下风云出我辈，一入代码岁月催
  * @version V1.0
  */
public interface Service<T> {

    /**
     * 持久化
     * @param bean
     * @throws ServiceException
     */
    void add(T bean) throws ServiceException;

    /**
     * 批量持久化
     * @param beans
     * @throws ServiceException
     */
    void add(List<T> beans) throws ServiceException;

    /**
     * 通过主鍵刪除
     * @param id
     * @throws ServiceException
     */
    void deleteById(Integer id) throws ServiceException;

    /**
     * 更新
     * @param bean
     * @throws ServiceException
     */
    void update(T bean) throws ServiceException;

    /**
     * 通过ID查找
     * @param id
     * @return
     * @throws ServiceException
     */
    T queryById(Integer id) throws ServiceException;

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findBy(String fieldName,Object value) throws TooManyResultsException;
}
