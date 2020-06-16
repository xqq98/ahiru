package com.webservice.ahiru.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author wanghao
 * @since 2019-12-31
 */
//表名：M_EMP_DTL
@TableName("M_EMP_DTL")
public class MEmpDtl implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //员工编号
    private String employeeNo;

    //微信ID
    private String weChatId;

    private String agencyNo;

    //权限
    private String role;
//    private String depRole;
//    private String techDirection;
//    private String planLeavingDate;
//    private String leavingReason;
//    private String scheduledExitDt;
//    private String entDt;
//    private String entId;
//    private String updDt;
//    private String updId;
//    private String delDt;
//    private String delId;
//    private String delFg;

    //系统当前时间
    private String currenttime;

    public String getAgencyNo() {
        return agencyNo;
    }

    public void setAgencyNo(String agencyNo) {
        this.agencyNo = agencyNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getWeChatId() {
        return weChatId;
    }

    public void setWeChatId(String weChatId) {
        this.weChatId = weChatId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
    }

//    public String getDepRole() {
//        return depRole;
//    }
//
//    public void setDepRole(String depRole) {
//        this.depRole = depRole;
//    }
//
//    public String getTechDirection() {
//        return techDirection;
//    }
//
//    public void setTechDirection(String techDirection) {
//        this.techDirection = techDirection;
//    }
//
//    public String getPlanLeavingDate() {
//        return planLeavingDate;
//    }
//
//    public void setPlanLeavingDate(String planLeavingDate) {
//        this.planLeavingDate = planLeavingDate;
//    }
//
//    public String getLeavingReason() {
//        return leavingReason;
//    }
//
//    public void setLeavingReason(String leavingReason) {
//        this.leavingReason = leavingReason;
//    }
//
//    public String getScheduledExitDt() {
//        return scheduledExitDt;
//    }
//
//    public void setScheduledExitDt(String scheduledExitDt) {
//        this.scheduledExitDt = scheduledExitDt;
//    }
//
//    public String getEntDt() {
//        return entDt;
//    }
//
//    public void setEntDt(String entDt) {
//        this.entDt = entDt;
//    }
//
//    public String getEntId() {
//        return entId;
//    }
//
//    public void setEntId(String entId) {
//        this.entId = entId;
//    }
//
//    public String getUpdDt() {
//        return updDt;
//    }
//
//    public void setUpdDt(String updDt) {
//        this.updDt = updDt;
//    }
//
//    public String getUpdId() {
//        return updId;
//    }
//
//    public void setUpdId(String updId) {
//        this.updId = updId;
//    }
//
//    public String getDelDt() {
//        return delDt;
//    }
//
//    public void setDelDt(String delDt) {
//        this.delDt = delDt;
//    }
//
//    public String getDelId() {
//        return delId;
//    }
//
//    public void setDelId(String delId) {
//        this.delId = delId;
//    }

//    public String getDelFg() {
//        return delFg;
//    }
//
//    public void setDelFg(String delFg) {
//        this.delFg = delFg;
//    }

    //编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。
    @Override
    //返回参数名称和值
    public String toString() {
        return "MEmpDtl{" +
                "employeeNo=" + employeeNo +
                ", weChatId=" + weChatId +
                ", role=" + role +
                ", currenttime=" + currenttime +
//                ", depRole=" + depRole +
//                ", techDirection=" + techDirection +
//                ", planLeavingDate=" + planLeavingDate +
//                ", leavingReason=" + leavingReason +
//                ", scheduledExitDt=" + scheduledExitDt +
//                ", entDt=" + entDt +
//                ", entId=" + entId +
//                ", updDt=" + updDt +
//                ", updId=" + updId +
//                ", delDt=" + delDt +
//                ", delId=" + delId +
//                ", delFg=" + delFg +
        "}";
    }

}
