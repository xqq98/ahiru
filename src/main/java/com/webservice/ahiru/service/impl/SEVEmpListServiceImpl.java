package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.entity.SEVEmpList;
import com.webservice.ahiru.mapper.SEVEmpListMapper;
import com.webservice.ahiru.service.SEVEmpListService;
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
 * @author wanghao
 * @since 2020-02-28
 */
//service标注业务层组件
@Service
public class SEVEmpListServiceImpl implements SEVEmpListService {

    //Service接口的实现类
    @Autowired
    SEVEmpListMapper seVEmpListMapper;

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取视图（V_PM_CHOSEN）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据三个主键），返回resultPmChosen
//    public List<SEVEmpList> getInFo(SEVEmpList svl) {
    public List<SEVEmpList> getInFo(String startDt,String endDt) {
        List<SEVEmpList> resultSEVEmpList = seVEmpListMapper.getInfoX(startDt,endDt);

        return resultSEVEmpList;
    }

    public List<SEVEmpList> getInfoAll(SEVEmpList sevEmpList) {
        List<SEVEmpList> resultSEVEmpLists = seVEmpListMapper.getInfoAll(sevEmpList);

        return resultSEVEmpLists;
    }

}
