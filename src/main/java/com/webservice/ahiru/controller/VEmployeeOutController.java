package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.Bu;
import com.webservice.ahiru.entity.VEmployeeOut;
import com.webservice.ahiru.mapper.VEmployeeOutMapper;
import com.webservice.ahiru.service.VEmployeeOutService;
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
 * @since 2020-03-09
 */

//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/vemployeeout”的URL请求
@RequestMapping("/vemployeeout")
public class VEmployeeOutController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(VEmployeeOutController.class);

    //Service接口的实现类
    @Autowired
    private VEmployeeOutService vEmployeeOUTService;

    //Service接口的实现类
    @Autowired
    private VEmployeeOutMapper vEmployeeOUTMapper;

    /**
     *
     * @Target(ElementType.METHOD) intf
     * @Target(ElementType.PARAMETER) @RequestBody VEmployeeOut vEmployeeOut
     * 表的数据放到obj对象中，返回对象obj
     *
     * @author lijunchen
     * @since 2020-03-09
     */
    //控制器处理“/api”的URL请求，POST请求
    @RequestMapping(value = "/api",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object intf(@RequestBody VEmployeeOut vEmployeeOut){
        System.out.println("=============START=======");

        Object obj = getInfo(vEmployeeOut);

        System.out.println("=============END=======");

        return obj;
    }

    @RequestMapping(value = "/apibu",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object intbu(@RequestBody VEmployeeOut vEmployeeOut){
        System.out.println("=============START=======");

        Object obj = getBU(vEmployeeOut);

        System.out.println("=============END=======");

        return obj;
    }

//    @RequestMapping(value = "/apimanager",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Object intmanager(@RequestBody OutPersonManager outPersonManager){
//        System.out.println("=============START=======");
//
//        Object obj = getMANAGER(outPersonManager);
//
//        System.out.println("=============END=======");
//
//        return obj;
//    }



    //测试该方法是否通畅
    @RequestMapping("/test1")
    public Object test(){
        return "ok!!!";
    }

    /**
     *
     * @Target(ElementType.METHOD) getInfo
     * @Target(ElementType.PARAMETER) MEmpDtl mEmpDtl
     * 查询视图（V_EMP_OUT）的数据以列表的形式输出，调用vEmployeeOUTMapper的getInfo方法，返回对象result
     * 根据员工编号（EMPLOYEE_NO）来查询视图（V_EMP_OUT）下的数据
     *
     * @author lijunchen
     * @since 2020-03-09
     */

    public List<VEmployeeOut> getInfo(VEmployeeOut vEmployeeOut) {

        System.out.println("===============ID:"+vEmployeeOut.getId() +"=================");


        List<VEmployeeOut> result = new ArrayList<VEmployeeOut>();

        if(vEmployeeOut != null){
            result = vEmployeeOUTMapper.getInfo(vEmployeeOut);
        }
        return result;
    }

//    public List<OutPersonManager> getInfo(OutPersonManager outPersonManager) {
//
//        System.out.println("===============ID:"+outPersonManager.getManager() +"=================");
//
//
//        List<OutPersonManager> result = new ArrayList<OutPersonManager>();
//
//        if(outPersonManager != null){
//            result = vEmployeeOUTMapper.getMANAGER(outPersonManager);
//        }
//        return result;
//    }

//查询部门
    public Bu getBU(VEmployeeOut vEmployeeOut) {
        Bu a = new Bu();
        List<String> list=new ArrayList<>();
        System.out.println("===============BU:"+vEmployeeOut.getBu() +"=================");
        List<VEmployeeOut> result = new ArrayList<VEmployeeOut>();

        if(vEmployeeOut != null){
            result = vEmployeeOUTMapper.getBU(vEmployeeOut);
        }
//        过滤重复数据
        for(int i=0;i<result.size();i++){
                if (!list.contains(result.get(i).getBu())) {
                    list.add(result.get(i).getBu());
                }
        }
        a.setBu(list);
        return a;
    }


}





