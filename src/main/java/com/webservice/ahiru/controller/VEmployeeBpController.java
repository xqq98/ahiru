package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.VEmployeeBp;
import com.webservice.ahiru.mapper.VEmployeeBpMapper;
import com.webservice.ahiru.service.VEmployeeBpService;
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
//控制器处理所有“/vemployeebp”的URL请求
@RequestMapping("/vemployeebp")
public class VEmployeeBpController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(VEmployeeBpController.class);

    //Service接口的实现类
    @Autowired
    private VEmployeeBpService vEmployeeBPService;

    //Service接口的实现类
    @Autowired
    private VEmployeeBpMapper vEmployeeBPMapper;

    /**
     *
     * @Target(ElementType.METHOD) intf
     * @Target(ElementType.PARAMETER) @RequestBody VEmployeeBp vEmployeeBp
     * 表的数据放到obj对象中，返回对象obj
     *
     * @author wanghao
     * @since 2019-2-18
     */
    //控制器处理“/api”的URL请求，POST请求
    @RequestMapping(value = "/api",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object intf(@RequestBody VEmployeeBp vEmployeeBp){
        System.out.println("=============START=======");

        Object obj = getInfo(vEmployeeBp);

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
     * @author wanghao
     * @since 2019-2-18
     */

    public List<VEmployeeBp> getInfo(VEmployeeBp vEmployeeBp) {

        System.out.println("===============ID:"+vEmployeeBp.getId() +"=================");


        List<VEmployeeBp> result = new ArrayList<VEmployeeBp>();

        if(vEmployeeBp != null){
            result = vEmployeeBPMapper.getInfo(vEmployeeBp);
        }
        return result;
    }

}

