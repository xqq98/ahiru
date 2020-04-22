package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.entity.MEmployee;
import com.webservice.ahiru.mapper.MEmployeeMapper;
import com.webservice.ahiru.service.MEmployeeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songxipeng
 * @since 2019-12-16
 */
//service标注业务层组件
@Service
public class MEmployeeServiceImpl extends ServiceImpl<MEmployeeMapper, MEmployee> implements MEmployeeService {

}
