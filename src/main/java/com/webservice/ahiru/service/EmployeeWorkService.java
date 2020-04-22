package com.webservice.ahiru.service;

import com.baomidou.mybatisplus.service.IService;
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

    //查询数据
    public List<EmployeeWorkYear> getEmployeeWorkInfo(EmployeeWork employeeWork);

    //public int copyEmployeeWorkInfo(List<EmployeeWork> EmployeeWorkList);

    //修改数据
    public int uptEmployeeWorkInfo(EmployeeWorkYear employeeWorkYear);

    public List<EmployeeWorkYear> getEmployeeWorkInfoAll(String startDt, String endDt);

    public List<EmployeeWorkYear> getEmployeeWorkInfoAllList(EmployeeWork employeeWorklist);
}
