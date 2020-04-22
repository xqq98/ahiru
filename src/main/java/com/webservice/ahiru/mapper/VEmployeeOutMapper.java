package com.webservice.ahiru.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.webservice.ahiru.entity.VEmployeeOut;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lijunchen
 * @since 2020-03-09
 */
//用于标注数据访问组件，即DAO组件。
@Repository
//添加接口
@Mapper
//数据库访问接口类
public interface VEmployeeOutMapper extends BaseMapper<VEmployeeOut> {

    //查询数据
    List<VEmployeeOut> getInfo(VEmployeeOut vEmployeeOUT);
    List<VEmployeeOut> getBU(VEmployeeOut vEmployeeOUT);
    List<VEmployeeOut> getMANAGER(VEmployeeOut vEmployeeOUT);
}
