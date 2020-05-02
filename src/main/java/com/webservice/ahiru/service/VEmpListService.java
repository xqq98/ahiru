package com.webservice.ahiru.service;

import com.baomidou.mybatisplus.service.IService;
import com.webservice.ahiru.entity.VEmpList;
import com.webservice.ahiru.pojo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuxianlong
 * @since 2020-01-13
 */
//Service层业务接口类编写
public interface VEmpListService extends IService<VEmpList> {
    //查询视图（V_EMP_LIST）的数据以列表的形式输出
    Result getInfo(VEmpList VEmpList);

}
