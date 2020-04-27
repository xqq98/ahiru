package com.webservice.ahiru.service;

import com.webservice.ahiru.entity.TEmpWork;
import com.webservice.ahiru.exception.AhiruException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rocky.Yu
 * @since 2020-01-15
 */
//Service层业务接口类编写
public interface TEmpWorkService {

    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
    public List<TEmpWork> getTEmpWork();

    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据主键）
    public List<TEmpWork> getTEmpWorkById(String id);

    //把表（T_EMP_WORK）的所有字段的值都插入表中
    public int addTEmpWork(TEmpWork tEmpWork);

    //修改数据库表（T_EMP_WORK）的数据
    public int edtTEmpWork(TEmpWork tEmpWork);

    //韩广晨 2020-04-16 Begin
    //修改数据库表（T_EMP_WORK）的数据，根据 PM_EMPLOYEE_NO,PROJECT_ID,CASE_NAME
    public int setTEmpWorkByNO(String newpmemployeeno, String newprojectid, String newcasename,
                               String updDt, String updId,
                               String oldpmemployeeno, String oldprojectid, String oldcasename);

    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，根据项目经理号去重查询
    public List<TEmpWork> getTEmpWorkByPM_NO(String pmEmployeeNo);
    //韩广晨 2020-04-16 End

    //删除数据库表（T_EMP_WORK）的数据
    public int delTEmpWork(TEmpWork tEmpWork);


    //处理数据
    int doneTempWork(List<TEmpWork> tEmpWorkList)  throws AhiruException;
}
