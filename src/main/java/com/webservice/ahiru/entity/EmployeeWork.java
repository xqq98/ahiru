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
public class EmployeeWork implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;
    //编号
    private String workNo;
    //员工ID
    private String employeeNo;
    //员工姓名
    private String employeeName;
    //PMID
    private String pmNo;
    //PM名
    private String pmName;
    //项目ID
    private String projectId;
    //年份
    private String year;
    //月份
    private String useMonth;
    //使用情况
    private String useStatus;

    // 部门
    private String department;

    private String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    //案件名
    private String caseName;
    //备考
    private String useMemo;

    private String entDt;
    private String entId;
    private String updDt;
    private String uptId;
    private String edlDt;
    private String delID;
    private String delFg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
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

    public String getPmNo() {
        return pmNo;
    }

    public void setPmNo(String pmNo) {
        this.pmNo = pmNo;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUseMonth() {
        return useMonth;
    }

    public void setUseMonth(String useMonth) {
        this.useMonth = useMonth;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getUseMemo() {
        return useMemo;
    }

    public void setUseMemo(String useMemo) {
        this.useMemo = useMemo;
    }

    public String getEntDt() {
        return entDt;
    }

    public void setEntDt(String entDt) {
        this.entDt = entDt;
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId;
    }

    public String getUpdDt() {
        return updDt;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUptId() {
        return uptId;
    }

    public void setUptId(String uptId) {
        this.uptId = uptId;
    }

    public String getEdlDt() {
        return edlDt;
    }

    public void setEdlDt(String edlDt) {
        this.edlDt = edlDt;
    }

    public String getDelID() {
        return delID;
    }

    public void setDelID(String delID) {
        this.delID = delID;
    }

    public String getDelFg() {
        return delFg;
    }

    public void setDelFg(String delFg) {
        this.delFg = delFg;
    }
}
