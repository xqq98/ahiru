package com.webservice.ahiru.mapper;

import com.webservice.ahiru.entity.MCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mengliang
 * @since 2020-1-7
 */
//用于标注数据访问组件，即DAO组件。
@Repository
//添加接口
@Mapper
//数据库访问接口类
public interface MCodeMapper {

    // 查询数据（根据主键查询）
    public List<MCode> getMCodeByCode(String hanYouCode);

    // 查询数据
    public List<MCode> getMCode();

}
