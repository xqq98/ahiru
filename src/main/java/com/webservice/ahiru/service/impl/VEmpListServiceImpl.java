package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.entity.VEmpList;
import com.webservice.ahiru.mapper.VEmpListMapper;
import com.webservice.ahiru.service.VEmpListService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuxianlong
 * @since 2020-01-13
 */
//service标注业务层组件
@Service
public class VEmpListServiceImpl extends ServiceImpl<VEmpListMapper, VEmpList> implements VEmpListService {

}
