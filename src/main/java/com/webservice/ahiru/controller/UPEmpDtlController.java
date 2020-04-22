package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.UPEmpDtl;
import com.webservice.ahiru.mapper.UPEmpDtlMapper;
import com.webservice.ahiru.service.UPEmpDtlService;
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
 * @author wanghao
 * @since 2019-12-31
 */
//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/mproject”的URL请求
@RequestMapping("/upempdtl")
public class UPEmpDtlController<depRole> {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(UPEmpDtlController.class);

//    @Autowired
//    private UPEmpDtlService upEmpDtlService;

    //Service接口的实现类
    @Autowired
    private UPEmpDtlMapper upEmpDtlMapper;

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
    public Object intf(@RequestBody UPEmpDtl upEmpDtl){
        System.out.println("=============START=======");

        Object obj = getInfo(upEmpDtl);

        System.out.println("=============END=======");

        return obj;
    }

    //测试该方法是否通畅
    @RequestMapping("/test3")
    public Object test(){
        return "ok!!!";
    }

    /**
     *
     * @Target(ElementType.METHOD) getInfo
     * @Target(ElementType.PARAMETER) @RequestBody UPEmpDtl upEmpDtl
     * 查询表（M_EMP_DTL）的数据以列表的形式输出，调用upEmpDtlMapper的getInfo方法，返回对象result
     * 根据员工编号（EMPLOYEE_NO）来查询表（M_EMP_DTL）的数据
     *
     * @author wanghao
     * @since 2019-2-17
     */

    public List<UPEmpDtl> getInfo(UPEmpDtl upEmpDtl) {

        System.out.println("===============EmployeeNo:"+upEmpDtl.getId() +"=================");
        System.out.println("===============DepRole:"+upEmpDtl.getDepRole() +"=================");

        List<UPEmpDtl> result = new ArrayList<>();

        if(upEmpDtl != null){
            result = upEmpDtlMapper.getInfo(upEmpDtl);
        }
        return result;
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
     * @author wanghao
     * @since 2019-2-18
     */

    //控制器处理“/update”的URL请求，POST请求
    @RequestMapping(value = "/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public String UpdateInfo(@RequestBody UPEmpDtl upEmpDtl) {

        int result;

        String message = "";

        System.out.println("===============EmployeeNo:"+upEmpDtl.getId() +"=================");
        System.out.println("===============DepRope:"+upEmpDtl.getBpflg() +"=================");

        if(upEmpDtl.getBpflg().equals("0")){
            result=upEmpDtlMapper.UpdateEmpInfo(upEmpDtl);
        }
        else{
            result=upEmpDtlMapper.UpdateBpInfo(upEmpDtl);
        }
//        int result = upEmpDtlMapper.UpdateInfo(upEmpDtl);

        message = "ok";
        System.out.println("----------------------------");
        System.out.println(result);
        System.out.println("----------------------------");
        return message ;
    }

}

