package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.entity.MEmployee;
import com.webservice.ahiru.entity.MEmployeePm;
import com.webservice.ahiru.mapper.MEmployeeMapper;
import com.webservice.ahiru.mapper.MEmployeePmMapper;
import com.webservice.ahiru.service.MEmployeePmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songxipeng
 * @since 2019-12-16
 */
//service标注业务层组件
@Service
public class MEmployeePmServiceImpl implements MEmployeePmService {

    //Service接口的实现类
    @Autowired
    MEmployeePmMapper mEmployeePmMapper;

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取数据库表（M_EMPLOYEE）的数据，以list列表的形式，把查询出来的数据保存在数据对象中，返回对象mEmployeePmService.getMEmployees()
    //根据员工编号相等( M_EMPLOYEE.EMPLOYEE_NO = M_EMP_DTL.EMPLOYEE_NO ) 并且 权限等于0或者等于1 ( M_EMP_DTL.ROLE = '0' OR M_EMP_DTL.ROLE = '1')
    //并且 权限等于0 ( M_EMPLOYEE.DEL_FG = '0' ) AND ( M_EMP_DTL.DEL_FG = '0' ) 来查询表（M_EMPLOYEE）中员工编号（EMPLOYEE_NO）和 员工姓名（NAME）
    public List<MEmployeePm> getMEmployees() {

        List<MEmployeePm> mEmployees = mEmployeePmMapper.getInfos();

        return mEmployees;
    }
}
