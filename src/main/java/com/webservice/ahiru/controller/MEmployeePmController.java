package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.MEmployee;
import com.webservice.ahiru.entity.MEmployeePm;
import com.webservice.ahiru.service.MEmployeePmService;
import com.webservice.ahiru.service.MProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2020-2-17
 */

//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/memployeepm”的URL请求
@RequestMapping("/memployeepm")
public class MEmployeePmController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MProjectController.class);

    //Service接口的实现类
    @Autowired
    private MEmployeePmService mEmployeePmService;

    //测试该方法是否通畅
    @RequestMapping("/test9")
    public Object test(){
        return "Y2 ok!!!";
    }

    /**
     *
     * @Target(ElementType.METHOD) getPMList
     * @Target(ElementType.PARAMETER)
     * 获取数据库表（M_EMPLOYEE）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
     * 根据员工编号相等( M_EMPLOYEE.EMPLOYEE_NO = M_EMP_DTL.EMPLOYEE_NO ) 并且 权限等于0或者等于1 ( M_EMP_DTL.ROLE = '0' OR M_EMP_DTL.ROLE = '1')
     * 并且 权限等于0 ( M_EMPLOYEE.DEL_FG = '0' ) AND ( M_EMP_DTL.DEL_FG = '0' ) 来查询表（M_EMPLOYEE）中员工编号（EMPLOYEE_NO）和 员工姓名（NAME）
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/getMEmployees”的URL请求，POST请求
    @RequestMapping(value = "/getMEmployees",method = RequestMethod.POST)
    public List<MEmployeePm> getPMList() {

        List<MEmployeePm> result = new ArrayList<MEmployeePm>();

        return mEmployeePmService.getMEmployees();
    }

}
