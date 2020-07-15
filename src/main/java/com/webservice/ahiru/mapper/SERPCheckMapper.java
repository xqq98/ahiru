package com.webservice.ahiru.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.webservice.ahiru.entity.SERPCheck;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
*  Mapper 接口
* </p>
*
* @author liliang
* @since 2020-07-02
*/
//用于标注数据访问组件，即DAO组件。
@Repository
//添加接口
@Mapper
//数据库访问接口类
public interface SERPCheckMapper extends BaseMapper<SERPCheck> {

    //查询数据
    List<SERPCheck> getInfo(SERPCheck sERPCheck);
}
