package com.webservice.ahiru.entity;

public class DashboardSeries {

    //dashboard 中 series 中 name
    private String name;

    //dashboard 中 series 中 data
    private Object data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
