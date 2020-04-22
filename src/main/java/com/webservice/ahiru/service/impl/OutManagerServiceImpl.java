package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.entity.OutManager;
import com.webservice.ahiru.mapper.OutManagerMapper;
import com.webservice.ahiru.service.OutManagerService;
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
public class OutManagerServiceImpl extends ServiceImpl<OutManagerMapper, OutManager> implements OutManagerService {

}
