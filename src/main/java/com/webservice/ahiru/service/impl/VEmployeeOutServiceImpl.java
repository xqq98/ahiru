package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.controller.VEmployeeOutController;
import com.webservice.ahiru.entity.VEmployeeOut;
import com.webservice.ahiru.mapper.VEmployeeOutMapper;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.VEmployeeOutService;
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
public class VEmployeeOutServiceImpl extends ServiceImpl<VEmployeeOutMapper, VEmployeeOut> implements VEmployeeOutService {

    /**
     *
     * @Target(ElementType.METHOD) getInfo
     * @Target(ElementType.PARAMETER) MEmpDtl mEmpDtl
     * 查询视图（V_EMP_OUT）的数据以列表的形式输出，调用vEmployeeOUTMapper的getInfo方法，返回对象result
     * 根据员工编号（EMPLOYEE_NO）来查询视图（V_EMP_OUT）下的数据
     *
     * @author lijunchen
     * @since 2020-03-09
     */

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(VEmployeeOutController.class);

    @Autowired

    private VEmployeeOutMapper vEmployeeOutMapper;

    @Override
    public Result getInfo(VEmployeeOut vEmployeeOut) {

        Result result = null;

        try {
            System.out.println("===============ID:"+vEmployeeOut.getId() +"=================");


            List<VEmployeeOut> list = new ArrayList<VEmployeeOut>();

            if(vEmployeeOut != null){
                list = vEmployeeOutMapper.getInfo(vEmployeeOut);
            }
          //  return result;
            result = Result.ok(list);
        } catch (Exception e) {
          //  e.printStackTrace();
            result = Result.error(e.getMessage());
            logger.info("数据异常"+e.getMessage());
        }
        return result;
    }

//    public List<OutPersonManager> getInfo(OutPersonManager outPersonManager) {
//
//        System.out.println("===============ID:"+outPersonManager.getManager() +"=================");
//
//
//        List<OutPersonManager> result = new ArrayList<OutPersonManager>();
//
//        if(outPersonManager != null){
//            result = vEmployeeOUTMapper.getMANAGER(outPersonManager);
//        }
//        return result;
//    }

    //查询部门
    @Override
    public Result getBU(VEmployeeOut vEmployeeOut) {

       // Bu a = null;
        Result a = null;
        try {
           // a = new Bu();
            List<String> list=new ArrayList<>();
            System.out.println("===============BU:"+vEmployeeOut.getBu() +"=================");
            List<VEmployeeOut> result = new ArrayList<VEmployeeOut>();

            if(vEmployeeOut != null){
                result = vEmployeeOutMapper.getBU(vEmployeeOut);
            }
//        过滤重复数据
            for(int i=0;i<result.size();i++){
                if (!list.contains(result.get(i).getBu())) {
                    list.add(result.get(i).getBu());
                }
            }
          //  a.setBu(list);
            a = new Result(list);
        } catch (Exception e) {
            //e.printStackTrace();
            a = Result.error(e.getMessage());
            logger.info("数据异常"+e.getMessage());
        }
        return a;
    }
}
