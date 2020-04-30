package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.TEmpWork;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.TEmpWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yanyan
 * @since 2019-12-25
 */
//@RestController进行标记这是一个Controller
@RestController
//控制器处理所有“/mproject”的URL请求
@RequestMapping("/tempwork")
public class TEmpWorkController {
    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MProjectController.class);

    //Service接口的实现类
    @Autowired
    private TEmpWorkService tEmpWorkService;

    //测试该方法是否通畅
    @RequestMapping("/test9")
    public Object test() {
        return "Rocky and Rolly!";
    }

    /**
     *
     * @Target(ElementType.METHOD) getTEmpWork
     * @Target(ElementType.PARAMETER)
     * 获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/gettempwork”的URL请求，POST请求
    @RequestMapping(value = "/gettempwork", method = RequestMethod.POST)
    public List<TEmpWork> getTEmpWork() {

        List<TEmpWork> result = new ArrayList<TEmpWork>();

        return tEmpWorkService.getTEmpWork();

    }

    /**
     *
     * @Target(ElementType.METHOD) getTEmpWorkById
     * @Target(ElementType.PARAMETER) @RequestParam("id") String id
     * 获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据主键）
     * 根据员工编号（EMPLOYEE_NO），来查询表（T_EMP_WORK）的所有数据
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/getmprojectbyid”的URL请求，POST请求
    @RequestMapping(value = "/gettempworkbyid", method = RequestMethod.POST)
    public Result getTEmpWorkById(@RequestParam("id") String id) {

        List<TEmpWork> resultTEmpWork = tEmpWorkService.getTEmpWorkById(id);

//        return tEmpWorkService.getTEmpWorkById(id);
        Result result = Result.ok(resultTEmpWork);
        return result;
    }

    /**
     *
     * @Target(ElementType.METHOD) addTEmpWork
     * @Target(ElementType.PARAMETER) @RequestBody TEmpWork tEmpWork
     * 把表（T_EMP_WORK）的所有字段的值都插入表中，返回 Add Done
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/addtempwork”的URL请求，POST请求
    @RequestMapping(value = "/addtempwork", method = RequestMethod.POST)
    public String addTEmpWork(@RequestBody TEmpWork tEmpWork) {

        tEmpWorkService.addTEmpWork(tEmpWork);

        return "Add Done";
    }

    /**
     *
     * @Target(ElementType.METHOD) edTEmpWork
     * @Target(ElementType.PARAMETER) @RequestBody TEmpWork tEmpWork
     * 修改数据库表（T_EMP_WORK）的数据，修改数据后，返回 Edt Done
     * 根据工作情况编号（WORK_NO），修改表（T_EMP_WORK）的数据
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/edttempwork”的URL请求，POST请求
    @RequestMapping(value = "/edttempwork", method = RequestMethod.POST)
    public String edTEmpWork(@RequestBody TEmpWork tEmpWork) {

        tEmpWorkService.edtTEmpWork(tEmpWork);

        return "Edt Done";
    }

    /**
     *
     * @Target(ElementType.METHOD) doneTEmpWork
     * @Target(ElementType.PARAMETER) @RequestBody List<TEmpWork> tEmpWorkList
     * 获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
     * 根据for循环，把表的数据循坏到取出来，直到表一行数据都不剩为止，返回ok
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/donetempwork”的URL请求，POST请求
    @RequestMapping(value = "/donetempwork", method = RequestMethod.POST)
    public Result doneTEmpWork(@RequestBody List<TEmpWork> tEmpWorkList) {
        tEmpWorkService.doneTempWork(tEmpWorkList);
        return Result.ok();
    }

    //控制器处理“/gettempworkbypmno”的URL请求，POST请求
    @RequestMapping(value = "/gettempworkbypmno")
    public List<TEmpWork> getTEmpWorkByPM_NO(@RequestParam(value = "pmEmployeeNo") String pmEmployeeNo) {
        return tEmpWorkService.getTEmpWorkByPM_NO(pmEmployeeNo);
    }
}
