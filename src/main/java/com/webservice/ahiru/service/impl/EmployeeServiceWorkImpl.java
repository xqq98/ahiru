package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.entity.EmployeeWork;
import com.webservice.ahiru.entity.EmployeeWorkYear;
import com.webservice.ahiru.mapper.EmployeeWorkMapper;
import com.webservice.ahiru.service.EmployeeWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangenji
 * @since 2019-11-18
 */
//service标注业务层组件
@Service
public class EmployeeServiceWorkImpl implements EmployeeWorkService {

    //Service接口的实现类
    @Autowired
    EmployeeWorkMapper employeeWorkMapper;

    //Service接口的实现类
    private Logger logger = LoggerFactory.getLogger(EmployeeServiceWorkImpl.class);

    // 取得工作详细情报
    @Override
    public List<EmployeeWorkYear> getEmployeeWorkInfo(EmployeeWork inEmployeeWork) {
        logger.info("*******getEmployeeWorkInfo Start********");
        //employeeWorkDB的数据取得
        List<EmployeeWork> employeeWorkList = employeeWorkMapper.getEmployeeWorkInfo(inEmployeeWork);

        //12个月的项目利用状况
        List<String> useMonthStatus;
        //12个月所属的项目ID
        List<String> useMonthProjectId;
        //12个月所属的项目名称
        List<String> useMonthProjectName;
        //12个月所属案件名
        List<String> userMonthCaseName;
        // 员工年间项目情况
        EmployeeWorkYear employeeWorkYear;

        // 员工NO、PMID，年份作为key整理数据
        Map<String, EmployeeWorkYear> map = new HashMap<>();
        String userkey="";
        // 循环work表数据
        for (EmployeeWork employeeWork : employeeWorkList) {
            // key做成
            userkey =
                    employeeWork.getEmployee()
                            + employeeWork.getPm()
                            + employeeWork.getYear();

            // 员工当年数据存在时从Map取得员工年份数据
            if(map.containsKey(userkey)) {
                employeeWorkYear=map.get(userkey);
            }else{
                // 员工当年数据不存在时创建员工年份数据
                employeeWorkYear=creatEmployeeWorkYear(employeeWork);
            }

            // 月份以及每月项目利用情况取得
            useMonthStatus = employeeWorkYear.getUsemon();
            useMonthProjectId = employeeWorkYear.getPromon();
            useMonthProjectName = employeeWorkYear.getPronamemon();
            userMonthCaseName = employeeWorkYear.getCasenamemon();
            // 月份以及每月项目利用情况编辑
            creatMonAndProData(employeeWork,useMonthStatus,useMonthProjectId,useMonthProjectName,userMonthCaseName);
            // 月份以及每月项目利用情况设定
            employeeWorkYear.setPromon(useMonthProjectId);
            employeeWorkYear.setUsemon(useMonthStatus);
            employeeWorkYear.setPronamemon(useMonthProjectName);
            employeeWorkYear.setCasenamemon(userMonthCaseName);
            // 编辑好的数据设定到Map中
            map.put(userkey,employeeWorkYear);
        }

        //出力用List定义
        List<EmployeeWorkYear> employeeWorkYearList = new ArrayList<EmployeeWorkYear>();
        //循环Map，出力List做成
        for(String key:map.keySet()){
        employeeWorkYearList.add(map.get(key));
    }
        logger.info("*******getEmployeeWorkInfo End********");

        return employeeWorkYearList;
}
//    @Override
//    public int copyEmployeeWorkInfo(List<EmployeeWork> inEmployeeWorkList) {
//        logger.info("*******copyEmployeeWorkInfo Start********");
       /* // 取得复制内容
        List<EmployeeWork>employeeWorkList = employeeWorkMapper.getEmployeeWorkInfo(inEmployeeWorkList.get(0));
        EmployeeWork
        // 取得复制对象(待实装)
        inEmployeeWorkList.remove(0);

        List<EmployeeWork> newEmployeeWorkList = new ArrayList<>();
        // 循环员工个数，做成全部员工数据
        for (EmployeeWork employee : inEmployeeWorkList) {
            // 做成一个员工数据
            for (EmployeeWork employeeWork : employeeWorkList) {
                EmployeeWork newEmployeeWork = new EmployeeWork();
                newEmployeeWork.setEmployee(employee.getEmployee());
                newEmployeeWork.setPm(employee.getPm());
                newEmployeeWork.setPro(employee.getPro());
                newEmployeeWork.setYear(employee.getYear());
                newEmployeeWork.setLevel(employeeWork.getLevel());
                newEmployeeWork.setUseMonth(employeeWork.getUseMonth());
                newEmployeeWork.setUseStatus(employeeWork.getUseStatus());
                newEmployeeWork.setUseMemo(employeeWork.getUseMemo());
                employeeWork.setEntID(employeeWork.getEntID());
                newEmployeeWorkList.add(newEmployeeWork);
            }
        }
        // 旧数据删除
        employeeWorkMapper.delEmployeeWorkInfo(inEmployeeWorkList);

        //新数据插入
        employeeWorkMapper.insEmployeeWorkInfo(newEmployeeWorkList);
        logger.info("*******CopyEmployeeServiceWorkImpl End********");*/
//        return 0;
//    }
    @Override
    public int uptEmployeeWorkInfo(EmployeeWorkYear employeeWorkYear){
        logger.info("*******uptEmployeeWorkInfo Start********");
        List<EmployeeWork> employeeWorkList = new ArrayList<>();
        List<String> useStatusByMonth =employeeWorkYear.getUsemon();
        List<String> projectIdByMonth =employeeWorkYear.getPromon();
        List<String> caseNameByMonth = employeeWorkYear.getCasenamemon();
        for(int i=0;i<useStatusByMonth.size();i++){
            String useStatus=useStatusByMonth.get(i);
            if(!"9".equals(useStatus)){
                EmployeeWork employeeWork = new EmployeeWork();
                // 员工ID
                employeeWork.setEmployee(employeeWorkYear.getEmployee());
                //员工Pm
                employeeWork.setPm(employeeWorkYear.getPm());
                //员工当月所属项目
                employeeWork.setPro(projectIdByMonth.get(i));
                //年度
                employeeWork.setYear(employeeWorkYear.getYear());
                //月份
                employeeWork.setUseMonth(String.valueOf(i+1));
                //利用情况
                employeeWork.setUseStatus(useStatus);
                //员工当月所属案件名
                employeeWork.setCaseName(caseNameByMonth.get(i));
                //备注
                employeeWork.setUseMemo(employeeWorkYear.getUseMemo());
                //更新者ID
                employeeWork.setEntID("");
                employeeWorkList.add(employeeWork);

            }
        }
        employeeWorkMapper.uptEmployeeWorkInfo(employeeWorkList);
        logger.info("*******uptEmployeeWorkInfo End********");
        return 0;
    }

