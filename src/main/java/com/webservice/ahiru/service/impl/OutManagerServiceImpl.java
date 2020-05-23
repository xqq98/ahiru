package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.controller.MProjectController;
import com.webservice.ahiru.entity.OutManager;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.OutManagerMapper;
import com.webservice.ahiru.service.OutManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MProjectController.class);

    @Autowired
    private OutManagerMapper outManagerMapper;

    /**
     *

     * 查询视图（V_EMP_OUT）的数据以列表的形式输出，调用outManagerMapper的getInfo方法，返回对象result
     * 根据员工编号（Manager）来查询视图（V_EMP_OUT）下的数据

     */
    @Override
    public List<OutManager> getInfo(OutManager outManager) {

//        System.out.println("===============OutManager:"+OutManager.getManager()+"=================");


        try {
            List<OutManager> list = new ArrayList<OutManager>();

            if(outManager != null){
                list = outManagerMapper.getInfo(outManager);
            }
            return list;
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw new AhiruException("信息获取失败");
        }
    }
}
