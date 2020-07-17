package com.webservice.ahiru.service;

import com.webservice.ahiru.entity.MProject;
import com.webservice.ahiru.entity.MProjectCaseName;
import com.webservice.ahiru.entity.MProjectNew;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yanyan
 * @since 2019-12-25
 */
//Service层业务接口类编写
public interface MProjectService  {

    //获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
    public List<MProject> getMProjects();

    //获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据双主键）
    public MProject getMProjectById(String pmid, String projectid);

    //把表（M_PROJECT）的所有字段的值都插入表中
    public int addMProject(MProject mProject);

    //修改数据库表（M_PROJECT）的数据
    public int edtMProject(MProject mProject);

    //删除数据库表（M_PROJECT）的数据，根据PM员工号（PM_EMPLOYEE_NO）和项目编号（PROJECT_ID）
    public int delMProject(String pmid, String projectid);

    //删除数据库表（M_PROJECT）的数据，根据PM员工号（PM_EMPLOYEE_NO）
    public int delMProjectbypmid(String pmid);

    //获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据主键）
    public List<MProject> getMProjectByPmid(String pmid,String year);

    //获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据主键）
    public List<MProject> getMProjectByPmNo(String pmid);

    //获取数据以MProjectNew输出
    public List<MProjectNew> getAllMProject();

    //获取数据库表（M_PROJECT）的PROJECT_ID和PROJECT_NAME，以list列表的形式，把查询出来的数据保存在数据对象中
    public List<MProject> getMProjectsIdAndName();

    public List<MProjectCaseName> getMProjectsCaseName(String year);

    public List<MProject> getMProjectsAll(String year);

    //韩广晨 2020-04-16 Begin
    //获取数据库表（M_PROJECT）的数据,根据 PM_EMPLOYEE_NO,ID查询唯一数据
    public MProject getMProject(String id);
    //修改数据库表（M_PROJECT）的数据,根据 ID修改唯一数据
    public int setMProject(MProject mProject);
    //韩广晨 2020-04-16 End

    //shy
    public int setMProject(List<MProject> mProjectList );
}
