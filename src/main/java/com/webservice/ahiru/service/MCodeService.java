package com.webservice.ahiru.service;

import com.webservice.ahiru.entity.MCode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mengliang
 * @since 2020-1-7
 */
//Service层业务接口类编写
public interface MCodeService {

    // 查询数据（根据主键查询）
    public List<MCode> getMCodeByCode(String hanYouCode);

    // 查询数据
    public List<MCode> getMCode();
}

