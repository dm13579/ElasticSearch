package com.zhiziyun.gdt.service.impl;

import com.zhiziyun.gdt.dao.mapper.ReadBookPdMapper;
import com.zhiziyun.gdt.service.ReadBookPdService;
import com.zhiziyun.gdt.bean.ReadBookPd;
import com.zhiziyun.platform.framework.service.impl.BaseServiceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("readBookPdServiceImpl")
public class ReadBookPdServiceImpl extends BaseServiceImpl<ReadBookPd> implements ReadBookPdService{
    
    /**
     *
     */
    @Resource(name = "readBookPdMapper")
    private ReadBookPdMapper readBookPdMapper;

    @Override
    public  ReadBookPdMapper getMapper() {
        return readBookPdMapper；
    }
}
