package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.common.UserUtil;
import com.webservice.ahiru.entity.MProject;
import com.webservice.ahiru.entity.MProjectCaseName;
import com.webservice.ahiru.entity.MProjectNew;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.MEmployeeMapper;
import com.webservice.ahiru.mapper.MProjectMapper;
import com.webservice.ahiru.service.MProjectService;
import com.webservice.ahiru.service.TEmpWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yanyan
 * @since 2019-12-25
 */
//service标注业务层组件
@Service
public class MProjectServiceImpl implements MProjectService {

    @Autowired
    private TEmpWorkService tEmpWorkService;

    //Service接口的实现类
    @Autowired
    MProjectMapper mProjectMapper;

    //Service接口的实现类
    @Autowired
    MEmployeeMapper mEmployeeMapper;

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中，返回mProjects
    public List<MProject> getMProjects() {
        try {


            List<MProject> mProjects = mProjectMapper.getMProjects();

            return mProjects;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("getMProjects失败");
        }


    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据双主键），返回mProject
    public MProject getMProjectById(String pmid, String projectid) {
        try {
            MProject mProject = mProjectMapper.getMProjectById(pmid, projectid);

            return mProject;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("getMProjectById失败");
        }
    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //把表（M_PROJECT）的所有字段的值都插入表中，返回CNT
    @Transactional
    public int addMProject(MProject mProject) {
        try {
            int CNT = mProjectMapper.addMProject(mProject);

            return CNT;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("添加失败");
        }
    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //修改数据库表（M_PROJECT）的数据，返回CNT
    public int edtMProject(MProject mProject) {
        try {
            int CNT = mProjectMapper.edtMProject(mProject);

            return CNT;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("修改失败");
        }
    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //删除数据库表（M_PROJECT）的数据，根据PM员工号（PM_EMPLOYEE_NO）和项目编号（PROJECT_ID），返回CNT
    @Transactional
    public int delMProject(String pmid, String projectid) {
        try {
            int CNT = mProjectMapper.delMProject(pmid, projectid);

            return CNT;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("删除失败");
        }
    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //删除数据库表（M_PROJECT）的数据，根据PM员工号（PM_EMPLOYEE_NO），返回CNT
    public int delMProjectbypmid(String pmid) {
        int cnt = 0;
        try {
            cnt = mProjectMapper.delMProjectbypmid(pmid);
            if (cnt == 0) {
                throw new AhiruException("删除失败");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("删除失败");
        }
        return cnt;
    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据主键）,返回resultMprojects
    //shy
    public List<MProject> getMProjectByPmid() throws AhiruException {
        try {
            String username = UserUtil.getLoginUser();
            List<MProject> resultMprojects = mProjectMapper.getMProjectByPmid(username);
            return resultMprojects;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("项目取得失败");
        }
    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据主键）,返回resultMprojects
    public List<MProject> getMProjectByPmNo(String pmid) {
        try {
            List<MProject> resultMproject = mProjectMapper.getMProjectByPmNo(pmid);

            return resultMproject;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("项目取得失败");
        }
    }

    @Override
    //获取mproject表数据  以MProjectNew  list列表输出
    public List<MProjectNew> getAllMProject() {
        List<MProjectNew> mProjectNewList = new ArrayList<>();
        List<MProject> mProjectList = new ArrayList<>();
        System.out.println("----------------getAll---------------------");
        mProjectList = mProjectMapper.getMProjects();
        for (int i = 0; i < mProjectList.size(); i++) {
            MProjectNew mProjectNew = new MProjectNew();
            List<String> caseNameList = new ArrayList<>();
            //判断id是否重复
            boolean isOk = true;//默认id不重复
            for (int k = 0; k < mProjectNewList.size(); k++) {
                if (mProjectNewList.get(k).getProjectid().equals(mProjectList.get(i).getProjectid())) {
                    isOk = false;
                }
            }

            //如果id 不重复   执行以下代码  如重复 则不执行
            if (isOk) {
                mProjectNew.setProjectid(mProjectList.get(i).getProjectid());
                caseNameList.add(mProjectList.get(i).getCasename());
                for (int j = 0; j < mProjectList.size(); j++) {
                    if (i != j) {
                        //说明找到了projectid 相同的
                        if (mProjectList.get(i).getProjectid().equals(mProjectList.get(j).getProjectid())) {
                            caseNameList.add(mProjectList.get(j).getCasename());
                            System.out.println(caseNameList);
                        }
                    }
                }
                mProjectNew.setCasenamelist(caseNameList);
                mProjectNewList.add(mProjectNew);
            }
        }
        System.out.println("--------------------------------------------");
        return mProjectNewList;
    }

    @Override
    //获取数据库表（M_PROJECT）的数据，以list列表的形式，把查询出来的数据保存在数据对象中，返回mProjects
    public List<MProject> getMProjectsIdAndName() {
        try {
            String username = UserUtil.getLoginUser();
            List<MProject> mProjectsIdAndName = mProjectMapper.getMProjectsIdAndName(username);

            return mProjectsIdAndName;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("项目取得失败");
        }

    }

    @Override
    public List<MProjectCaseName> getMProjectsCaseName() {
        List<MProjectCaseName> resultMprojectCaseName = new ArrayList<>();
        List<MProject> mProjectsAll = mProjectMapper.getMProjectsAll();
        System.out.println("----------------getAll---------------------");
        //mProjectsAll = mProjectMapper.getMProjects();
        String empNo = "";
        for (int i = 0; i < mProjectsAll.size(); i++) {
            if (empNo.equals(mProjectsAll.get(i).getPmemployeeno())) {
                continue;
            }
            MProjectCaseName mProjectCaseName = new MProjectCaseName();
            List<String> projectidlist = new ArrayList<String>();
            List<String> projectnamelist = new ArrayList<String>();
            List<String> caseNameList = new ArrayList<String>();
            List<String> caseIdList = new ArrayList<String>();
            projectidlist.add("");
            projectnamelist.add("");
            caseNameList.add("");
            caseIdList.add("");
            mProjectCaseName.setPmemployeeno(mProjectsAll.get(i).getPmemployeeno());
            for (int j = 0; j < mProjectsAll.size(); j++) {
                if (mProjectsAll.get(i).getPmemployeeno().equals(mProjectsAll.get(j).getPmemployeeno())) {
                    projectidlist.add(mProjectsAll.get(j).getProjectid());
                    projectnamelist.add(mProjectsAll.get(j).getProjectname());
                    caseNameList.add(mProjectsAll.get(j).getCasename());
                    caseIdList.add(mProjectsAll.get(j).getId());
                }
            }

            empNo = mProjectsAll.get(i).getPmemployeeno();
            mProjectCaseName.setProjectidlist(projectidlist);
            mProjectCaseName.setProjectnamelist(projectnamelist);
            mProjectCaseName.setCasenamelist(caseNameList);
            mProjectCaseName.setCaseIdlist(caseIdList);
            resultMprojectCaseName.add(mProjectCaseName);
        }
        System.out.println("--------------------------------------------");
        return resultMprojectCaseName;
    }

    @Override
    public List<MProject> getMProjectsAll() {
        try {
            List<MProject> mProjectsAll = mProjectMapper.getMProjectsAll();

            return mProjectsAll;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("取得失败");
        }
    }

    //韩广晨 2020-04-16 Begin
    public MProject getMProject(String id) {
        try {
            MProject mProject = mProjectMapper.getMProject(id);

            return mProject;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("取得失败");
        }
    }
    //修改数据库表（M_PROJECT）的数据，返回CNT

    @Transactional
    public int setMProject(MProject mProject) {
        try {
            int CNT = mProjectMapper.setMProject(mProject);

            return CNT;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("取得失败");
        }
    }
    //韩广晨 2020-04-16 End

    //shy
    @Transactional
    public int setMProject(List<MProject> mProjectList) {
        try {
            String username = UserUtil.getLoginUser();
            for (int i = 0; i < mProjectList.size(); i++) {
                MProject mProject = mProjectList.get(i);

                mProject.setProjectname(mProject.getProjectname().substring(4));
                MProject existMProject = getMProject(mProject.getId());
                mProject.setEntid(username);
                mProject.setEntdt((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
                mProject.setUpdid(username);
                mProject.setUpddt((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
                // mProject.setDelfg("0");。。
                if (existMProject != null) {
                    tEmpWorkService.setTEmpWorkByNO(
                            mProject.getPmemployeeno(), mProject.getProjectid(), mProject.getCasename(),
                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), mProject.getPmemployeeno(),
                            existMProject.getPmemployeeno(), existMProject.getProjectid(), existMProject.getId()
                    );
                    if (mProjectMapper.setMProject(mProject) == 0) {
                        throw new AhiruException("项目登录失败");
                    }
                    ;
                } else {
                    if (mProjectMapper.addMProject(mProject) == 0) {
                        throw new AhiruException("项目登录失败");
                    }
                    ;
                }
            }
            return 0;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("项目登录失败");
        }
    }
}
