package com.webservice.ahiru.service;

import com.webservice.ahiru.entity.Dashboard;
import com.webservice.ahiru.entity.DashboardData;

public interface DashboardService {

    public Dashboard getProjectSituation(String changeMonth,String pmId,String department);

    public Dashboard getAidedData(String changeMonth,String pmId,String department);

    public DashboardData getAllProjectByMonth(String pmId,String department);

    public DashboardData getAllAidedByMonth(String pmId,String department);

    public DashboardData getLevelByPmId(String pmId);

    public DashboardData getOnOff();
}
