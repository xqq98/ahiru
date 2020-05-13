package com.webservice.ahiru.service.impl;


import com.alibaba.druid.util.StringUtils;
import com.webservice.ahiru.entity.PmChosen;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.PmChosenMapper;
import com.webservice.ahiru.service.PmChosenService;
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
 * @since 2020-01-16
 */
//service标注业务层组件
@Service
public class PmChosenServiceImpl implements PmChosenService {

    //Service接口的实现类
    @Autowired
    PmChosenMapper pmChosenMapper;

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取视图（V_PM_CHOSEN）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据三个主键），返回resultPmChosen
    public List<PmChosen> getPmChosen(PmChosen pmChosen) {
        try{
            if(!StringUtils.isEmpty(pmChosen.getStartDt()) ){
                int startDATE = Integer.parseInt(pmChosen.getStartDt().substring(4));
                int endDATE = Integer.parseInt(pmChosen.getEndDt().substring(4));
                List<String> monthList1 = new ArrayList<>();
                for(int i = startDATE;i<endDATE+1;i++){
                    monthList1.add("a"+i);
                }
                pmChosen.setMonthList(monthList1);
            }

        List<PmChosen> resultPmChosen = pmChosenMapper.getPmChosen(pmChosen);

        return resultPmChosen;}
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AhiruException("信息获取失败");
        }
    }
}
