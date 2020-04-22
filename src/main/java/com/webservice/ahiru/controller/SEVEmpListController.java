package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.SEVEmpList;
import com.webservice.ahiru.service.SEVEmpListService;
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
 * @author wanghao
 * @since 2020-02-28
 */

//进行标记这是一个Controller
@RestController
//控制器处理所有“/vemplist”的URL请求
@RequestMapping("/vemplist")
public class SEVEmpListController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MProjectController.class);

    //Service接口的实现类
    @Autowired
    private SEVEmpListService sevEmpListService;

    //测试该方法是否通畅
    @RequestMapping("/test9")
    public Object test(){
        return "ok!";
    }

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
    @RequestMapping(value = "/getInFo",method = RequestMethod.POST)
    public List<SEVEmpList> getInFo(@RequestParam("startDt") String startDt,@RequestParam("endDt") String endDt){

        return sevEmpListService.getInFo(startDt,endDt);
    }

    @RequestMapping(value = "/getInFoAll",method = RequestMethod.POST)
    public List<SEVEmpList> getInfoAll(@RequestBody SEVEmpList sevEmpList){

//        System.out.println(sevEmpList.getDepRoleName()+"=========================" );

//        String ret = "'"+sevEmpList.getDepRoleName().replace(",", "\',\'")+"'";
//
//        sevEmpList.setDepRoleName(ret);
//
//        System.out.println(sevEmpList.getDepRoleName()+"=========================" );

        System.out.println("name:"+sevEmpListService.getInfoAll(sevEmpList));
        return sevEmpListService.getInfoAll(sevEmpList);
    }

}

