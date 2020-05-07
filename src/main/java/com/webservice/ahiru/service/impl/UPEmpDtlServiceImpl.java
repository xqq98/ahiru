package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.common.UserUtil;
import com.webservice.ahiru.controller.VEmpListController;
import com.webservice.ahiru.entity.UPEmpDtl;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.UPEmpDtlMapper;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.UPEmpDtlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class UPEmpDtlServiceImpl extends ServiceImpl<UPEmpDtlMapper, UPEmpDtl> implements UPEmpDtlService {
    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(VEmpListController.class);

    //Mapper接口的实现类
    @Autowired
    private UPEmpDtlMapper upEmpDtlMapper;

    /**
     *
     * @Target(ElementType.METHOD) getInfo
     * @Target(ElementType.PARAMETER) @RequestBody UPEmpDtl upEmpDtl
     * 查询表（M_EMP_DTL）的数据以列表的形式输出，调用upEmpDtlMapper的getInfo方法，返回对象result
     * 根据员工编号（EMPLOYEE_NO）来查询表（M_EMP_DTL）的数据
     *
     * @author wanghao
     * @since 2019-2-17
     */
    @Override
    public Result getInfo(UPEmpDtl upEmpDtl) {
        Result resul = null;
        try {
            System.out.println("===============EmployeeNo:"+upEmpDtl.getId() +"=================");
            System.out.println("===============DepRole:"+upEmpDtl.getDepRole() +"=================");

            List<UPEmpDtl> result = new ArrayList<>();

            if(upEmpDtl != null){
                result = upEmpDtlMapper.getInfo(upEmpDtl);
            }
            resul = new Result(result);
        } catch (Exception e) {
            resul = Result.error((e.getMessage()));
            logger.info("数据异常"+e.getMessage());
        }
        return resul;
    }

    @Override
    public Result UpdateEmpInfo(UPEmpDtl uPEmpDtl) {
        Result resul = null;
        int uei = 0;
        try{
            String username= UserUtil.getLoginUser();
            uPEmpDtl.setUpdId(username);
            uPEmpDtl.setUpdDt((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
            uei = upEmpDtlMapper.UpdateEmpInfo(uPEmpDtl);
            if(uei == 0){
                throw new AhiruException("修改失败");
        }
            resul = new Result(uei);
        }catch (Exception e){
//            logger.error(ex.getMessage(),ex);
//            throw new AhiruException("修改失败");
            resul = Result.error((e.getMessage()));
            logger.info("修改失败"+e.getMessage());
        }
        return resul;
    }

    @Override
    public Result UpdateBpInfo(UPEmpDtl upEmpDtl) {
        Result resul = null;
        int ubi = 0;
        try{
            String username= UserUtil.getLoginUser();
            upEmpDtl.setUpdId(username);
            upEmpDtl.setUpdDt((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
            ubi = upEmpDtlMapper.UpdateBpInfo(upEmpDtl);
            if(ubi == 0){
                throw new AhiruException("修改失败");
            }
            resul = new Result(ubi);
        }catch (Exception e){
//            logger.error(e.getMessage(),e);
//            throw new AhiruException("修改失败");
            resul = Result.error((e.getMessage()));
            logger.info("修改失败"+e.getMessage());
        }
        return resul;
    }

}

