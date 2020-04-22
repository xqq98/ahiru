package com.webservice.ahiru.service;

import com.webservice.ahiru.entity.PmChosen;

import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rocky.Yu
 * @since 2020-01-16
 */
//Service层业务接口类编写
public interface PmChosenService {

    //获取视图（V_PM_CHOSEN）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据三个主键）
    public List<PmChosen> getPmChosen(PmChosen pmChosen);
}
