package com.webservice.ahiru.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.webservice.ahiru.entity.MEmpDtl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanghao
 * @since 2019-12-31
 */

//用于标注数据访问组件，即DAO组件。
@Repository
//添加接口
@Mapper
//数据库访问接口类
public interface MEmpDtlMapper extends BaseMapper<MEmpDtl> {

    // 查询数据
    public List<MEmpDtl> getInfo(MEmpDtl mEmpDtl);

    //修改数据
    public int UpdateInfo(MEmpDtl MEmpDtl);

}
