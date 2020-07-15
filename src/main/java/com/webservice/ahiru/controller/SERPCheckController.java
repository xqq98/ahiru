package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.SERPCheck;
import com.webservice.ahiru.mapper.SERPCheckMapper;
import com.webservice.ahiru.service.SERPCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
*  前端控制器
* </p>
*
* @author liliang
* @since 2020-07-02
 */

//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/serpcheck”的URL请求
@RequestMapping("/serpcheck")
public class SERPCheckController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(SERPCheckController.class);

    //Service接口的实现类
    @Autowired
    private SERPCheckService serpCheckService;

    //Service接口的实现类
    @Autowired
    private SERPCheckMapper serpCheckMapper;

    /**
     * @Target(ElementType.METHOD) intf
     * @Target(ElementType.PARAMETER) @RequestBody VEmployeeBp vEmployeeBp
     * 表的数据放到obj对象中，返回对象obj
     */
    //控制器处理“/api”的URL请求，POST请求
    @RequestMapping(value = "/api",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object intf(@RequestBody SERPCheck sERPCheck){
        System.out.println("=============START=======");
        Object obj = getInfo(sERPCheck);
        System.out.println("=============END=======");
        return obj;
    }

    //测试该方法是否通畅
    @RequestMapping("/test1")
    public Object test(){
        return "ok!!!";
    }

    /**
     *
     * @Target(ElementType.METHOD) getInfo
     * @Target(ElementType.PARAMETER) MEmpDtl mEmpDtl
     * 查询视图（V_EMP_LIST）的数据以列表的形式输出，调用vEmployeeBPMapper的getInfo方法，返回对象result
     * 根据员工编号（EMPLOYEE_NO）来查询视图（V_EMP_LIST）下的数据
     *
     */

    public List<SERPCheck> getInfo(SERPCheck sERPCheck) {

        System.out.println("===============ID:"+sERPCheck.getId() +"=================");
        List<SERPCheck> result = new ArrayList<SERPCheck>();
        if(sERPCheck != null){
            result = serpCheckMapper.getInfo(sERPCheck);
        }
        return result;
    }

}

