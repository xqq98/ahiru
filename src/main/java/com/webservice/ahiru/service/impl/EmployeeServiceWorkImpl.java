package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.entity.EmployeeWork;
import com.webservice.ahiru.entity.EmployeeWorkYear;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.EmployeeWorkMapper;
import com.webservice.ahiru.mapper.EmployeeWorkYearMapper;
import com.webservice.ahiru.service.EmployeeWorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<EmployeeWorkYear> getEmployeeWorkInfo(EmployeeWorkYear employeeWorkYear) {
        logger.info("*******getEmployeeWorkInfo Start********");
        try {
            // 数据取得
            List<EmployeeWorkYear>  EmployeeWorkYearList =
                    employeeWorkYearMapper.getEmployeeWorkInfo(employeeWorkYear);
            String pmId;
            String pmName;
            String caseName;
            for (EmployeeWorkYear employee:EmployeeWorkYearList){
                pmId=employee.getPmId();
                if(!"".equals(pmId)&&pmId.contains(",")){
                    pmId=pmId.split(",")[0];
                    employee.setPmId(pmId);
                }
                 pmName=employee.getPmName();
                if(!"".equals(pmName)&&pmName.contains(",")){
                    pmName=pmName.split(",")[0];
                    employee.setPmName(pmName);
                }
                caseName=employee.getCaseName();
                if(!"".equals(caseName)&&caseName.contains(",")){
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
            }
            return EmployeeWorkYearList ;
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
}

