package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.EmployeeWork;
import com.webservice.ahiru.entity.EmployeeWorkYear;
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

    /**
     *
     * @Target(ElementType.METHOD) getEmployeeWorkInfo
     * @Target(ElementType.PARAMETER) @RequestBody EmployeeWork employeeWork
     * 获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中，返回对象employeeWorkList
     *
     * @author wanghao
     * @since 2020-2-14
     */

    //控制器处理“/getInfo”的URL请求，POST请求
    @RequestMapping(value = "/getInfo",
            method = RequestMethod.POST)
    public Object getEmployeeWorkInfogetEmployeeWorkInfo(@RequestBody EmployeeWork employeeWork){
        logger.info("*******getEmployeeWorkInfo start********");

       List<EmployeeWorkYear> employeeWorkList=employeeWorkService.getEmployeeWorkInfo(employeeWork);

        logger.info("*******getEmployeeWorkInfo start********");

        return employeeWorkList;
    }

    /**
     *
     * @Target(ElementType.METHOD) uptEmployeeWorkInfo
     * @Target(ElementType.PARAMETER) @RequestBody EmployeeWorkYear employeeWorkYear
     * 修改数据库表（T_EMP_WORK）的数据，修改数据后，放到对象employeeWorkYear中，返回 0
     *
     * @author wanghao
     * @since 2020-2-14
     */

    //控制器处理“/upd”的URL请求，POST请求
    @RequestMapping(value = "/upd",
            method = RequestMethod.POST)

    public Object uptEmployeeWorkInfo(@RequestBody EmployeeWorkYear employeeWorkYear){
        logger.info("*******uptEmployeeWorkInfo start********");

        employeeWorkService.uptEmployeeWorkInfo(employeeWorkYear);
        logger.info("*******uptEmployeeWorkInfo end********");
        return 0;
    }

   /**@RequestMapping(value = "/copy",
    method = RequestMethod.POST)
    public Object copyEmployeeWorkInfo(@RequestBody List<EmployeeWork> employeeWorkList){
    logger.info("*******copyEmployeeWorkInfo start********");

    employeeWorkService.copyEmployeeWorkInfo(employeeWorkList);
    logger.info("*******copyEmployeeWorkInfo end********");
    return 0;
    }*/

   //控制器处理“/getInfo”的URL请求，POST请求
   @RequestMapping(value = "/getInfoAll",
           method = RequestMethod.POST)
   public Object getEmployeeWorkInfoAll(@RequestParam("startDt") String startDt, @RequestParam("endDt") String endDt){
       logger.info("*******getEmployeeWorkInfo start********");

       List<EmployeeWorkYear> employeeWorkListAll = employeeWorkService.getEmployeeWorkInfoAll(startDt,endDt);

       logger.info("*******getEmployeeWorkInfo start********");

       return employeeWorkListAll;
   }

    //控制器处理“/getInfo”的URL请求，POST请求
    @RequestMapping(value = "/getInfoAllList",
            method = RequestMethod.POST)
    public Object getEmployeeWorkInfoAllList(@RequestBody EmployeeWork employeeWorklist){
        logger.info("*******getEmployeeWorkInfo start********");

        List<EmployeeWorkYear> employeeWorkLists = employeeWorkService.getEmployeeWorkInfoAllList(employeeWorklist);

        logger.info("*******getEmployeeWorkInfo start********");

        return employeeWorkLists;
    }
}


