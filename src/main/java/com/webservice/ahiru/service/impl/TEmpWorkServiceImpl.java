package com.webservice.ahiru.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.webservice.ahiru.common.UserUtil;
import com.webservice.ahiru.entity.TEmpWork;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.TEmpWorkMapper;
import com.webservice.ahiru.service.TEmpWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rocky.Yu
 * @since 2020-01-15
 */
//service标注业务层组件
@Service
public class TEmpWorkServiceImpl implements TEmpWorkService{

    //Service接口的实现类
    @Autowired
    TEmpWorkMapper tEmpWorkMapper;

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中,返回tEmpWork
    public List<TEmpWork> getTEmpWork() {

        List<TEmpWork> tEmpWork = tEmpWorkMapper.getTEmpWork();

        return tEmpWork;

    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据主键）,返回tEmpWork
    public List<TEmpWork> getTEmpWorkById(String id)  throws AhiruException {
        try {
            //根据前台传过来的id 去tempwork表中检索
            List<TEmpWork> tEmpWork = tEmpWorkMapper.getTEmpWorkById(id);
            //新建tempworkList用于处理数据
            List<TEmpWork> tEmpWork1 = new ArrayList<>();
            //设置数据格式
            DecimalFormat df =  new DecimalFormat("00");


        for(int i = 0;i<12;i++){
            TEmpWork ccc = new TEmpWork();
            //向tempworkList中添加数据
            tEmpWork1.add(ccc);
        }

        for(int i = 0;i<12;i++){
            //tempworkList中每一个对象添加月份
            tEmpWork1.get(i).setUseMonth(df.format(i+1));
            //tempworkList中每一个对象添加id
            tEmpWork1.get(i).setEmployeeNo(id);
            //tempworkList中每一个对象都设置为空闲人员
            tEmpWork1.get(i).setUseStatus("4");
        }


        for (int i = 0;i<tEmpWork.size();i++){
            TEmpWork aaa = tEmpWork.get(i);
            //若UseStatus为0 且CaseId为null 此时为空闲人员数据处理为3
//            if(aaa.getUseStatus().equals("0") && StringUtils.isEmpty(aaa.getCaseId()) ){
//                    aaa.setUseStatus("3");
//            }

//            if(StringUtils.isEmpty(aaa.getUseStatus()) ){
//                aaa.setUseStatus("3");
//            }

            switch (aaa.getUseMonth()) {
                case "01":
                    tEmpWork1.set(0,aaa);
                    continue;
                case "02":
                    tEmpWork1.set(1,aaa);
                    continue;
                case "03":
                    tEmpWork1.set(2,aaa);
                    continue;
                case "04":
                    tEmpWork1.set(3,aaa);
                    continue;
                case "05":
                    tEmpWork1.set(4,aaa);
                    continue;
                case "06":
                    tEmpWork1.set(5,aaa);
                    continue;
                case "07":
                    tEmpWork1.set(6,aaa);
                    continue;
                case "08":
                    tEmpWork1.set(7,aaa);
                    continue;
                case "09":
                    tEmpWork1.set(8,aaa);
                    continue;
                case "10":
                    tEmpWork1.set(9,aaa);
                    continue;
                case "11":
                    tEmpWork1.set(10,aaa);
                    continue;
                case "12":
                    tEmpWork1.set(11,aaa);
                    continue;
            }
        }
        return tEmpWork1;}
        catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new AhiruException("空闲人员数据取得失败");
        }

    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //把表（T_EMP_WORK）的所有字段的值都插入表中，返回CNT
    public int addTEmpWork(TEmpWork tEmpWork) {
        try {
        String username= UserUtil.getLoginUser();
        tEmpWork.setEntId(username);
        tEmpWork.setEntDt((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        int CNT = tEmpWorkMapper.addTEmpWork(tEmpWork);

        return CNT;
    }catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("人员新增失败");
        }}

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //修改数据库表（T_EMP_WORK）的数据，修改数据后，返回 CNT
    public int edtTEmpWork(TEmpWork tEmpWork) {
        try {
            String username= UserUtil.getLoginUser();
            tEmpWork.setUpdId(username);
            tEmpWork.setUpdDt((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        int CNT = tEmpWorkMapper.edtTEmpWork(tEmpWork);

        return CNT;}catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("人员信息修改失败");
        }
    }

    //韩广晨 2020-04-16 Begin
    //修改数据库表（T_EMP_WORK）的数据，根据 PM_EMPLOYEE_NO,PROJECT_ID,CASE_NAME
    public int setTEmpWorkByNO(String newprojectid, String newcasename,
                               String updDt, String updId,
                               String oldpmemployeeno, String oldprojectid, String oldcaseid)
    {
        int cnt = tEmpWorkMapper.setTEmpWorkByNO(newprojectid,newcasename,
                                                updDt,updId,
                                                oldpmemployeeno,oldprojectid,oldcaseid);

        return cnt;
    }

    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，根据项目经理号去重查询
    public List<TEmpWork> getTEmpWorkByPM_NO(String pmEmployeeNo)
    {
        List<TEmpWork> tEmpWork = tEmpWorkMapper.getTEmpWorkByPM_NO(pmEmployeeNo);

        return tEmpWork;
    }
    //韩广晨 2020-04-16 End

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //修改数据库表（T_EMP_WORK）的数据，修改数据后，返回 CNT
    public int delTEmpWork(TEmpWork tEmpWork) {
        try {
            String username= UserUtil.getLoginUser();
            tEmpWork.setDelId(username);
            tEmpWork.setDelDt((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        int CNT = tEmpWorkMapper.delTEmpWork(tEmpWork);

        return CNT;}catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("人员删除失败");
        }
    }
    @Override
    @Transactional
    //处理数据
    public List<Integer> doneTempWork(List<TEmpWork> tEmpWorkList)  throws AhiruException {
        try {
            List<Integer> doneList =new ArrayList<>();

            //再次查询一遍数据，待后面作比较
            List<TEmpWork> oldlist = getTEmpWorkById(tEmpWorkList.get(0).getEmployeeNo());
            for (int i = 0; i < tEmpWorkList.size(); i++) {
                TEmpWork oldTEmpWork = oldlist.get(i);
                TEmpWork tEmpWork = tEmpWorkList.get(i);
                if(tEmpWork.getUseStatus().equals("4")){
                    tEmpWork.setUseStatus("3");
                }
                //如果workno不为空，说明数据库存在数据，根据delfg判断调用修改还是删除方法
                if (!StringUtils.isEmpty(tEmpWork.getWorkNo())) {
                    //判断是否有PM_EMPLOYEE_NUM
                    if(!StringUtils.isEmpty(tEmpWork.getPmEmployeeNo())){
                        //前台传回的数据和老的数据对比，如果相等，进入下一条数据
                        if(tEmpWork.getPmEmployeeNo().equals(oldTEmpWork.getPmEmployeeNo())){
                            continue;
                        }else{
                            //有workno 有pmemployee 且不一样调用修改方法
                            edtTEmpWork(tEmpWork);}

                        doneList.add(Integer.parseInt(tEmpWork.getUseMonth()));

                    }else{
                        //有workno 没有pmnum 调用删除方法
                        delTEmpWorkbyworkNo(tEmpWork);
                        doneList.add(Integer.parseInt(tEmpWork.getUseMonth()));
                    }


                } else {
                    //如果workno为null 且返回PMNUM 调用增加方法
                    if (!StringUtils.isEmpty(tEmpWork.getPmEmployeeNo())) {
                        addTEmpWork(tEmpWork);
                        doneList.add(Integer.parseInt(tEmpWork.getUseMonth()));
                        //未返回进入下一循环
                    } else {
                        continue;
                    }

                }

            }
            return doneList;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);

            throw new AhiruException("数据处理失败");
        }

    }
    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //修改数据库表（T_EMP_WORK）的数据，修改数据后，返回 CNT
    public int delTEmpWorkbyworkNo(TEmpWork tEmpWork) {
        try {

            int CNT = tEmpWorkMapper.delTEmpWorkbyworkNo(tEmpWork);

            return CNT;}
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("人员信息删除失败");
        }
    }
}