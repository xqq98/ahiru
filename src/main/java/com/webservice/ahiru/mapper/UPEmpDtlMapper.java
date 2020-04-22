package com.webservice.ahiru.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.webservice.ahiru.entity.UPEmpDtl;
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
public interface UPEmpDtlMapper extends BaseMapper<UPEmpDtl> {

    //获取数据库表（M_EMP_DTL）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
    public List<UPEmpDtl> getInfo(UPEmpDtl upEmpDtl);

    //更新表（M_EMP_DTL）
    public int UpdateEmpInfo(UPEmpDtl uPEmpDtl);

    //更新表（M_EMP_DTL）
    public int UpdateBpInfo(UPEmpDtl upEmpDtl);

}
