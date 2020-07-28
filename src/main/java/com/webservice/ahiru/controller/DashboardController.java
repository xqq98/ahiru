package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.Dashboard;
import com.webservice.ahiru.entity.DashboardData;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.DashboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class  DashboardController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping("/test")
    public Result test(){
        Result result = new Result("OK");
        return result;
    }

    //人员项目状况  0   1   2   3
    @RequestMapping(value = "/getProjectSituation", method = RequestMethod.POST)
    public Result getProjectSituation(@RequestParam("changeMonth") String changeMonth,@RequestParam("pmId") String pmId,@RequestParam("department") String department){
        logger.info("*******getProjectSituation start********");
        Dashboard dashboard = new Dashboard();
        dashboard = dashboardService.getProjectSituation(changeMonth,pmId,department);
        Result result = Result.ok(dashboard);
        logger.info("*******getProjectSituation end********");
        return  result;
    }

    //受注信息
    @RequestMapping(value = "/getAidedData", method = RequestMethod.POST)
    public Result getAidedData(@RequestParam("changeMonth") String changeMonth,@RequestParam("pmId") String pmId,@RequestParam("department") String department){
        logger.info("*******getAidedData start********");
        Dashboard dashboard = new Dashboard();
        dashboard = dashboardService.getAidedData(changeMonth,pmId,department);
        Result result = Result.ok(dashboard);
        logger.info("*******getAidedData end********");
        return result;
    }

    //人员项目折线
    @RequestMapping(value = "/getAllProjectByMonth", method = RequestMethod.POST)
    public Result getAllProjectByMonth(@RequestParam("pmId") String pmId,@RequestParam("department") String department){
        logger.info("*******getAllProjectByMonth start********");
        DashboardData dashboardData = new DashboardData();
        dashboardData = dashboardService.getAllProjectByMonth(pmId,department);
        Result result = Result.ok(dashboardData);
        logger.info("*******getAllProjectByMonth end********");
        return result;
    }

    //受注数据柱状
    @RequestMapping(value = "/getAllAidedByMonth", method = RequestMethod.POST)
    public Result getAllAidedByMonth(@RequestParam("pmId") String pmId,@RequestParam("department") String department){
        logger.info("*******getAllAidedByMonth start********");
        DashboardData dashboardData = new DashboardData();
        dashboardData = dashboardService.getAllAidedByMonth(pmId,department);
        Result result = Result.ok(dashboardData);
        logger.info("*******getAllAidedByMonth end********");
        return result;
    }

    //PM职级数据获取  getLevelByPmId
    @RequestMapping(value = "/getLevelByPmId", method = RequestMethod.POST)
    public Result getLevelByPmId(@RequestParam("pmId") String pmId){
        logger.info("*******getLevelByPmId start********");
        DashboardData dashboardData = new DashboardData();
        dashboardData = dashboardService.getLevelByPmId(pmId);
        Result result = Result.ok(dashboardData);
        logger.info("*******getLevelByPmId end********");
        return result;
    }

    //ON/OFF数据信息获取  getOnOff()
    @RequestMapping(value = "/getOnOff", method = RequestMethod.POST)
    public Result getOnOff(){
        logger.info("*******getOnOff start********");
        DashboardData dashboardData = new DashboardData();
        dashboardData = dashboardService.getOnOff();
        Result result = Result.ok(dashboardData);
        logger.info("*******getOnOff end********");
        return result;
    }

}
