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

    // 编号
    int workNo;

    //员工ID
    private String employee;

    //PMID
    private String pm;

    //PM名
    private String pmName;

    //项目ID
    private String pro;

    //项目名
    private String proName;

    //案件名
    private String caseName;

    //年份
    private String year;

    // 利用月
    private String useMonth;

    // 使用状况
    private String useStatus;

    // 备考
    private String useMemo;

    //员工姓名
    private String name;

    //级别
    private String level;

    //部门
    private String roles;

    //技术
    private String tech;

    // 更新者ID
    private String updID;

    // 删除者ID
    private String delID;

    // 插入者ID
    private String entID;

    //
    private List<String> levelList;

    //部门名称
    private List<String> depRoleNameList;

    //技术名称
    private List<String> techNameList;

    public List<String> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<String> levelList) {
        this.levelList = levelList;
    }

    public List<String> getDepRoleNameList() {
        return depRoleNameList;
    }

    public void setDepRoleNameList(List<String> depRoleNameList) {
        this.depRoleNameList = depRoleNameList;
    }

    public List<String> getTechNameList() {
        return techNameList;
    }

    public void setTechNameList(List<String> techNameList) {
        this.techNameList = techNameList;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
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

    public String getUseMemo() {
        return useMemo;
    }

    public void setUseMemo(String useMemo) {
        this.useMemo = useMemo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getWorkNo() {
        return workNo;
    }

    public void setWorkNo(int workNo) {
        this.workNo = workNo;
    }

    public String getUpdID() {
        return updID;
    }

    public void setUpdID(String updID) {
        this.updID = updID;
    }

    public String getDelID() {
        return delID;
    }

    public void setDelID(String delID) {
        this.delID = delID;
    }

    public String getEntID() {
        return entID;
    }

    public void setEntID(String entID) {
        this.entID = entID;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    //编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。
    @Override
    //返回参数名称和值
    public String toString() {
        return "EmployeeWork{" +
                "workNo=" + workNo +
                ", employee='" + employee + '\'' +
                ", pm='" + pm + '\'' +
                ", pmName='" + pmName + '\'' +
                ", pro='" + pro + '\'' +
                ", year='" + year + '\'' +
                ", useMonth='" + useMonth + '\'' +
                ", useStatus='" + useStatus + '\'' +
                ", useMemo='" + useMemo + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", roles='" + roles + '\'' +
                ", tech='" + tech + '\'' +
                ", updID='" + updID + '\'' +
                ", delID='" + delID + '\'' +
                ", entID='" + entID + '\'' +
                '}';
    }
}
