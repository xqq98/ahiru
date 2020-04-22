package com.webservice.ahiru.entity;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author wanghao
 * @since 2020-2-17
 */

public class TPmPlan {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //员工编号
    private String employeeNo;

    //西年历
    private String year;

    //1月指定PM
    private String pmM1;

    //2月指定PM
    private String pmM2;

    //3月指定PM
    private String pmM3;

    //4月指定PM
    private String pmM4;

    //5月指定PM
    private String pmM5;

    //6月指定PM
    private String pmM6;

    //7月指定PM
    private String pmM7;

    //8月指定PM
    private String pmM8;

    //9月指定PM
    private String pmM9;

    //10月指定PM
    private String pmM10;

    //11月指定PM
    private String pmM11;

    //12月指定PM
    private String pmM12;

    //登陆者
    private String entDt;

    //登陆日
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

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPmM1() {
        return pmM1;
    }

    public void setPmM1(String pmM1) {
        this.pmM1 = pmM1;
    }

    public String getPmM2() {
        return pmM2;
    }

    public void setPmM2(String pmM2) {
        this.pmM2 = pmM2;
    }

    public String getPmM3() {
        return pmM3;
    }

    public void setPmM3(String pmM3) {
        this.pmM3 = pmM3;
    }

    public String getPmM4() {
        return pmM4;
    }

    public void setPmM4(String pmM4) {
        this.pmM4 = pmM4;
    }

    public String getPmM5() {
        return pmM5;
    }

    public void setPmM5(String pmM5) {
        this.pmM5 = pmM5;
    }

    public String getPmM6() {
        return pmM6;
    }

    public void setPmM6(String pmM6) {
        this.pmM6 = pmM6;
    }

    public String getPmM7() {
        return pmM7;
    }

    public void setPmM7(String pmM7) {
        this.pmM7 = pmM7;
    }

    public String getPmM8() {
        return pmM8;
    }

    public void setPmM8(String pmM8) {
        this.pmM8 = pmM8;
    }

    public String getPmM9() {
        return pmM9;
    }

    public void setPmM9(String pmM9) {
        this.pmM9 = pmM9;
    }

    public String getPmM10() {
        return pmM10;
    }

    public void setPmM10(String pmM10) {
        this.pmM10 = pmM10;
    }

    public String getPmM11() {
        return pmM11;
    }

    public void setPmM11(String pmM11) {
        this.pmM11 = pmM11;
    }

    public String getPmM12() {
        return pmM12;
    }

    public void setPmM12(String pmM12) {
        this.pmM12 = pmM12;
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
