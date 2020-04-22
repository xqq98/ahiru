package com.webservice.ahiru.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.webservice.ahiru.entity.VEmployeeBpDtl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VEmployeeBpDtlMapper extends BaseMapper<VEmployeeBpDtl> {
    public List<VEmployeeBpDtl> getInfo();
    public List<VEmployeeBpDtl> getby(VEmployeeBpDtl vEmployeeBpDtl);
    public List<VEmployeeBpDtl> getidle();
    public List<VEmployeeBpDtl> getmonth(String month);
}
