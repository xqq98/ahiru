package com.webservice.ahiru.entity;

public class TAomPMTeams {
    private String projectName;
    private String pmNo;
    private String year;
    private String month;
    private String jpCount;
    private String dlCount;
    private String wfCount;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPmNo() {
        return pmNo;
    }

    public void setPmNo(String pmNo) {
        this.pmNo = pmNo;
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

    public String getJpCount() {
        return jpCount;
    }

    public void setJpCount(String jpCount) {
        this.jpCount = jpCount;
    }

    public String getDlCount() {
        return dlCount;
    }

    public void setDlCount(String dlCount) {
        this.dlCount = dlCount;
    }

    public String getWfCount() {
        return wfCount;
    }

    public void setWfCount(String wfCount) {
        this.wfCount = wfCount;
    }
}
