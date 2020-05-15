package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.UPEmpDtl;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.UPEmpDtlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guoshilong
 * @since 2020-05-14
 */
//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/mproject”的URL请求
@RequestMapping("/upempdtl")
public class UPEmpDtlController<depRole> {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(UPEmpDtlController.class);
//Service接口的实现类
    @Autowired
    private UPEmpDtlService upEmpDtlService;

    /**
     *
     * @Target(ElementType.METHOD) intf
     * @Target(ElementType.PARAMETER) @RequestBody UPEmpDtl upEmpDtl
     * 表的数据放到obj对象中，返回对象obj
     *
     * @author wanghao
     * @since 2019-2-17
     */

    //控制器处理“/api”的URL请求，POST请求
    @RequestMapping(value = "/api",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result intf(@RequestBody UPEmpDtl upEmpDtl){
        System.out.println("=============START=======");

        Result result = upEmpDtlService.getInfo(upEmpDtl);

        System.out.println("=============END=======");

        return result;
    }

    //测试该方法是否通畅
    @RequestMapping("/test3")
    public Object test(){
        return "ok!!!";
    }



    /**
     *
     * @Target(ElementType.METHOD) UpdateInfo
     * @Target(ElementType.PARAMETER) @RequestBody UPEmpDtl upEmpDtl
     * 更新表（M_EMP_DTL），更新表的件数放到result对象中，调用upEmpDtlMapper的UpdateEmpInfo方法，返回对象result
     * 更新表（M_EMP_DTL），更新表的件数放到result对象中，调用upEmpDtlMapper的UpdateBpInfo方法，返回对象result
     * 判断前台传过来的数据如果是0，则是正式员工，通过员工编号（EMPLOYEE_NO），修改表（M_EMP_DTL）的数据
     * 判断前台传过来的数据如果不是0，则是协力员工，通过员工编号（EMPLOYEE_NO），修改表（M_EMP_DTL）的数据
     *
     * @author guoshilong
     * @since 2020-05-14
     */

    //控制器处理“/update”的URL请求，POST请求
    @RequestMapping(value = "/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result UpdateInfo(@RequestBody UPEmpDtl upEmpDtl) {
        logger.info("===============EmployeeNo:"+upEmpDtl.getId() +"=================");
        logger.info("===============DepRope:"+upEmpDtl.getBpflg() +"=================");


        Result result = upEmpDtlService.UpdateInfo(upEmpDtl);

        System.out.println("----------------------------");
        System.out.println(result);
        System.out.println("----------------------------");
        return result ;
    }

}

