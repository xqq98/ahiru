package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.OutManager;
import com.webservice.ahiru.mapper.OutManagerMapper;
import com.webservice.ahiru.service.OutManagerService;
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
 * @author lijunchen
 * @since 2020-03-15
 */

//@RestController进行标记这是一个Controller
@RestController
@RequestMapping("/outmanager")
public class OutManagerController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(OutManagerController.class);

    //Service接口的实现类
    @Autowired
    private OutManagerService outManagerService;

    //Service接口的实现类
    @Autowired
    private OutManagerMapper outManagerMapper;

    //控制器处理“/api”的URL请求，POST请求
    @RequestMapping(value = "/api",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object intf(@RequestBody OutManager outManager){
        System.out.println("=============START=======");

        Object obj = getInfo(outManager);

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

     * 查询视图（V_EMP_OUT）的数据以列表的形式输出，调用outManagerMapper的getInfo方法，返回对象result
     * 根据员工编号（Manager）来查询视图（V_EMP_OUT）下的数据

     */

    public List<OutManager> getInfo(OutManager outManager) {

//        System.out.println("===============OutManager:"+OutManager.getManager()+"=================");


        List<OutManager> result = new ArrayList<OutManager>();

        if(outManager != null){
            result = outManagerMapper.getInfo(outManager);
        }
        return result;
    }

}

