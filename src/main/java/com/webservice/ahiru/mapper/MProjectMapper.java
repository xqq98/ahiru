package com.webservice.ahiru.mapper;

import com.webservice.ahiru.entity.MProject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author songxipeng
 * @since 2019-12-16
 */
//用于标注数据访问组件，即DAO组件。
@Repository
//添加接口
@Mapper
//数据库访问接口类
public interface MProjectMapper {

    //查询数据
    public List<MProject> getMProjects();

    //查询数据（根据两个主键）
    public MProject getMProjectById(String pmid, String projectid);

    //增加数据
    public int addMProject(MProject mProject);

    //修改数据
    public int edtMProject(MProject mProject);

    //删除数据（根据两个主键）
    public int delMProject(String pmid, String projectid);

    //删除数据（根据一个主键）
    public int delMProjectbypmid(String pmid);

    //查询数据（根据一个主键）
    public List<MProject> getMProjectByPmid(String pmid);

    //查询数据（根据一个主键）
    public List<MProject> getMProjectByPmNo(String pmid);

    //查询PROJECT_ID和PROJECT_NAME
    public List<MProject> getMProjectsIdAndName();

//    public List<MProjectCaseName> getMProjectsCaseName();

    public List<MProject> getMProjectsAll();

    //韩广晨 2020-04-16 Begin
    public MProject getMProject(String id);
    public int setMProject(MProject mProject);
    //韩广晨 2020-04-16 End
}
