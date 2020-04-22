package com.webservice.ahiru.mapper;
import com.webservice.ahiru.entity.PmChosen;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Rocky.Yu
 * @since 2020-01-16
 */
//用于标注数据访问组件，即DAO组件。
@Repository
//添加接口
@Mapper
//数据库访问接口类
public interface PmChosenMapper {

    //获取视图（V_PM_CHOSEN）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据个主键）
    public List<PmChosen> getPmChosen(PmChosen pmChosen);
}