    @Override
    public List<EmployeeWorkYear> getEmployeeWorkInfoAll(String startDt,String endDt) {
        logger.info("*******getEmployeeWorkInfo Start********");
        //employeeWorkDB的数据取得
        List<EmployeeWork> employeeWorkList = employeeWorkMapper.getEmployeeWorkInfoAll(startDt,endDt);

        //12个月的项目利用状况
        List<String> useMonthStatus;
        //12个月所属的项目ID
        List<String> useMonthProjectId;
        //12个月所属的项目名称
        List<String> useMonthProjectName;
        //12个月所属案件名
        List<String> userMonthCaseName;
        // 员工年间项目情况
        EmployeeWorkYear employeeWorkYear;

        // 员工NO、PMID，年份作为key整理数据
        Map<String, EmployeeWorkYear> map = new HashMap<>();
        String userkey="";
        // 循环work表数据
        for (EmployeeWork employeeWork : employeeWorkList) {
            // key做成
            userkey =
                    employeeWork.getEmployee()
                            + employeeWork.getPm()
                            + employeeWork.getYear();

            // 员工当年数据存在时从Map取得员工年份数据
            if(map.containsKey(userkey)) {
                employeeWorkYear=map.get(userkey);
            }else{
                // 员工当年数据不存在时创建员工年份数据
                employeeWorkYear=creatEmployeeWorkYear(employeeWork);
            }

            // 月份以及每月项目利用情况取得
            useMonthStatus = employeeWorkYear.getUsemon();
            useMonthProjectId = employeeWorkYear.getPromon();
            useMonthProjectName = employeeWorkYear.getPronamemon();
            userMonthCaseName = employeeWorkYear.getCasenamemon();
            // 月份以及每月项目利用情况编辑
            creatMonAndProData(employeeWork,useMonthStatus,useMonthProjectId,useMonthProjectName,userMonthCaseName);
            // 月份以及每月项目利用情况设定
            employeeWorkYear.setPromon(useMonthProjectId);
            employeeWorkYear.setUsemon(useMonthStatus);
            employeeWorkYear.setPronamemon(useMonthProjectName);
            employeeWorkYear.setCasenamemon(userMonthCaseName);
            // 编辑好的数据设定到Map中
            map.put(userkey,employeeWorkYear);
        }

        //出力用List定义
        List<EmployeeWorkYear> employeeWorkYearList = new ArrayList<EmployeeWorkYear>();
        //循环Map，出力List做成
        for(String key:map.keySet()){
            employeeWorkYearList.add(map.get(key));
        }
        logger.info("*******getEmployeeWorkInfo End********");

        return employeeWorkYearList;
    }

