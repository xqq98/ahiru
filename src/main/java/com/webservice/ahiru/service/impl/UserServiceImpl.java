package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.entity.MEmpDtl;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.MEmpDtlMapper;
import com.webservice.ahiru.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MEmpDtlMapper empDtlMapper;

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Cacheable(value = "loginUser" ,key="#empid")
    @Override
    public MEmpDtl getUserInfo(String empid) {
        try {
            logger.info("取得用户信息 开始");
            return empDtlMapper.getUserInfoById(empid);
        } catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("员工信息取得失败");
        }
    }
}
