package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.entity.VEmployeeOut;
import com.webservice.ahiru.mapper.VEmployeeOutMapper;
import com.webservice.ahiru.service.VEmployeeOutService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijunchen
 * @since 2020-03-09
 */
//service标注业务层组件
@Service
public class VEmployeeOutServiceImpl extends ServiceImpl<VEmployeeOutMapper, VEmployeeOut> implements VEmployeeOutService {

}
