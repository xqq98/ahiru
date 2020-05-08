package com.webservice.ahiru.entity;

public class EmpWokeDto extends EmployeeWork {
    private String[] useStatusArr;

    private String[] caseIdArr;

    private String[] caseNameArr;

    private String[] workNoArr;

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

}
