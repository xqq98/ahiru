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

    private List<String> usemon;

    private List<String> promon;

    private List<String> pronamemon;

    private List<String> casenamemon;

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public List<String> getPronamemon() {
        return pronamemon;
    }

    public void setPronamemon(List<String> pronamemon) {
        this.pronamemon = pronamemon;
    }

    public List<String> getCasenamemon() {
        return casenamemon;
    }

    public void setCasenamemon(List<String> casenamemon) {
        this.casenamemon = casenamemon;
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

    public List<String> getUsemon() {
        return usemon;
    }

    public void setUsemon(List<String>  usemon) {
        this.usemon = usemon;
    }

    public List<String> getPromon() {
        return promon;
    }

    public void setPromon(List<String> promon) {
        this.promon = promon;
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
        return "EmployeeWorkYear{" +
                "employee='" + employee + '\'' +
                ", pm='" + pm + '\'' +
                ", pmName='" + pmName + '\'' +
                ", pro='" + pro + '\'' +
                ", year='" + year + '\'' +
                ", useMemo='" + useMemo + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", roles='" + roles + '\'' +
                ", tech='" + tech + '\'' +
                ", usemon=" + usemon +
                ", promon=" + promon +
                '}';
    }
}
