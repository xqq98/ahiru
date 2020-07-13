package com.webservice.ahiru.entity;

import java.util.List;

public class TAomDtlSeries{
    private String name;
    private List<Float> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Float> getData() {
        return data;
    }

    public void setData(List<Float> data) {
        this.data = data;
    }
}
