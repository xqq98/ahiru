package com.webservice.ahiru.entity;
/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author Rocky.Yu
 * @since 2020-01-15
 */
public class TEmpWork {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //工作情况编号
    private String workNo;

    //员工编号
    private String employeeNo;

    //PM编号
    private String pmEmployeeNo;

    //韩广晨 2020-04-21 Begin
    //作业名
    private String caseName;
    //韩广晨 2020-04-21 End

    //作业id
    private String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    //项目编号
    private String projectId;

    //西年历
    private String year;

    //使用月
    private String useMonth;

    //使用状況
    private String useStatus;

    //备考
    private String useMemo;

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

    //删除标志
    private String delFg;



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

    public String getPmEmployeeNo() { return pmEmployeeNo; }

    public void setPmEmployeeNo(String pmEmployeeNo) {
        this.pmEmployeeNo = pmEmployeeNo;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    //韩广晨 2020-04-21 Begin
    public String getCaseName(){return caseName;}

    public void setCaseName(String caseName){this.caseName=caseName;}
    //韩广晨 2020-04-21 End

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
