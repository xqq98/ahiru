package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.MCode;
import com.webservice.ahiru.service.MCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @author mengliang
 * @since 2020-01-07
 */
//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/mcode”的URL请求
@RequestMapping("/mcode")
public class MCodeController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MCodeController.class);

    //Service接口的实现类
    @Autowired
    private MCodeService mCodeService;

    /**
     *
     * @Target(ElementType.METHOD) getMCodeByCode
     * @Target(ElementType.PARAMETER) @PathVariable(value = "hanYouCode") String hanYouCode
     * 获取数据库表（M_CODE）的数据，以list列表的形式，把查询出来的数据保存在数据对象中(根据主键查询)
     * 根据通用代码（HANYOU_CODE）来查询表（M_CODE）下的所有数据
     *
     * @author wanghao
     * @since 2020-2-14
     */

    //控制器处理“/getmcodebycode/{hanYouCode}”的URL请求，POST请求
    @RequestMapping(value = "/getmcodebycode/{hanYouCode}",method = RequestMethod.POST)

    public List<MCode> getMCodeByCode(@PathVariable(value = "hanYouCode") String hanYouCode){
        List<MCode> resList = new ArrayList<>();
        System.out.println("===============result"+ mCodeService.getMCodeByCode(hanYouCode) +"=================");
        return mCodeService.getMCodeByCode(hanYouCode);

    }

    /**
     *
     * @Target(ElementType.METHOD) getMCode
     * @Target(ElementType.PARAMETER)
     * 获取数据库表（M_CODE）的数数据，以list列表的形式，把查询出来的数据保存在数据对象中
     * 根据通用代码（HANYOU_CODE = 'DEP_ROLE' OR HANYOU_CODE = 'TECH_DIREC'）来查询表（M_CODE）中通用代码实例名（HANYOU_VALUE_NAME）的值
     *
     * @author wanghao
     * @since 2020-2-14
     */

    //控制器处理“/getmcodename”的URL请求，POST请求
    @RequestMapping(value = "/getmcodename" ,method = RequestMethod.POST)

    public List<MCode> getMCode() {

        List<MCode> result = new ArrayList<MCode>();

        return mCodeService.getMCode();

    }

    //测试该方法是否通畅
    @RequestMapping("/test9")
    public Object test(){
        return "Y2 ok!!!";
    }

}

