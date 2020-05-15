package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.EmpWokeDto;
import com.webservice.ahiru.entity.EmployeeWork;
import com.webservice.ahiru.entity.EmployeeWorkYear;
import com.webservice.ahiru.entity.SEVEmpList;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.EmployeeWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
    public Result getEmployeeWorkInfo(@RequestBody SEVEmpList sEVEmpList){
        logger.info("*******getEmployeeWorkInfo start********");
        List<EmployeeWorkYear> employeeWorkYearList=employeeWorkService.getEmployeeWorkInfo(sEVEmpList);
        Result result = Result.ok(employeeWorkYearList);
        logger.info("*******getEmployeeWorkInfo start********");
        return result;
    }
    @RequestMapping(value = "/getDetail",
            method = RequestMethod.POST)
    public Result getEmployeeWorkDetail(@RequestBody EmployeeWork employeeWork){
        logger.info("*******getEmployeeWorkInfo start********");
       EmpWokeDto empWork=employeeWorkService.getEmployeeWorkDetail(employeeWork);
        Result result = Result.ok(empWork);
        logger.info("*******getEmployeeWorkInfo start********");
        return result;
    }
    @RequestMapping(value = "/upd",
            method = RequestMethod.POST)
    public Result uptEmployeeWorkInfo(@RequestBody List<EmployeeWork> employeeWorkList){
        logger.info("*******uptEmployeeWorkInfo start********");
        employeeWorkService.uptEmployeeWorkInfo(employeeWorkList);
        logger.info("*******uptEmployeeWorkInfo end********");
        return Result.ok();
    }
    @RequestMapping("/getsession")
    public String getSession(HttpServletRequest req){
        logger.info("*******getSession start********");
        HttpSession session = req.getSession();
        logger.info((String)session.getAttribute("test"));
        session.setAttribute("test","aabbcc");
        logger.info(session.getId());

        return session.getId();
    }
}


