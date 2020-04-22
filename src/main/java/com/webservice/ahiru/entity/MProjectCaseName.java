package com.webservice.ahiru.entity;

import java.util.List;

public class MProjectCaseName {

    private String pmemployeeno;
    private List<String> projectidlist;
    private List<String> projectnamelist;
    private List<String> casenamelist;

    public String getPmemployeeno() {
        return pmemployeeno;
    }

    public void setPmemployeeno(String pmemployeeno) {
        this.pmemployeeno = pmemployeeno;
    }

    public List<String> getProjectidlist() {
        return projectidlist;
    }

    public void setProjectidlist(List<String> projectidlist) {
        this.projectidlist = projectidlist;
    }

    public List<String> getProjectnamelist() {
        return projectnamelist;
    }

    public void setProjectnamelist(List<String> projectnamelist) {
        this.projectnamelist = projectnamelist;
    }

    public List<String> getCasenamelist() {
        return casenamelist;
    }

    public void setCasenamelist(List<String> casenamelist) {
        this.casenamelist = casenamelist;
    }

}
