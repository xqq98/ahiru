package com.webservice.ahiru.entity;

import java.util.List;

public class MProjectNew {
    private String projectid;
    private List<String> casenamelist;

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public List<String> getCasenamelist() {
        return casenamelist;
    }

    public void setCasenamelist(List<String> casenamelist) {
        this.casenamelist = casenamelist;
    }

}
