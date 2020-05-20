package com.webservice.ahiru.entity;

public class EmpWokeDto extends EmployeeWork {
    private String[] useStatusArr;

    private String[] caseIdArr;

    private String[] caseNameArr;

    private String[] workNoArr;

    private String[] pmIdArr;

    private String[] proIdArr;

    public String[] getPmIdArr() {
        return pmIdArr;
    }

    public void setPmIdArr(String[] pmIdArr) {
        this.pmIdArr = pmIdArr;
    }

    public String[] getWorkNoArr() {
        return workNoArr;
    }

    public void setWorkNoArr(String[] workNoArr) {
        this.workNoArr = workNoArr;
    }

    public String[] getUseStatusArr() {
        return useStatusArr;
    }

    public void setUseStatusArr(String[] useStatusArr) {
        this.useStatusArr = useStatusArr;
    }

    public String[] getCaseIdArr() {
        return caseIdArr;
    }

    public void setCaseIdArr(String[] caseIdArr) {
        this.caseIdArr = caseIdArr;
    }

    public String[] getCaseNameArr() {
        return caseNameArr;
    }

    public void setCaseNameArr(String[] caseNameArr) {
        this.caseNameArr = caseNameArr;
    }

    public String[] getProIdArr() {
        return proIdArr;
    }

    public void setProIdArr(String[] proIdArr) {
        this.proIdArr = proIdArr;
    }
}
