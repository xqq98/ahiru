package com.webservice.ahiru.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("V_AOM_DTL")
public class VAomDtl implements Serializable {
    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    private String id;
    private String team;
    private String projectName;
    private String dept;
    private String businessField;
    private String contractualRelation;
    private String pmNo;
    private String pmName;
    private String field;
    private String fieldName;
    private String workPlace;
    private String workPlaceName;
    private String year;
    private String month;
    private Float times;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getWorkPlaceName() {
        return workPlaceName;
    }

    public void setWorkPlaceName(String workPlaceName) {
        this.workPlaceName = workPlaceName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Float getTimes() {
        return times;
    }

    public void setTimes(Float times) {
        this.times = times;
    }

}
