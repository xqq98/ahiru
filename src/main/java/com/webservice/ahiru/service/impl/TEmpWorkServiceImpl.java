package com.webservice.ahiru.service.impl;
import com.webservice.ahiru.entity.TEmpWork;
import com.webservice.ahiru.mapper.TEmpWorkMapper;
import com.webservice.ahiru.service.TEmpWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<TEmpWork> getTEmpWorkById(String id) {

        List<TEmpWork> tEmpWork = tEmpWorkMapper.getTEmpWorkById(id);
        List<TEmpWork> tEmpWork1 = new ArrayList<>();


        for(int i = 0;i<12;i++){
            TEmpWork ccc = new TEmpWork();
            tEmpWork1.add(ccc);
        }
        tEmpWork1.get(0).setUseMonth("01");
        tEmpWork1.get(1).setUseMonth("02");
        tEmpWork1.get(2).setUseMonth("03");
        tEmpWork1.get(3).setUseMonth("04");
        tEmpWork1.get(4).setUseMonth("05");
        tEmpWork1.get(5).setUseMonth("06");
        tEmpWork1.get(6).setUseMonth("07");
        tEmpWork1.get(7).setUseMonth("08");
        tEmpWork1.get(8).setUseMonth("09");
        tEmpWork1.get(9).setUseMonth("10");
        tEmpWork1.get(10).setUseMonth("11");
        tEmpWork1.get(11).setUseMonth("12");

        for (int i = 0;i<tEmpWork.size();i++){
            TEmpWork aaa = tEmpWork.get(i);
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





        return tEmpWork1;

    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //把表（T_EMP_WORK）的所有字段的值都插入表中，返回CNT
    public int addTEmpWork(TEmpWork tEmpWork) {

        int CNT = tEmpWorkMapper.addTEmpWork(tEmpWork);

        return CNT;
    }

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //修改数据库表（T_EMP_WORK）的数据，修改数据后，返回 CNT
    public int edtTEmpWork(TEmpWork tEmpWork) {

        int CNT = tEmpWorkMapper.edtTEmpWork(tEmpWork);

        return CNT;
    }

    //韩广晨 2020-04-16 Begin
    //修改数据库表（T_EMP_WORK）的数据，根据 PM_EMPLOYEE_NO,PROJECT_ID,CASE_NAME
    public int setTEmpWorkByNO(String newpmemployeeno, String newprojectid, String newcasename,
                               String updDt, String updId,
                               String oldpmemployeeno, String oldprojectid, String oldcasename)
    {
        int cnt = tEmpWorkMapper.setTEmpWorkByNO(newpmemployeeno,newprojectid,newcasename,
                                                 updDt,updId,oldpmemployeeno,oldprojectid,oldcasename);

        return cnt;
    }

    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，根据项目经理号去重查询
    public List<TEmpWork> getTEmpWorkByPM_NO(String pmEmployeeNo)
    {
        List<TEmpWork> tEmpWork = tEmpWorkMapper.getTEmpWorkByPM_NO(pmEmployeeNo);

        return tEmpWork;
    }
    //韩广晨 2020-04-16 End

}