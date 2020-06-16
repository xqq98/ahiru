package com.webservice.ahiru.controller;

import com.alibaba.druid.util.StringUtils;
import com.webservice.ahiru.entity.MEmpDtl;
import com.webservice.ahiru.mapper.MEmpDtlMapper;
import com.webservice.ahiru.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanghao
 * @since 2019-12-31
 */

//进行标记这是一个Controller
@RestController
//控制器处理所有“/mempdtl”的URL请求
@RequestMapping("/mempdtl")
public class MEmpDtlController<weChatId> {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MEmpDtlController.class);

    //Service接口的实现类
    @Autowired
    private MEmpDtlMapper mEmpDtlMapper;

    /**
     *
     * @Target(ElementType.METHOD) intf
     * @Target(ElementType.PARAMETER) @RequestBody MEmpDtl mEmpDtl
     * 表的数据放到obj对象中，返回对象obj
     *
     * @author wanghao
     * @since 2019-12-31bind
     */
    //控制器处理“/api”的URL请求，POST请求
    @RequestMapping(value = "/api",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object intf(@RequestBody MEmpDtl mEmpDtl){

        System.out.println("=============START=======");

        Object obj = getInfo(mEmpDtl);

        System.out.println("=============END=======");

        return obj;
    }

    /**
     *
     * @Target(ElementType.METHOD) getInfo
     * @Target(ElementType.PARAMETER) MEmpDtl mEmpDtl
     * 查询表（M_EMP_DTL）的数据以列表的形式输出，调用mEmpDtlMapper的getInfo方法，返回对象result
     * 根据员工编号（EMPLOYEE_NO）来查询表（M_EMP_DTL）下的微信ID（WECHAT_ID）和权限（ROLE）
     *
     * @author wanghao
     * @since 2019-12-31
     */
    public List<MEmpDtl> getInfo(MEmpDtl mEmpDtl) {

        System.out.println("===============EmployeeNo:"+mEmpDtl.getEmployeeNo() +"=================");

        System.out.println("===============WeChatid:"+mEmpDtl.getWeChatId() +"=================");

        List<MEmpDtl> result = new ArrayList<>();

             if(mEmpDtl != null){

             result = mEmpDtlMapper.getInfo(mEmpDtl);
        }

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
     * @Target(ElementType.PARAMETER) @RequestBody MEmpDtl mEmpDtl
     * 更新表（M_EMP_DTL），更新表的件数放到result对象中，调用mEmpDtlMapper的UpdateInfo方法，返回对象mEmpDtl
     * 根据员工编号（EMPLOYEE_NO）来更新表（M_EMP_DTL）下的微信ID（WECHAT_ID）
     *
     * @author wanghao
     * @since 2019-12-31
     */
    //控制器处理“/update”的URL请求，POST请求
    @RequestMapping(value = "/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MEmpDtl UpdateInfo(@RequestBody MEmpDtl mEmpDtl) {

        System.out.println("===============EmployeeNo:"+mEmpDtl.getEmployeeNo() +"=================");

        System.out.println("===============WeChatid:"+mEmpDtl.getWeChatId() +"=================");

        int result = mEmpDtlMapper.UpdateInfo(mEmpDtl);

        return mEmpDtl;
    }

    /**
     *
     * @Target(ElementType.METHOD) bindAndGetRole
     * @Target(ElementType.PARAMETER) @RequestBody MEmpDtl mEmpDtl
     * 查询表的数据以列表的形式输出，调用mEmpDtlMapper的getInfo方法，返回对象resList
     * 通过对象resList，获取表中weChatId （根据员工编号（EMPLOYEE_NO）来查询表（M_EMP_DTL）下的微信ID（WECHAT_ID）和权限（ROLE））
     * 如果weChatId等于空或者没有值，把weChatId更新，并返回权限Role（根据员工编号（EMPLOYEE_NO）来更新表（M_EMP_DTL）下的微信ID（WECHAT_ID））
     * 如果weChatId不等于空并且微信id跟weChatId不相等，输出“40000”
     * 之外的所有情况，直接返回权限Role
     *
     * @author wanghao
     * @since 2019-12-31
     */
    //控制器处理“/bind”的URL请求，POST请求
    @RequestMapping(value = "/bind", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result bindAndGetRole(@RequestBody MEmpDtl mEmpDtl) {
        List<MEmpDtl> resList = new ArrayList<>();
        if(mEmpDtl != null){
            resList = mEmpDtlMapper.getInfo(mEmpDtl);
        }
        Map<String , MEmpDtl > obj = new HashMap();
        Result result = new Result(null);

        if(resList.size()>0)
        {
            if( !StringUtils.isEmpty(resList.get(0).getWeChatId()) && !mEmpDtl.getWeChatId().equals(resList.get(0).getWeChatId()))
            {
                System.out.println("===============mEmpDtl.getWeChatId():"+ mEmpDtl.getWeChatId() +"=================");
                System.out.println("===============WeChatId:"+ resList.get(0).getWeChatId() +"=================");
                result.setCode("40000");
                result.setSuccess("NO");
                result.setMessage("员工号已被绑定或网络错误，请联系管理员");
            }
            else {
                if (StringUtils.isEmpty(resList.get(0).getWeChatId())) {
                    int count = mEmpDtlMapper.UpdateInfo(mEmpDtl);
                    if (count > 0) {
                        resList.get(0).setWeChatId(mEmpDtl.getWeChatId());
                    }
                }

                for (int i = 0; i < resList.size(); i++) {
                    if (i == 0) {
                        obj.put("currentUser", resList.get(i));
                    } else {
                        obj.put("agency_" + i, resList.get(i));
                    }
                }

                result = Result.ok(obj);
            }
        }
        else
        {
            System.out.println("===============mEmpDtl.getWeChatId():"+ mEmpDtl.getWeChatId() +"=================");
            System.out.println("===============WeChatId:"+ resList.get(0).getWeChatId() +"=================");

            result.setSuccess("NO");
            result.setMessage("员工号输入错误");
        }


        return result;
    }

}

