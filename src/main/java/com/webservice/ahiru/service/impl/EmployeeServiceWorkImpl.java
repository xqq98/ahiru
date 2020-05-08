package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.entity.EmployeeWork;
import com.webservice.ahiru.entity.EmployeeWorkYear;
import com.webservice.ahiru.entity.SEVEmpList;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.EmployeeWorkMapper;
import com.webservice.ahiru.mapper.EmployeeWorkYearMapper;
import com.webservice.ahiru.service.EmployeeWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


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
    @Autowired
    EmployeeWorkYearMapper employeeWorkYearMapper;

    //Service接口的实现类
    private Logger logger = LoggerFactory.getLogger(EmployeeServiceWorkImpl.class);

    // 取得全部年度工作情报
    @Override
    public List<EmployeeWorkYear> getEmployeeWorkInfo(SEVEmpList sEVEmpList) {
        logger.info("*******getEmployeeWorkInfo Start********");
        try {
            // 数据取得
            List<EmployeeWorkYear>  employeeWorkYearList =
                    employeeWorkYearMapper.getEmployeeWorkInfo(sEVEmpList);
            String pmId;
            String pmName;
            String caseName;
            List<EmployeeWorkYear> empList = new ArrayList<EmployeeWorkYear>();

            for (EmployeeWorkYear employee:employeeWorkYearList){
                pmId=employee.getPmId();
                int flag = 0;
                if (sEVEmpList.getStartDt()!=null && !"".equals(sEVEmpList.getStartDt())){
                    String strMonth = getMonth(sEVEmpList.getStartDt(),sEVEmpList.getEndDt());
                    if (strMonth.contains("01")){
                        if (employee.getUseStatus01()==null || employee.getUseStatus01().endsWith("0")){
                            flag=1;
                        }
                    }
                    if (strMonth.contains("02")){
                        if (employee.getUseStatus02()==null || employee.getUseStatus02().endsWith("0")){
                            flag=1;
                        }
                    }

                    if (strMonth.contains("03")){
                        if (employee.getUseStatus03()==null || employee.getUseStatus03().endsWith("0")){
                            flag=1;

                        }
                    }

                    if (strMonth.contains("04")){
                        if (employee.getUseStatus04()==null || employee.getUseStatus04().endsWith("0")){
                            flag=1;
                        }
                    }

                    if (strMonth.contains("05")){
                        if (employee.getUseStatus05()==null || employee.getUseStatus05().endsWith("0")){
                            flag=1;
                        }
                    }
                    if (strMonth.contains("06")){
                        if (employee.getUseStatus06()==null || employee.getUseStatus06().endsWith("0")){
                            flag=1;
                        }
                    }

                    if (strMonth.contains("07")){
                        if (employee.getUseStatus07()==null || employee.getUseStatus07().endsWith("0")){
                            flag=1;
                        }
                    }

                    if (strMonth.contains("08")){
                        if (employee.getUseStatus08()==null || employee.getUseStatus08().endsWith("0")){
                            flag=1;
                        }
                    }

                    if (strMonth.contains("09")){
                        if (employee.getUseStatus09()==null || employee.getUseStatus09().endsWith("0")){
                            flag=1;
                        }
                    }

                    if (strMonth.contains("10")){
                        if (employee.getUseStatus10()==null || employee.getUseStatus10().endsWith("0")){
                            flag=1;
                        }
                    }

                    if (strMonth.contains("11")){
                        if (employee.getUseStatus11()==null || employee.getUseStatus11().endsWith("0")){
                            flag=1;
                        }
                    }

                    if (strMonth.contains("12")){
                        if (employee.getUseStatus12()==null || employee.getUseStatus12().endsWith("0")){
                            flag=1;

                        }
                    }
                }
                if(!"".equals(pmId)&&!(pmId==null)&&pmId.contains(",")){
                    pmId=pmId.split(",")[0];
                    employee.setPmId(pmId);
                }

                 pmName=employee.getPmName();
                if(!"".equals(pmName)&&!(pmName==null)&&pmName.contains(",")){
                    pmName=pmName.split(",")[0];
                    employee.setPmName(pmName);
                }
                caseName=employee.getCaseName();
                if(!"".equals(caseName)&&!(caseName==null)&&caseName.contains(",")){
                    caseName=caseName.split(",")[0];
                    employee.setCaseName(caseName);
                }
                String[] useStatus =
                        {employee.getUseStatus01(),
                        employee.getUseStatus02(),
                        employee.getUseStatus03(),
                        employee.getUseStatus04(),
                        employee.getUseStatus05(),
                        employee.getUseStatus06(),
                        employee.getUseStatus07(),
                        employee.getUseStatus08(),
                        employee.getUseStatus09(),
                        employee.getUseStatus10(),
                        employee.getUseStatus11(),
                        employee.getUseStatus12(),};
                employee.setUseStatus(useStatus);
                if (flag==1){
                    empList.add(employee);
                }else if (sEVEmpList.getStartDt()==null || "".equals(sEVEmpList.getStartDt())){
                    empList.add(employee);
                }
            }
            return empList ;
        } catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new AhiruException("getEmployeeWorkInfo失败");
        }
    }
    // 取得个人年度工作情报
    @Override
    public List<EmployeeWork> getEmployeeWorkDetail(EmployeeWork employeeWork) {
        try {
            // 数据取得
        List<EmployeeWork> EmployeeWorkList =
                employeeWorkMapper.getEmployeeWorkDetail(employeeWork);
        return employeeWorkMapper.getEmployeeWorkDetail(employeeWork);
        } catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new AhiruException("getEmployeeWorkDetail失败");
        }
    }

    @Override
    @Transactional
    public int uptEmployeeWorkInfo(List employeeWorkList){
        logger.info("*******uptEmployeeWorkInfo Start********");
        try {
        employeeWorkMapper.delEmployeeWorkInfo(employeeWorkList);
        employeeWorkMapper.insEmployeeWorkInfo(employeeWorkList);
        logger.info("*******uptEmployeeWorkInfo End********");
        } catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new AhiruException("getEmployeeWorkDetail失败");
        }
        return 0;
    }


    private String getMonth(String sd,String ed) {
        int ints=Integer.valueOf(sd.substring(3));
        int inte=Integer.valueOf(ed.substring(3));
        List<String> arry = new ArrayList<String>();

        for (int i=ints;i<=inte;i++){
            arry.add(String.valueOf(100+i).substring(1));
        }
        String res=arry.toString();

        return res;
    }
}

