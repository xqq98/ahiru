package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.EmployeeWork;
import com.webservice.ahiru.entity.EmployeeWorkYear;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.EmployeeWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangenji
 * @since 2019-11-18
 */

//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/view”的URL请求
@RequestMapping("/view")
public class EmployeeWorkController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(EmployeeWorkController.class);

    //Service接口的实现类
   @Autowired
    private EmployeeWorkService employeeWorkService;

    @RequestMapping(value = "/getInfo",
            method = RequestMethod.POST)
    public Result getEmployeeWorkInfo(@RequestBody EmployeeWorkYear employeeWorkYear){
        logger.info("*******getEmployeeWorkInfo start********");
        List<EmployeeWorkYear> employeeWorkYearList=employeeWorkService.getEmployeeWorkInfo(employeeWorkYear);
        Result result = Result.ok(employeeWorkYearList);
        logger.info("*******getEmployeeWorkInfo start********");
        return result;
    }
    @RequestMapping(value = "/getDetail",
            method = RequestMethod.POST)
    public Result getEmployeeWorkDetail(@RequestBody EmployeeWork employeeWork){
        logger.info("*******getEmployeeWorkInfo start********");
        List<EmployeeWork> employeeWorkList=employeeWorkService.getEmployeeWorkDetail(employeeWork);
        Result result = Result.ok(employeeWorkList);
        logger.info("*******getEmployeeWorkInfo start********");
        return result;
    }
    @RequestMapping(value = "/upd",
            method = RequestMethod.POST)
    public Result uptEmployeeWorkInfo(@RequestBody List employeeWorkList){
        logger.info("*******uptEmployeeWorkInfo start********");
        employeeWorkService.uptEmployeeWorkInfo(employeeWorkList);
        logger.info("*******uptEmployeeWorkInfo end********");
        return Result.ok();
    }
}


