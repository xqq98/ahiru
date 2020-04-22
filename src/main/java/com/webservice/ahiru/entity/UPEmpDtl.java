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
@TableName("M_EMP_DTL")
public class UPEmpDtl implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //员工编号
    private String id;
//    private String weChatId;
//    private String role;
    //部门权限
    private String depRole;

    //技术方向
    private String tech;

    //计划离职日期
    private String outDate;

    //离职原因
    private String outRsn;
//    private String scheduledExitDt;
    //判断员工类型
    private String bpflg;
//    private String entDt;
//    private String entId;
//    private String updDt;
//    private String updId;
//    private String delDt;
//    private String delId;
//    private String delFg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepRole() {
        return depRole;
    }

    public void setDepRole(String depRole) {
        this.depRole = depRole;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getOutRsn() {
        return outRsn;
    }

    public void setOutRsn(String outRsn) {
        this.outRsn = outRsn;
    }

    public String getBpflg() { return bpflg; }

    public void setBpflg(String bpflg) {
        this.bpflg = bpflg;
    }
}
