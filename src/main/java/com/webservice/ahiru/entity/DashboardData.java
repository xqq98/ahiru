package com.webservice.ahiru.entity;

import java.util.List;

public class DashboardData {

    private List<String> categories;

    private List<DashboardSeries> series;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<DashboardSeries> getSeries() {
        return series;
    }

    public void setSeries(List<DashboardSeries> series) {
        this.series = series;
    }
}
