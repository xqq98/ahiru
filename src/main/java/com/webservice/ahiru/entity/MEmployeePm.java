package com.webservice.ahiru.entity;

import java.io.Serializable;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author songxipeng
 * @since 2019-12-16
 */

public class MEmployeePm {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //员工编号
    private String employeeNo;

    //员工姓名
    private String name;

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
