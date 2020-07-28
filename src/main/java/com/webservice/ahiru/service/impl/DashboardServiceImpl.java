package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.entity.Dashboard;
import com.webservice.ahiru.entity.DashboardData;
import com.webservice.ahiru.entity.DashboardSeries;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.DashboardMapper;
import com.webservice.ahiru.service.DashboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private Logger logger = LoggerFactory.getLogger(DashboardServiceImpl.class);

    @Autowired
    private DashboardMapper dashboardMapper;

    public Dashboard getProjectSituation(String changeMonth, String pmId, String department) {
        logger.info("*******getProjectSituation Start********");
        try {
            if (changeMonth.equals("0")) {
                changeMonth = "";
            }
            Dashboard dashboard = new Dashboard();
            dashboard = dashboardMapper.getProjectSituation(changeMonth, pmId, department);
            logger.info("*******getProjectSituation End********");
            return dashboard;

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("getProjectSituation失败");
        }
    }

    public Dashboard getAidedData(String changeMonth, String pmId, String department) {
        logger.info("*******getAidedData Start********");
        try {
            if (changeMonth.equals("0")) {
                changeMonth = "";
            }
            Dashboard dashboard = new Dashboard();
            dashboard = dashboardMapper.getAidedData(changeMonth, pmId, department);
            logger.info("*******getAidedData End********");
            return dashboard;

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("getAidedData失败");
        }
    }

    public DashboardData getAllProjectByMonth(String pmId, String department) {
        logger.info("*******getAllProjectByMonth Start********");
        try {
            DashboardData data = new DashboardData();
            List<Dashboard> dashboardList = new ArrayList<>();
            dashboardList = dashboardMapper.getAllProjectByMonth(pmId, department);
            List<String> categories = new ArrayList<>();
            categories.add("1月");
            categories.add("2月");
            categories.add("3月");
            categories.add("4月");
            categories.add("5月");
            categories.add("6月");
            categories.add("7月");
            categories.add("8月");
            categories.add("9月");
            categories.add("10月");
            categories.add("11月");
            categories.add("12月");
            data.setCategories(categories);
            List<DashboardSeries> seriesList = new ArrayList<>();
            DashboardSeries seriesAllNotIdle = new DashboardSeries();
            DashboardSeries seriesAllIdle = new DashboardSeries();
            DashboardSeries seriesAllBackUp = new DashboardSeries();
            seriesAllNotIdle.setName("非空闲");
            seriesAllIdle.setName("空闲");
            seriesAllBackUp.setName("Backup");
            List<Integer> allNotIdle = new ArrayList<>();
            List<Integer> allFull = new ArrayList<>();
            List<Integer> allNotFull = new ArrayList<>();
            List<Integer> allIdle = new ArrayList<>();
            List<Integer> allBackUp = new ArrayList<>();
            List<Double> fullProp = new ArrayList<>();
            List<Double> notFullProp = new ArrayList<>();
            List<Double> idleProp = new ArrayList<>();
            List<Double> backUpProp = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                allFull.add(0);
                allNotFull.add(0);
                allIdle.add(0);
                allBackUp.add(0);
            }
            for (int i = 0; i < dashboardList.size(); i++) {
                if (dashboardList.get(i).getUseStatus().equals("2")) {
                    allFull.set(Integer.valueOf(dashboardList.get(i).getMonth()) - 1, Integer.parseInt(dashboardList.get(i).getCount()));
                } else if (dashboardList.get(i).getUseStatus().equals("1")) {
                    allNotFull.set(Integer.valueOf(dashboardList.get(i).getMonth()) - 1, Integer.parseInt(dashboardList.get(i).getCount()));
                } else if (dashboardList.get(i).getUseStatus().equals("0")) {
                    allIdle.set(Integer.valueOf(dashboardList.get(i).getMonth()) - 1, Integer.parseInt(dashboardList.get(i).getCount()));
                } else if (dashboardList.get(i).getUseStatus().equals("3")) {
                    allBackUp.set(Integer.valueOf(dashboardList.get(i).getMonth()) - 1, Integer.parseInt(dashboardList.get(i).getCount()));
                }
            }
            for (int j = 0; j < allFull.size(); j++) {
                int sum = allFull.get(j) + allNotFull.get(j) + allIdle.get(j) + allBackUp.get(j);
                fullProp.add(new BigDecimal((float) allFull.get(j) / sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                notFullProp.add(new BigDecimal((float) allNotFull.get(j) / sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                idleProp.add(new BigDecimal((float) allIdle.get(j) / sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                backUpProp.add(new BigDecimal((float) allBackUp.get(j) / sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
            for(int x=0;x<allFull.size();x++){
                allNotIdle.add(allFull.get(x)+allNotFull.get(x));
            }
            seriesAllNotIdle.setData(allNotIdle);
            seriesAllIdle.setData(allIdle);
            seriesAllBackUp.setData(allBackUp);
            seriesList.add(seriesAllNotIdle);
            seriesList.add(seriesAllIdle);
            seriesList.add(seriesAllBackUp);
            data.setSeries(seriesList);
            logger.info("*******getAidedData End********");
            return data;

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("getAidedData失败");
        }
    }

    public DashboardData getAllAidedByMonth(String pmId, String department){
        logger.info("*******getAllAidedByMonth Start********");
        try{
            DashboardData dashboardData = new DashboardData();
            List<Dashboard> dashboardList = new ArrayList<>();
            dashboardList = dashboardMapper.getAllAidedByMonth(pmId,department);
            List<DashboardSeries> seriesList = new ArrayList<>();
            List<String> categories = new ArrayList<>();
            categories.add("1月");
            categories.add("2月");
            categories.add("3月");
            categories.add("4月");
            categories.add("5月");
            categories.add("6月");
            categories.add("7月");
            categories.add("8月");
            categories.add("9月");
            categories.add("10月");
            categories.add("11月");
            categories.add("12月");
            for(int i=0;i<dashboardList.size();i++){
                DashboardSeries series = new DashboardSeries();
                List<Double> aidedList = new ArrayList<>();
                aidedList.add(Double.valueOf(dashboardList.get(i).getOne()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getTwo()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getThree()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getFour()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getFive()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getSix()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getSeven()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getEight()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getNine()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getTen()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getEleven()));
                aidedList.add(Double.valueOf(dashboardList.get(i).getTwelve()));
                series.setName(dashboardList.get(i).getPlace());
                series.setData(aidedList);
                seriesList.add(series);
            }
            dashboardData.setSeries(seriesList);
            dashboardData.setCategories(categories);
            return dashboardData;
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("getAllAidedByMonth");
        }
    }

    public DashboardData getLevelByPmId(String pmId){
        logger.info("*******getLevelByPmId Start********");
        try {
            DashboardData data = new DashboardData();
            List<DashboardSeries> seriesList = new ArrayList<>();
            List<Dashboard> dashboardList= new ArrayList<>();
            dashboardList = dashboardMapper.getLevelByPmId(pmId);
            for(int i=0;i<dashboardList.size();i++){
                DashboardSeries series = new DashboardSeries();
                series.setName(dashboardList.get(i).getLevel());
                series.setData(Integer.valueOf(dashboardList.get(i).getLevelCount()));
                seriesList.add(series);
            }
            data.setSeries(seriesList);
            logger.info("*******getLevelByPmId End********");
            return data;

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("getLevelByPmId失败");
        }
    }

    public DashboardData getOnOff(){
        logger.info("*******getOnOff Start********");
        try {
            DashboardData data = new DashboardData();
            List<DashboardSeries> seriesList = new ArrayList<>();
            List<Dashboard> dashboardList= new ArrayList<>();
            dashboardList = dashboardMapper.getOnOff();
            DashboardSeries onSeries = new DashboardSeries();
            DashboardSeries offSeries = new DashboardSeries();
            onSeries.setName("ON");
            offSeries.setName("OFF");
            int JP = 0;
            int WF = 0;
            int DL = 0;
            for(int i=0;i<dashboardList.size();i++){
                if(dashboardList.get(i).getOnOff().equals("JP")){
                    JP = Integer.valueOf(dashboardList.get(i).getOnOffCount());
                }else if(dashboardList.get(i).getOnOff().equals("WF")){
                    WF = Integer.valueOf(dashboardList.get(i).getOnOffCount());
                }else if(dashboardList.get(i).getOnOff().equals("DL")){
                    DL = Integer.valueOf(dashboardList.get(i).getOnOffCount());
                }
            }
            onSeries.setData(JP);
            offSeries.setData(WF+DL);
            seriesList.add(onSeries);
            seriesList.add(offSeries);
            data.setSeries(seriesList);
            logger.info("*******getOnOff End********");
            return data;

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("getOnOff失败");
        }
    }
}
