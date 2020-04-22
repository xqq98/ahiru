package com.webservice.ahiru.service;

import com.webservice.ahiru.entity.MEmployeePm;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songxipeng
 * @since 2019-12-16
 */
//Service层业务接口类编写
public interface MEmployeePmService {

    //获取数据库表（M_EMPLOYEE）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
    public List<MEmployeePm> getMEmployees();
}