    @Override
    public List<EmployeeWorkYear> getEmployeeWorkInfoAllList(EmployeeWork employeeWorklist) {
        logger.info("*******getEmployeeWorkInfo Start********");
        //employeeWorkDB的数据取得
        List<EmployeeWork> employeeWorkList = employeeWorkMapper.getEmployeeWorkInfoAllList(employeeWorklist);

        //12个月的项目利用状况
        List<String> useMonthStatus;
        //12个月所属的项目ID
        List<String> useMonthProjectId;
        //12个月所属的项目名称
        List<String> useMonthProjectName;
        //12个月所属案件名
        List<String> userMonthCaseName;
        // 员工年间项目情况
        EmployeeWorkYear employeeWorkYear;

        // 员工NO、PMID，年份作为key整理数据
        Map<String, EmployeeWorkYear> map = new HashMap<>();
        String userkey="";
        // 循环work表数据
        for (EmployeeWork employeeWork : employeeWorkList) {
            // key做成
            userkey =
                    employeeWork.getEmployee()
                            + employeeWork.getPm()
                            + employeeWork.getYear();

            // 员工当年数据存在时从Map取得员工年份数据
            if(map.containsKey(userkey)) {
                employeeWorkYear=map.get(userkey);
            }else{
                // 员工当年数据不存在时创建员工年份数据
                employeeWorkYear=creatEmployeeWorkYear(employeeWork);
            }

            // 月份以及每月项目利用情况取得
            useMonthStatus = employeeWorkYear.getUsemon();
            useMonthProjectId = employeeWorkYear.getPromon();
            useMonthProjectName = employeeWorkYear.getPronamemon();
            userMonthCaseName = employeeWorkYear.getCasenamemon();
            // 月份以及每月项目利用情况编辑
            creatMonAndProData(employeeWork,useMonthStatus,useMonthProjectId,useMonthProjectName,userMonthCaseName);
            // 月份以及每月项目利用情况设定
            employeeWorkYear.setPromon(useMonthProjectId);
            employeeWorkYear.setUsemon(useMonthStatus);
            employeeWorkYear.setPronamemon(useMonthProjectName);
            employeeWorkYear.setCasenamemon(userMonthCaseName);
            // 编辑好的数据设定到Map中
            map.put(userkey,employeeWorkYear);
        }

        //出力用List定义
        List<EmployeeWorkYear> employeeWorkYearList = new ArrayList<EmployeeWorkYear>();
        //循环Map，出力List做成
        for(String key:map.keySet()){
            employeeWorkYearList.add(map.get(key));
        }
        logger.info("*******getEmployeeWorkInfo End********");

        return employeeWorkYearList;
    }

