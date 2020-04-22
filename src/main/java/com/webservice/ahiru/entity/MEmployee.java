package com.webservice.ahiru.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author songxipeng
 * @since 2019-12-16
 */
//表名：M_EMPLOYEE
@TableName("M_EMPLOYEE")
public class MEmployee implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //部门编号
    private String bu;

    //公司名称
    private String company;

    //部门名称
    private String department;

    //员工编号
    private String employeeNo;

    //姓名
    private String name;

    //邮箱
    private String email;

    //电话号
    private String agentPhone;

    //职称
    private String job;

    //级别
    private String level;

    //学位
    private String degree;

    //专业
    private String professional;

    //状态
    private String state;

    //员工分类
    private String employeeType;

    //入职日期
    private String inSocietyDate;

    //转正日期
    private String turnPositiveDate;

    //离职日期
    private String leavingDate;

    //Cost Center
    private String costCenter;

    //Function
    private String function;

    //是否生效
    private String effect;

    //直线经理
    private String lineManager;

    //工作地
    private String workPlace;

    //登陆日
    private String entDt;

    //登录者
    private String entId;

    //更新日
    private String updDt;

    //更新者
    private String updId;

    //删除日
    private String delDt;

    //删除者
    private String delId;

    //删除标志
    private String delFg;


    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getInSocietyDate() {
        return inSocietyDate;
    }

    public void setInSocietyDate(String inSocietyDate) {
        this.inSocietyDate = inSocietyDate;
    }

    public String getTurnPositiveDate() {
        return turnPositiveDate;
    }

    public void setTurnPositiveDate(String turnPositiveDate) {
        this.turnPositiveDate = turnPositiveDate;
    }

    public String getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(String leavingDate) {
        this.leavingDate = leavingDate;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getLineManager() {
        return lineManager;
    }

    public void setLineManager(String lineManager) {
        this.lineManager = lineManager;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
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

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getDelDt() {
        return delDt;
    }

    public void setDelDt(String delDt) {
        this.delDt = delDt;
    }

    public String getDelId() {
        return delId;
    }

    public void setDelId(String delId) {
        this.delId = delId;
    }

    public String getDelFg() {
        return delFg;
    }

    public void setDelFg(String delFg) {
        this.delFg = delFg;
    }

    //编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。
    @Override
    //返回参数名称和值
    public String toString() {
        return "MEmployee{" +
                "bu=" + bu +
                ", company=" + company +
                ", department=" + department +
                ", name=" + name +
                ", email=" + email +
                ", agentPhone=" + agentPhone +
                ", job=" + job +
                ", level=" + level +
                ", degree=" + degree +
                ", professional=" + professional +
                ", state=" + state +
                ", employeeType=" + employeeType +
                ", inSocietyDate=" + inSocietyDate +
                ", turnPositiveDate=" + turnPositiveDate +
                ", leavingDate=" + leavingDate +
                ", costCenter=" + costCenter +
                ", function=" + function +
                ", effect=" + effect +
                ", manager=" + lineManager +
                ", workPlace=" + workPlace +
                ", entDt=" + entDt +
                ", entId=" + entId +
                ", updDt=" + updDt +
                ", updId=" + updId +
                ", delDt=" + delDt +
                ", delId=" + delId +
                ", delFg=" + delFg +
        "}";
    }
}
