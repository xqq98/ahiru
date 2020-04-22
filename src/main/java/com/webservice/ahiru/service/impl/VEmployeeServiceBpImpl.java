package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.entity.VEmployeeBp;
import com.webservice.ahiru.mapper.VEmployeeBpMapper;
import com.webservice.ahiru.service.VEmployeeBpService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songxipeng
 * @since 2019-11-18
 */
//service标注业务层组件
@Service
public class VEmployeeServiceBpImpl extends ServiceImpl<VEmployeeBpMapper, VEmployeeBp> implements VEmployeeBpService {

}
