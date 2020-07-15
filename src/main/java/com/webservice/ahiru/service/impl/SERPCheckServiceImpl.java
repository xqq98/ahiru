package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.entity.SERPCheck;
import com.webservice.ahiru.mapper.SERPCheckMapper;
import com.webservice.ahiru.service.SERPCheckService;
import org.springframework.stereotype.Service;

/**
* <p>
*  服务实现类
* </p>
*
* @author liliang
* @since 2020-07-02
*/
//service标注业务层组件
@Service
public class SERPCheckServiceImpl extends ServiceImpl<SERPCheckMapper, SERPCheck> implements SERPCheckService {

}
