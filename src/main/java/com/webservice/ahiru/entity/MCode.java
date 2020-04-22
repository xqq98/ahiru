package com.webservice.ahiru.entity;

import java.io.Serializable;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author mengliang
 * @since 2020-1-7
 */

public class MCode implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //通用代码
    private String hanYouCode;

    //通用代码名称
    private String hanYouCodeName;

    //通用代码实例
    private String hanYouValue;

    //通用代码实例名
    private String hanYouValueName;

    //任意項目１
    private String niNiKouMoKu1;

    //任意項目名１
    private String niNiKoMoKunm1;

    //任意項目２
    private String niNiKouMoKu2;

    //任意項目名２
    private String niNiKoMoKunm2;

    //任意項目３
    private String niNiKouMoKu3;

    //任意項目名３
    private String niNiKoMoKunm3;

    //任意項目４
    private String niNiKouMoKu4;

    //任意項目名４
    private String niNiKoMoKunm4;

    //任意項目５
    private String niNiKouMoKu5;

    //任意項目名５
    private String niNiKoMoKunm5;

    //削除フラグ
    private String delFg;

    //更新日
    private String updDt;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getHanYouCodeName() {
        return hanYouCodeName;
    }

    public void setHanYouCodeName(String hanYouCodeName) {
        this.hanYouCodeName = hanYouCodeName;
    }

    public String getNiNiKouMoKu1() {
        return niNiKouMoKu1;
    }

    public void setNiNiKouMoKu1(String niNiKouMoKu1) {
        this.niNiKouMoKu1 = niNiKouMoKu1;
    }

    public String getNiNiKoMoKunm1() {
        return niNiKoMoKunm1;
    }

    public void setNiNiKoMoKunm1(String niNiKoMoKunm1) {
        this.niNiKoMoKunm1 = niNiKoMoKunm1;
    }

    public String getNiNiKouMoKu2() {
        return niNiKouMoKu2;
    }

    public void setNiNiKouMoKu2(String niNiKouMoKu2) {
        this.niNiKouMoKu2 = niNiKouMoKu2;
    }

    public String getNiNiKoMoKunm2() {
        return niNiKoMoKunm2;
    }

    public void setNiNiKoMoKunm2(String niNiKoMoKunm2) {
        this.niNiKoMoKunm2 = niNiKoMoKunm2;
    }

    public String getNiNiKouMoKu3() {
        return niNiKouMoKu3;
    }

    public void setNiNiKouMoKu3(String niNiKouMoKu3) {
        this.niNiKouMoKu3 = niNiKouMoKu3;
    }

    public String getNiNiKoMoKunm3() {
        return niNiKoMoKunm3;
    }

    public void setNiNiKoMoKunm3(String niNiKoMoKunm3) {
        this.niNiKoMoKunm3 = niNiKoMoKunm3;
    }

    public String getNiNiKouMoKu4() {
        return niNiKouMoKu4;
    }

    public void setNiNiKouMoKu4(String niNiKouMoKu4) {
        this.niNiKouMoKu4 = niNiKouMoKu4;
    }

    public String getNiNiKoMoKunm4() {
        return niNiKoMoKunm4;
    }

    public void setNiNiKoMoKunm4(String niNiKoMoKunm4) {
        this.niNiKoMoKunm4 = niNiKoMoKunm4;
    }

    public String getNiNiKouMoKu5() {
        return niNiKouMoKu5;
    }

    public void setNiNiKouMoKu5(String niNiKouMoKu5) {
        this.niNiKouMoKu5 = niNiKouMoKu5;
    }

    public String getNiNiKoMoKunm5() {
        return niNiKoMoKunm5;
    }

    public void setNiNiKoMoKunm5(String niNiKoMoKunm5) {
        this.niNiKoMoKunm5 = niNiKoMoKunm5;
    }

    public String getUpdDt() {
        return updDt;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getHanYouCode() {
        return hanYouCode;
    }

    public void setHanYouCode(String hanYouCode) {
        this.hanYouCode = hanYouCode;
    }

    public String getHanYouValue() {
        return hanYouValue;
    }

    public void setHanYouValue(String hanYouValue) {
        this.hanYouValue = hanYouValue;
    }

    public String getHanYouValueName() {
        return hanYouValueName;
    }

    public void setHanYouValueName(String hanYouValueName) {
        this.hanYouValueName = hanYouValueName;
    }

    public String getDelFg() {
        return delFg;
    }

    public void setDelFg(String delFg) {
        this.delFg = delFg;
    }
}
