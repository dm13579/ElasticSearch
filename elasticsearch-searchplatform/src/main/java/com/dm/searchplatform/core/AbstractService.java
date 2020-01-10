package com.dm.searchplatform.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
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
  * @ClassName:AbstraService 
  * @Description:基于通用MyBatis Mapper插件的Service接口的实现
  * @author dm
  * @date 2020/1/10
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
public abstract class AbstractService<T> implements Service<T>{

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> beanClass;

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        beanClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void add(T bean) throws ServiceException {
        mapper.insertSelective(bean);
    }

    @Override
    public void add(List<T> beans) throws ServiceException {
        mapper.insertList(beans);
    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(T bean) throws ServiceException {
        mapper.updateByPrimaryKeySelective(bean);
    }

    @Override
    public T queryById(Integer id) throws ServiceException {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T bean = beanClass.newInstance();
            Field field = beanClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(bean, value);
            return mapper.selectOne(bean);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
