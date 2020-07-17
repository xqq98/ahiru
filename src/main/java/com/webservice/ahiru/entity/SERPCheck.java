package com.webservice.ahiru.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
* <p>
* 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
* </p>
* @author liliang
* @since 2020-07-02
*/
//视图名：T_SERP_MEMBERS
@TableName("T_SERP_MEMBERS")
public class SERPCheck implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;
    // 	ID
    private String id;
    // 	プロジェクトID
    private String projectId;
    // 	年
    private String projectYear;
    // 	月
    private String projectMonth;
    // 	案件名
    private String caseName;
    // 	メンバー数
    private String projectMembers;
    // 	PM番号
    private String pmEmployeeNo;
    // 	PM名
    private String pmName;
    // 	PMメールアドレス
    private String pmEmail;
    // 	登録日
    private String entDt;
    // 	登録者
    private String entId;
    // 	更新日
    private String updDt;
    // 	更新者
    private String updId;
    // 	削除日
    private String delDt;
    // 	削除者
    private String delId;
    // 	削除フラグ
    private String delFg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectYear() {
        return projectYear;
    }

    public void setProjectYear(String projectYear) {
        this.projectYear = projectYear;
    }

    public String getProjectMonth() {
        return projectMonth;
    }

    public void setProjectMonth(String projectMonth) {
        this.projectMonth = projectMonth;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(String projectMembers) {
        this.projectMembers = projectMembers;
    }

    public String getPmEmployeeNo() {
        return pmEmployeeNo;
    }

    public void setPmEmployeeNo(String pmEmployeeNo) {
        this.pmEmployeeNo = pmEmployeeNo;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getPmEmail() {
        return pmEmail;
    }

    public void setPmEmail(String pmEmail) {
        this.pmEmail = pmEmail;
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

}
