package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.MProject;
import com.webservice.ahiru.entity.OutManager;
import com.webservice.ahiru.mapper.OutManagerMapper;
import com.webservice.ahiru.pojo.Result;
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
    public Result intf(@RequestBody OutManager outManager){
        System.out.println("=============START=======");

        List<OutManager> obj =outManagerService.getInfo(outManager);
//        Object obj = getInfo(outManager);
        Result result = Result.ok(obj);

        System.out.println("=============END=======");

        return result;
    }


    //测试该方法是否通畅
    @RequestMapping("/test1")
    public Object test(){
        return "ok!!!";
    }



//    public List<OutManager> getInfo(OutManager outManager) {
//
////        System.out.println("===============OutManager:"+OutManager.getManager()+"=================");
//
//
//        List<OutManager> result = new ArrayList<OutManager>();
//
//        if(outManager != null){
//            result = outManagerMapper.getInfo(outManager);
//        }
//        return result;
//    }

}

