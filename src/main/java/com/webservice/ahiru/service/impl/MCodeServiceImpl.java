package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.entity.MCode;
import com.webservice.ahiru.mapper.MCodeMapper;
import com.webservice.ahiru.service.MCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mengliang
 * @since 2020-01-07
 */

//service标注业务层组件
@Service
public class MCodeServiceImpl implements MCodeService {

    //Service接口的实现类
    @Autowired
    MCodeMapper mCodeMapper;

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取数据库表（M_CODE）的数据，以list列表的形式，把查询出来的数据保存在数据对象中(根据主键查询)，返回对象mCode。
    //根据通用代码（HANYOU_CODE）来查询表（M_CODE）下的所有数据
    public List<MCode> getMCodeByCode(String hanYouCode) {

        List<MCode> mCode = mCodeMapper.getMCodeByCode(hanYouCode);

        return mCode;
    }

    //获取数据库表（M_CODE）的数数据，以list列表的形式，把查询出来的数据保存在数据对象中，返回对象mCodeName。
    //根据通用代码（HANYOU_CODE = 'DEP_ROLE' OR HANYOU_CODE = 'TECH_DIREC'）来查询表（M_CODE）中通用代码实例名（HANYOU_VALUE_NAME）的值
    public List<MCode> getMCode() {

        List<MCode> mCodeName = mCodeMapper.getMCode();

        return mCodeName;
    }

}