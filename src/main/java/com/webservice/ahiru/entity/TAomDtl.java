package com.webservice.ahiru.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("T_AOM_DTL")
public class TAomDtl implements Serializable {
    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    private String id;
    private String team;
    private String businessField;
    private String contractualRelation;
    private String pmNo;
    private String pmName;
    private String field;
    private String workPlace;
    private String year;
    private Float janNo;
    private Float febNo;
    private Float marNo;
    private Float aprNo;
    private Float mayNo;
    private Float junNo;
    private Float julNo;
    private Float augNo;
    private Float sepNo;
    private Float octNo;
    private Float novNo;
    private Float decNo;
    private Float sumHours;
    private String entDt;
    private String entId;
    private String updDt;
    private String updId;
    private String delDt;
    private String delID;
    private String delFg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getBusinessField() {
        return businessField;
    }

    public void setBusinessField(String businessField) {
        this.businessField = businessField;
    }

    public String getContractualRelation() {
        return contractualRelation;
    }

    public void setContractualRelation(String contractualRelation) {
        this.contractualRelation = contractualRelation;
    }

    public String getPmNo() {
        return pmNo;
    }

    public void setPmNo(String pmNo) {
        this.pmNo = pmNo;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Float getJanNo() {
        return janNo;
    }

    public void setJanNo(Float janNo) {
        this.janNo = janNo;
    }


    public Float getFebNo() {
        return febNo;
    }

    public void setFebNo(Float febNo) {
        this.febNo = febNo;
    }

    public Float getMarNo() {
        return marNo;
    }

    public void setMarNo(Float marNo) {
        this.marNo = marNo;
    }

    public Float getAprNo() {
        return aprNo;
    }

    public void setAprNo(Float aprNo) {
        this.aprNo = aprNo;
    }

    public Float getMayNo() {
        return mayNo;
    }

    public void setMayNo(Float mayNo) {
        this.mayNo = mayNo;
    }

    public Float getJunNo() {
        return junNo;
    }

    public void setJunNo(Float junNo) {
        this.junNo = junNo;
    }

    public Float getJulNo() {
        return julNo;
    }

    public void setJulNo(Float julNo) {
        this.julNo = julNo;
    }

    public Float getAugNo() {
        return augNo;
    }

    public void setAugNo(Float augNo) {
        this.augNo = augNo;
    }

    public Float getSepNo() {
        return sepNo;
    }

    public void setSepNo(Float sepNo) {
        this.sepNo = sepNo;
    }

    public Float getOctNo() {
        return octNo;
    }

    public void setOctNo(Float octNo) {
        this.octNo = octNo;
    }

    public Float getNovNo() {
        return novNo;
    }

    public void setNovNo(Float novNo) {
        this.novNo = novNo;
    }

    public Float getDecNo() {
        return decNo;
    }

    public void setDecNo(Float decNo) {
        this.decNo = decNo;
    }

    public Float getSumHours() {
        return sumHours;
    }

    public void setSumHours(Float sumHours) {
        this.sumHours = sumHours;
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

    public String getDelID() {
        return delID;
    }

    public void setDelID(String delID) {
        this.delID = delID;
    }

    public String getDelFg() {
        return delFg;
    }

    public void setDelFg(String delFg) {
        this.delFg = delFg;
    }
}

