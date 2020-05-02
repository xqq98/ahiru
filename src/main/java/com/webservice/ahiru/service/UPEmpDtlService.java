package com.webservice.ahiru.service;

import com.baomidou.mybatisplus.service.IService;
import com.webservice.ahiru.entity.UPEmpDtl;
import com.webservice.ahiru.pojo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanghao
 * @since 2020-12-31
 */
//Service层业务接口类编写
public interface UPEmpDtlService extends IService<UPEmpDtl> {
    //获取数据库表（M_EMP_DTL）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
    Result getInfo(UPEmpDtl upEmpDtl);

    //更新表（M_EMP_DTL）
    Result UpdateEmpInfo(UPEmpDtl uPEmpDtl);

    //更新表（M_EMP_DTL）
    Result UpdateBpInfo(UPEmpDtl upEmpDtl);
}
