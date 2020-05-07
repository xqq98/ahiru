package com.webservice.ahiru.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.webservice.ahiru.controller.VEmpListController;
import com.webservice.ahiru.entity.VEmpList;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.VEmpListMapper;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.VEmpListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

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
    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(VEmpListController.class);

    //Service接口的实现类
    @Autowired
    private VEmpListMapper VEmpListMapper;
    @Override
    public Result getInfo(VEmpList VEmpList) {
        Result resul = null;
        try {
            System.out.println("===============code:"+VEmpList.getId() +"=================");

            List<VEmpList> result = new ArrayList<VEmpList>();

            if(VEmpList != null){
                result = VEmpListMapper.getInfo(VEmpList);

                //获取当前时间戳
                long nowDate = System.currentTimeMillis();
                //两个月60天的毫秒数
                String twomonth = "5184000000";

                //将两个月的毫秒数转换成long
                long month = Long.parseLong(twomonth);

                //将当前时间+60天
                long nowAddtwomonth = nowDate + month;
                System.out.println("nowAddtwomonth="+nowAddtwomonth);
                for(int i=0;i<result.size();i++){
                    char first=result.get(i).getId().charAt(0);
//                    System.out.println(first+"-"+i+""+result.get(i).getOutDate()+"********");
                    if(first == '9'){
                        //将数据中离职时间信息转换成时间戳
                        if(result.get(i).getOutDate() != null && result.get(i).getOutDate() !=""){
                            String timeStamp = date2TimeStamp(result.get(i).getOutDate(), "yyyy-MM-dd");
                            long personalleveltime = Long.parseLong(timeStamp);
                            if(nowAddtwomonth >= personalleveltime){
                                result.get(i).setColor("yellow");
                            }else {
                                result.get(i).setColor("white");
                            }
                        }
                        else{
                            result.get(i).setColor("white");
                        }
                    }else {
                        if(result.get(i).getOutDate() != null){
                            result.get(i).setColor("gray");
                        }
                        else{
                            result.get(i).setColor("white");
                        }
                    }
                }
            }
            resul = new Result(result);
        } catch (Exception e) {
            //  e.printStackTrace();
            resul = Result.error(e.getMessage());
            logger.info("数据异常"+e.getMessage());
            throw new AhiruException("数据异常");
        }
        return resul;
    }

    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            return String.valueOf(sdf.parse(date_str).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}

