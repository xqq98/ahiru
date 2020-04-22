package com.webservice.ahiru.entity;

import java.io.Serializable;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author yanyan
 * @since 2019-12-25
 */
public class MProject implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //ID
    private String id;

    //PM员工号
    private String pmemployeeno;

    //项目编号
    private String projectid;

    //项目名称
    private String projectname;

    //案件名称
    private String casename;

    //登陆日
    private String entdt;

    //登录者
    private String entid;

    //修改日
    private String upddt;

    //修改者
    private String updid;

    //删除日
    private String deldt;

    //删除者
    private String delid;

    //删除标志
    private String delfg;


    public String getPmemployeeno() {
        return pmemployeeno;
    }

    public void setPmemployeeno(String pmemployeeno) {
        this.pmemployeeno = pmemployeeno;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getEntdt() {
        return entdt;
    }

    public void setEntdt(String entdt) {
        this.entdt = entdt;
    }

    public String getEntid() {
        return entid;
    }

    public void setEntid(String entid) {
        this.entid = entid;
    }

    public String getUpddt() {
        return upddt;
    }

    public void setUpddt(String upddt) {
        this.upddt = upddt;
    }

    public String getUpdid() {
        return updid;
    }

    public void setUpdid(String updid) {
        this.updid = updid;
    }

    public String getDeldt() {
        return deldt;
    }

    public void setDeldt(String deldt) {
        this.deldt = deldt;
    }

    public String getDelid() {
        return delid;
    }

    public void setDelid(String delid) {
        this.delid = delid;
    }

    public String getDelfg() {
        return delfg;
    }

    public void setDelfg(String delfg) {
        this.delfg = delfg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
