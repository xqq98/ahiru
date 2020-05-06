package com.webservice.ahiru.service;

import com.webservice.ahiru.entity.EmployeeWork;
import com.webservice.ahiru.entity.EmployeeWorkYear;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songxipeng
 * @since 2019-11-18
 */
//Service层业务接口类编写
public interface EmployeeWorkService {

    //一览数据取得
    public List<EmployeeWorkYear> getEmployeeWorkInfo(EmployeeWorkYear employeeWorkYear);
    //明细数据取得
    public List<EmployeeWork> getEmployeeWorkDetail(EmployeeWork employeeWork);
    //修改数据
    public int uptEmployeeWorkInfo(List employeeWorkList);
}
