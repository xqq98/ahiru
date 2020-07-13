package com.webservice.ahiru.entity;

import java.util.List;

public class TAomDtlPMItem {

    private String pmNo;
    private String team;
    private List<String> tAomDtlCategories;
    private List<TAomDtlSeries> tAomDtlSeries;

    public String getPmNo() {
        return pmNo;
    }

    public void setPmNo(String pmNo) {
        this.pmNo = pmNo;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    public List<String> gettAomDtlCategories() {
        return tAomDtlCategories;
    }

    public void settAomDtlCategories(List<String> tAomDtlCategories) {
        this.tAomDtlCategories = tAomDtlCategories;
    }

    public List<TAomDtlSeries> gettAomDtlSeries() {
        return tAomDtlSeries;
    }

    public void settAomDtlSeries(List<TAomDtlSeries> tAomDtlSeries) {
        this.tAomDtlSeries = tAomDtlSeries;
    }
}
