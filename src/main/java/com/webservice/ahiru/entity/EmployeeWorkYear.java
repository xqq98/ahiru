package com.webservice.ahiru.entity;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author wangenji
 * @since 2019-11-18
 */
public class EmployeeWorkYear implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //员工ID
    private String employeeNo;
    //员工姓名
    private String employeeName;
    // 部门
    private String department;
    //PM名
    private String pmName;
    //案件名
    private String caseName;
    //年份
    private String year;
    //级别
    private String level;
    //年份
    private String professional;
    // 1月使用状况
    private String useStatus01;
    // 2月使用状况
    private String useStatus02;
    // 3月使用状况
    private String useStatus03;
    // 4月使用状况
    private String useStatus04;
    // 5月使用状况
    private String useStatus05;
    // 6月使用状况
    private String useStatus06;
    // 7月使用状况
    private String useStatus07;
    // 8月使用状况
    private String useStatus08;
    // 9月使用状况
    private String useStatus09;
    // 10月使用状况
    private String useStatus10;
    // 11月使用状况
    private String useStatus11;
    // 12月使用状况
    private String useStatus12;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUseStatus01() {
        return useStatus01;
    }

    public void setUseStatus01(String useStatus01) {
        this.useStatus01 = useStatus01;
    }

    public String getUseStatus02() {
        return useStatus02;
    }

    public void setUseStatus02(String useStatus02) {
        this.useStatus02 = useStatus02;
    }

    public String getUseStatus03() {
        return useStatus03;
    }

    public void setUseStatus03(String useStatus03) {
        this.useStatus03 = useStatus03;
    }

    public String getUseStatus04() {
        return useStatus04;
    }

    public void setUseStatus04(String useStatus04) {
        this.useStatus04 = useStatus04;
    }

    public String getUseStatus05() {
        return useStatus05;
    }

    public void setUseStatus05(String useStatus05) {
        this.useStatus05 = useStatus05;
    }

    public String getUseStatus06() {
        return useStatus06;
    }

    public void setUseStatus06(String useStatus06) {
        this.useStatus06 = useStatus06;
    }

    public String getUseStatus07() {
        return useStatus07;
    }

    public void setUseStatus07(String useStatus07) {
        this.useStatus07 = useStatus07;
    }

    public String getUseStatus08() {
        return useStatus08;
    }

    public void setUseStatus08(String useStatus08) {
        this.useStatus08 = useStatus08;
    }

    public String getUseStatus09() {
        return useStatus09;
    }

    public void setUseStatus09(String useStatus09) {
        this.useStatus09 = useStatus09;
    }

    public String getUseStatus10() {
        return useStatus10;
    }

    public void setUseStatus10(String useStatus10) {
        this.useStatus10 = useStatus10;
    }

    public String getUseStatus11() {
        return useStatus11;
    }

    public void setUseStatus11(String useStatus11) {
        this.useStatus11 = useStatus11;
    }

    public String getUseStatus12() {
        return useStatus12;
    }

    public void setUseStatus12(String useStatus12) {
        this.useStatus12 = useStatus12;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    @Override
    public String toString() {
        return "EmployeeWorkYear{" +
                "employeeNo='" + employeeNo + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", pmName='" + pmName + '\'' +
                ", caseName='" + caseName + '\'' +
                ", year='" + year + '\'' +
                ", level='" + level + '\'' +
                ", professional='" + professional + '\'' +
                ", useStatus01='" + useStatus01 + '\'' +
                ", useStatus02='" + useStatus02 + '\'' +
                ", useStatus03='" + useStatus03 + '\'' +
                ", useStatus04='" + useStatus04 + '\'' +
                ", useStatus05='" + useStatus05 + '\'' +
                ", useStatus06='" + useStatus06 + '\'' +
                ", useStatus07='" + useStatus07 + '\'' +
                ", useStatus08='" + useStatus08 + '\'' +
                ", useStatus09='" + useStatus09 + '\'' +
                ", useStatus10='" + useStatus10 + '\'' +
                ", useStatus11='" + useStatus11 + '\'' +
                ", useStatus12='" + useStatus12 + '\'' +
                '}';
    }
}
