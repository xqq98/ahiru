package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.MProject;
import com.webservice.ahiru.entity.MProjectCaseName;
import com.webservice.ahiru.entity.MProjectNew;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.MProjectService;
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
@RequestMapping("/mproject")
public class MProjectController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MProjectController.class);

    //Service接口的实现类
    @Autowired
    private MProjectService mProjectService;
    //韩广晨 2020-04-16 Begin
    @Autowired
    private TEmpWorkService tEmpWorkService;
    //韩广晨 2020-04-16 End

    //测试该方法是否通畅
    @RequestMapping("/test9")
    public Object test(){
        return "Y2 ok!!!";
    }

    /**
     *aaaaaaaaaaaaaaaaaabbbbbccccddddddddd
     * @Target(ElementType.METHOD) doneMProject
     * @Target(ElementType.PARAMETER) @RequestBody List<MProject> mProjectList
     * 获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
     * 根据PM员工号（PM_EMPLOYEE_NO）来查询表（M_PROJECT）下的所有数据
     * 如果数据库有值，那么清空数据库的所有值，在通过for循环把前台传过来的值赋到数据库中
     * 如果数据库没有值，那么通过for循环把前台传过来的值赋到数据库中
     *aaa
     * @author wanghao
     * @since 2020-2-17
     *shy
     */

     //数据处理
    //控制器处理“/donemproject”的URL请求，POST请求
    @RequestMapping(value = "/donemproject",method = RequestMethod.POST)
    public Result doneMProject (@RequestBody List<MProject> mProjectList){
        mProjectService.setMProject(mProjectList);
        return Result.ok();
    }

    /**
     *
     * @Target(ElementType.METHOD) getMProjects
     * @Target(ElementType.PARAMETER)
     * 获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/getmprojects”的URL请求，POST请求
    @RequestMapping(value = "/getmprojects" ,method = RequestMethod.POST)
    public List<MProject> getMProjects() {

        List<MProject> result = new ArrayList<MProject>();

        return mProjectService.getMProjects();

    }

    /**
     *
     * @Target(ElementType.METHOD) getMProjects
     * @Target(ElementType.PARAMETER) @RequestParam("pmid") String pmid,@RequestParam("projectid") String projectid
     * 获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据双主键）
     * 根据PM员工号（PM_EMPLOYEE_NO）和项目编号（PROJECT_ID），来查询表（M_PROJECT）的所有数据
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/getmprojectbyid”的URL请求，GET请求
    @RequestMapping(value = "/getmprojectbyid")
    public MProject getMProjectById(@RequestParam("pmid") String pmid,@RequestParam("projectid") String projectid){

        return mProjectService.getMProjectById(pmid,projectid);
    }

    /**
     *
     * @Target(ElementType.METHOD) addMProject
     * @Target(ElementType.PARAMETER) @RequestBody MProject mProject
     * 把表（M_PROJECT）的所有字段的值都插入表中，返回 Add Done
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/addmproject”的URL请求，POST请求
    @RequestMapping(value ="/addmproject" ,method = RequestMethod.POST)
    public  String addMProject(@RequestBody MProject mProject){

        mProjectService.addMProject(mProject);

        return "Add Done";
    }

    /**
     *
     * @Target(ElementType.METHOD) edtmproject
     * @Target(ElementType.PARAMETER) @RequestBody MProject mProject
     * 修改数据库表（M_PROJECT）的数据，修改数据后，返回 Edt Done
     * 根据PM员工号（PM_EMPLOYEE_NO）和项目编号（PROJECT_ID），修改表（M_PROJECT）的数据
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/edtmproject”的URL请求，POST请求
    @RequestMapping(value ="/edtmproject" ,method = RequestMethod.POST)
    public  String edtMProject(@RequestBody MProject mProject){

        mProjectService.edtMProject(mProject);

        return "Edt Done";
    }

    /**
     *
     * @Target(ElementType.METHOD) delMProject
     * @Target(ElementType.PARAMETER) @RequestParam("pmid") String pmid,@RequestParam("projectid") String projectid
     * 删除数据库表（M_PROJECT）的数据，根据PM员工号（PM_EMPLOYEE_NO）和项目编号（PROJECT_ID），返回Del Done
     * 根据PM员工号（PM_EMPLOYEE_NO）和项目编号（PROJECT_ID），删除表（M_PROJECT）的数据
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/delmproject”的URL请求，GET请求
    @RequestMapping(value = "/delmproject")
    public String delMProject(@RequestParam("pmid") String pmid,@RequestParam("projectid") String projectid){

        mProjectService.delMProject(pmid,projectid);

        return "Del Done";
    }

    /**
     *
     * @Target(ElementType.METHOD) delMProject
     * @Target(ElementType.PARAMETER) @RequestParam("pmid") String pmid
     * 删除数据库表（M_PROJECT）的数据，根据PM员工号（PM_EMPLOYEE_NO），返回Delbypmid Done
     * 根据PM员工号（PM_EMPLOYEE_NO），删除表（M_PROJECT）的数据
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/delmprojectbypmid”的URL请求，GET请求
    //SHY
    @RequestMapping(value = "/delmprojectbypmid")
    public Result delMProject(@RequestParam("pmid") String pmid){

        mProjectService.delMProjectbypmid(pmid);

        return Result.ok();
    }

    /**
     *
     * @Target(ElementType.METHOD) getMProjectByPmid
     * @Target(ElementType.PARAMETER) @PathVariable(value = "pmid") String pmid
     * 获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据主键）
     * 根据PM员工号（PM_EMPLOYEE_NO），查询表（M_PROJECT）的所有数据
     *
     * @author wanghao
     * @since 2020-2-17
     */

    //控制器处理“/getmprojectbypmid/{pmid}”的URL请求，POST请求
    //shy
    @RequestMapping(value = "/getmprojectbypmid")
    public Result getMProjectByPmid(@RequestParam(value = "pmid") String pmid){
        List<MProject> resultMprojects = mProjectService.getMProjectByPmid(pmid);
        Result result = Result.ok(resultMprojects);
        return result;
    }

    //控制器处理“/getmprojectbypmid/{pmid}”的URL请求，POST请求
    @RequestMapping(value = "/getmprojectbypmNo/{pmid}",method = RequestMethod.POST)
    public List<MProject> getMProjectByPmNo(@PathVariable(value = "pmid") String pmid){

        List<MProject> resultMproject = new ArrayList<MProject>();

        return mProjectService.getMProjectByPmNo(pmid);
    }

    //控制器处理getallmproject
    @RequestMapping(value = "/getallmproject",method = RequestMethod.POST)
    public List<MProjectNew> getAllMProject(){

        List<MProjectNew> resultMprojectNew = new ArrayList<>();

        resultMprojectNew = mProjectService.getAllMProject();
        return resultMprojectNew;
    }

    //控制器处理“/getMProjectsIdAndName”的URL请求，POST请求
    @RequestMapping(value = "/getMProjectsIdAndName",method = RequestMethod.POST)
    public List<MProject> getMProjectsIdAndName(){

        List<MProject> resultMProjectsIdAndName = mProjectService.getMProjectsIdAndName();

        return resultMProjectsIdAndName;

    }

    @RequestMapping(value = "/getMProjectsCaseName",method = RequestMethod.POST)
    public List<MProjectCaseName> getMProjectsCaseName(){

        List<MProjectCaseName> resultMprojectCaseName = new ArrayList<>();
        resultMprojectCaseName = mProjectService.getMProjectsCaseName();

        return resultMprojectCaseName;
    }

    //控制器处理“/getmprojects”的URL请求，POST请求
    @RequestMapping(value = "/getmprojectsall" ,method = RequestMethod.POST)
    public List<MProject> getMProjectsAll() {

        List<MProject> resultall = new ArrayList<MProject>();

        return mProjectService.getMProjectsAll();

    }



}

