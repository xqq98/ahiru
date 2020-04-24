package com.webservice.ahiru.controller;


import com.webservice.ahiru.entity.MProject;
import com.webservice.ahiru.entity.PmChosen;
import com.webservice.ahiru.service.MProjectService;
import com.webservice.ahiru.service.PmChosenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanghao
 * @since 2020-2-17
 */
//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/pmchosen”的URL请求
@RequestMapping("/pmchosen")
public class PmChosenController {
    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MProjectController.class);

    //Service接口的实现类
    @Autowired
    private PmChosenService pmChosenService;

    //测试该方法是否通畅
    @RequestMapping("/test9")
    public Object test(){
        return "Rocky and Rolly!";
    }
//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    /**
     *
     * @Target(ElementType.METHOD) getpmchosen
     * @Target(ElementType.PARAMETER) @RequestParam("pmname") String pmname,@RequestParam("id") String id,@RequestParam("hanyoucodename") String hanyoucodename
     * 获取视图（V_PM_CHOSEN）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据三个主键）
     * 根据员工编号（id）和 PM姓名（pmname）和 通用代码名称（hanyoucodename）并且 （使用状况（USE_STATUS = 0）等于0 或者 使用状况（USE_STATUS IS NULL）是空）
     * 来查询视图（V_PM_CHOSEN）的数据
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/getpmchosen”的URL请求，POST请求
    @RequestMapping(value = "/getpmchosen",method = RequestMethod.POST)
    public List<PmChosen> getPmChosen(@RequestBody PmChosen pmChosen){

        List<PmChosen> resultPmChosen = pmChosenService.getPmChosen(pmChosen);

        return resultPmChosen;
    }
}
