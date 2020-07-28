package com.webservice.ahiru.mapper;


import com.webservice.ahiru.entity.Dashboard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DashboardMapper {

    //获取人员项目状况   0   1   2   3
    public Dashboard getProjectSituation(String changeMonth,String pmId,String department);

    //获取受注数据  JP  WF  DL
    public Dashboard getAidedData(String changeMonth,String pmId,String department);

    //获取人员项目状况折线图数据
    public List<Dashboard> getAllProjectByMonth(String pmId,String department);

    //获取受注数据 1-12月份
    public List<Dashboard> getAllAidedByMonth(String pmId,String department);

    //获取职级信息
    public List<Dashboard> getLevelByPmId (String pmId);

    //获取ON/OFF信息
    public List<Dashboard> getOnOff();
}
