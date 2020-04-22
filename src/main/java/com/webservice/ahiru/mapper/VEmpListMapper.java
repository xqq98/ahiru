package com.webservice.ahiru.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.webservice.ahiru.entity.VEmpList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuxianlong
 * @since 2020-01-13
 */
//用于标注数据访问组件，即DAO组件。
@Repository
//添加接口
@Mapper
//数据库访问接口类
public interface VEmpListMapper extends BaseMapper<VEmpList> {

    //查询视图（V_EMP_LIST）的数据以列表的形式输出
    List<VEmpList> getInfo(VEmpList VEmpList);
}
