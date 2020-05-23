package com.webservice.ahiru.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.webservice.ahiru.entity.OutManager;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lijunchen
 * @since 2020-03-09
 */
//Service层业务接口类编写
public interface OutManagerService extends IService<OutManager> {


    List<OutManager> getInfo(OutManager outManager);
}