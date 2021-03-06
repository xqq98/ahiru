package com.webservice.ahiru.service;

import com.webservice.ahiru.entity.SEVEmpList;
import com.webservice.ahiru.pojo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanghao
 * @since 2020-02-28
 */
//Service层业务接口类编写
public interface SEVEmpListService {

    //获取视图（V_PM_CHOSEN）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据三个主键）
    Result getInFo(String startDt, String endDt);

    Result getInfoAll(SEVEmpList sevEmpList);

}
