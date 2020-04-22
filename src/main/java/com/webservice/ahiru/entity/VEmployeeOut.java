package com.webservice.ahiru.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author lijunchen
 * @since 2020-03-09
 */
//视图名：V_EMPLOYEE_OUT
@TableName("V_EMP_OUT")
public class VEmployeeOut implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //员工编号
    private String id;

    //员工姓名
    private String name;

    //公司名称
    private String company;

    //协力公司名称
    private String vendorCompany;

    //经理
    private String manager;

    //工作场所
    private String workPlace;

    //部门
    private String bu;

    //所属部门
    private String department;

    //邮箱号
    private String email;

    //电话号
    private String agentPhone;

    //职称
    private String job;

    //级别
    private String level;

    //程度
    private String degree;

    //专业
    private String professional;

    //状态
    private String state;

    //雇佣类型
    private String employeeType;

    //入职时间
    private String inSocietyDate;

    //转正时间
    private String turnPositiveDate;

    //离职时间
    private String leavingDate;

    //离职时间（起始）
    private String startLeaving;

    //离职时间（结束）
    private String endLeaving;

    //成本
    private String costCenter;

    //功能
    private String function;

    //影响
    private String effect;

    //项目编号
    private String pid;

    //认证
    private String ccc;

    //准入日
    private String admissionDt;

    //合同日
    private String contractDt;

    //退出日
//    private String scheduledExitDt;

    //技能
    private String skills;

    //登陆日
    private String entDt;

    //登陆者
    private String entId;

    //更新日
    private String updDt;

    //更新者
    private String updId;

    //删除日
    private String delDt;

    //删除者
    private String delId;

    //削除フラグ
    private String delFg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVendorCompany() {
        return vendorCompany;
    }

    public void setVendorCompany(String vendorCompany) {
        this.vendorCompany = vendorCompany;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getStartLeaving() {
        return startLeaving;
    }

    public void setStartLeaving(String startLeaving) {
        this.startLeaving = startLeaving;
    }

    public String getEndLeaving() {
        return endLeaving;
    }

    public void setEndLeaving(String endLeaving) {
        this.endLeaving = endLeaving;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public String getAdmissionDt() {
        return admissionDt;
    }

    public void setAdmissionDt(String admissionDt) {
        this.admissionDt = admissionDt;
    }

    public String getContractDt() {
        return contractDt;
    }

    public void setContractDt(String contractDt) {
        this.contractDt = contractDt;
    }

//    public String getScheduledExitDt() {
//        return scheduledExitDt;
//    }
//
//    public void setScheduledExitDt(String scheduledExitDt) {
//        this.scheduledExitDt = scheduledExitDt;
//    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
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
        return "VEmployeeOUT{" +
                "id=" + id +
                ", name=" + name +
                ", company=" + company +
                ", vendorCompany=" + vendorCompany +
                ", manager=" + manager +
                ", workPlace=" + workPlace +
                ", bu=" + bu +
                ", department=" + department +
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
                ", startLeaving=" + startLeaving +
                ", endLeaving=" + endLeaving +
                ", costCenter=" + costCenter +
                ", function=" + function +
                ", effect=" + effect +
                ", pid=" + pid +
                ", ccc=" + ccc +
                ", admissionDt=" + admissionDt +
                ", contractDt=" + contractDt +
//        ", scheduledExitDt=" + scheduledExitDt +
                ", skills=" + skills +
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
