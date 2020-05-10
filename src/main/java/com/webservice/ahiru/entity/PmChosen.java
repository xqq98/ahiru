package com.webservice.ahiru.entity;

import java.util.List;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author yuqiang
 * @since 2020-2-17
 */

public class PmChosen {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //员工编号
    private String id;

    //员工姓名
    private String name;

    //级别
    private String level;

    //部门编号
    private String depRole;

    //部门名称
    private String hanyouValueName;

    //年
    private String year;
    //当月pmnum
    private String pmNum;
    //当月pmname
    private String pmName;
    //1月
    private String a1;


    //2月
    private String a2;


    //3月
    private String a3;


    //4月
    private String a4;


    //5月
    private String a5;


    //6月
    private String a6;


    //7月
    private String a7;


    //8月
    private String a8;


    //9月
    private String a9;


    //10月
    private String a10;


    //11月
    private String a11;


    //12月
    private String a12;
    private List<String> monthList;

    private String startDt;
    private String endDt;

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public List<String> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepRole() {
        return depRole;
    }

    public void setDepRole(String depRole) {
        this.depRole = depRole;
    }

    public String getHanyouValueName() {
        return hanyouValueName;
    }

    public void setHanyouValueName(String hanyouValueName) {
        this.hanyouValueName = hanyouValueName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPmNum() {
        return pmNum;
    }

    public void setPmNum(String pmNum) {
        this.pmNum = pmNum;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public String getA6() {
        return a6;
    }

    public void setA6(String a6) {
        this.a6 = a6;
    }

    public String getA7() {
        return a7;
    }

    public void setA7(String a7) {
        this.a7 = a7;
    }

    public String getA8() {
        return a8;
    }

    public void setA8(String a8) {
        this.a8 = a8;
    }

    public String getA9() {
        return a9;
    }

    public void setA9(String a9) {
        this.a9 = a9;
    }

    public String getA10() {
        return a10;
    }

    public void setA10(String a10) {
        this.a10 = a10;
    }

    public String getA11() {
        return a11;
    }

    public void setA11(String a11) {
        this.a11 = a11;
    }

    public String getA12() {
        return a12;
    }

    public void setA12(String a12) {
        this.a12 = a12;
    }


//    private String month;
//
//    public String getMonth() {
//        SimpleDateFormat df = new SimpleDateFormat("MM");
//        this.month = (df.format(new Date()));
//        return month;
//    }


}