    // 员工该年项目情报做成
    private EmployeeWorkYear creatEmployeeWorkYear(EmployeeWork employeeWork){

        EmployeeWorkYear employeeWorkYear = new EmployeeWorkYear();
        // 员工ID
        employeeWorkYear.setEmployee(employeeWork.getEmployee());
        //员工PmID
        employeeWorkYear.setPm(employeeWork.getPm());
        //员工Pm名字
        employeeWorkYear.setPmName(employeeWork.getPmName());
        //员工当月所属项目
        employeeWorkYear.setPro(employeeWork.getPro());
        //员工当月所属项目名
        employeeWorkYear.setProName(employeeWork.getProName());
        //员工当月所属案件名
        employeeWorkYear.setCaseName(employeeWork.getCaseName());
        //年度
        employeeWorkYear.setYear(employeeWork.getYear());
        //备注
        employeeWorkYear.setUseMemo(employeeWork.getUseMemo());
        //员工姓名
        employeeWorkYear.setName(employeeWork.getName());
        //员工级别
        employeeWorkYear.setLevel(employeeWork.getLevel());
        //员工部门
        employeeWorkYear.setRoles(employeeWork.getRoles());
        //员工擅长技术
        employeeWorkYear.setTech(employeeWork.getTech());
        //12个月份的项目名称
        List<String> useMonthStatus = new ArrayList<>();
        List<String> useMonthProjectId  = new ArrayList<>();
        List<String> useMonthProjectName = new ArrayList<>();
        List<String> useMonthCaseName = new ArrayList<>();
        // 月份利用情况和每月项目情况初期化
        for(int i=0;i<12;i++){
            useMonthStatus.add("9");
            useMonthStatus.set(i,"9");
            useMonthProjectId.add("");
            useMonthProjectId.set(i,"");
            useMonthProjectName.add("");
            useMonthProjectName.set(i,"");
            useMonthCaseName.add("");
            useMonthCaseName.set(i,"");
        }
        employeeWorkYear.setUsemon(useMonthStatus);
        employeeWorkYear.setPromon(useMonthProjectId);
        employeeWorkYear.setPronamemon(useMonthProjectName);
        employeeWorkYear.setCasenamemon(useMonthCaseName);
        return employeeWorkYear;
    }

    // 员工当年各月份项目情况做成
    private void creatMonAndProData(EmployeeWork employeeWork, List<String> useMonthStatusList, List<String> useMonthProjectIdList,List<String> useMonthProjectNameList,List<String> useMonthCaseNameList){
        String useMonth=employeeWork.getUseMonth();
        switch (useMonth) {
            case "01":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "02":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "03":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "04":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "05":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "06":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "07":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "08":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "09":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "10":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "11":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
            case "12":
                creatUseMonthDetail(employeeWork,useMonthStatusList,useMonthProjectIdList,useMonthProjectNameList,useMonthCaseNameList);
                break;
        }
    }
    // 每个月的项目使用情况做成
    private void creatUseMonthDetail(EmployeeWork employeeWork, List<String> useMonthStatusList, List<String> useMonthProjectIdList,List<String> useMonthProjectNameList,List<String> useMonthCaseNameList){
        int index=Integer.valueOf(employeeWork.getUseMonth())-1;
        useMonthStatusList.set(index,employeeWork.getUseStatus());
        useMonthProjectIdList.set(index,employeeWork.getPro());
        useMonthProjectNameList.set(index,employeeWork.getProName());
        useMonthCaseNameList.set(index,employeeWork.getCaseName());
    }
}

