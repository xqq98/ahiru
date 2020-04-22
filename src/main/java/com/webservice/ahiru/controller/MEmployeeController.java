package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.MEmployee;
import com.webservice.ahiru.mapper.MEmployeeMapper;
import com.webservice.ahiru.service.MEmployeeService;
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
 * @author songxipeng
 * @since 2019-11-18
 */
//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/memployee”的URL请求
@RequestMapping("/memployee")
public class MEmployeeController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MEmployeeController.class);

    //Service接口的实现类
    @Autowired
    private MEmployeeService mEmployeeService;

    //Service接口的实现类
    @Autowired
    private MEmployeeMapper mEmployeeMapper;

    /**
     *
     * @Target(ElementType.METHOD) intf
     * @Target(ElementType.PARAMETER) @RequestBody MEmployee mEmployee
     * 表的数据放到obj对象中，返回对象obj
     *
     * @author wanghao
     * @since 2020-2-14
     */

    //控制器处理“/api”的URL请求，POST请求
    @RequestMapping(value = "/api",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object intf(@RequestBody MEmployee mEmployee){

        System.out.println("=============START=======");

        Object obj = getInfo(mEmployee);

        System.out.println("=============END=======");

        return obj;
    }

    /**
     *
     * @Target(ElementType.METHOD) getInfo
     * @Target(ElementType.PARAMETER) MEmployee mEmployee
     * 查询表（M_EMPLOYEE）的数据以列表的形式输出(根据主键查询)，调用mEmployeeMapper的getInfo方法，返回对象result
     * 根据员工编号（EMPLOYEE_NO）查询表（M_EMPLOYEE）的所有数据
     *
     * @author wanghao
     * @since 2020-2-14
     */

    public List<MEmployee> getInfo(MEmployee mEmployee) {

        System.out.println("===============EmployeeNo:"+mEmployee.getEmployeeNo() +"=================");

        List<MEmployee> result = new ArrayList<MEmployee>();

        if(mEmployee != null){

            result = mEmployeeMapper.getInfo(mEmployee);
        }

        return result;
    }

    //测试该方法是否通畅
    @RequestMapping("/test2")
    public Object test(){
        return "ok!!!";
    }

}

