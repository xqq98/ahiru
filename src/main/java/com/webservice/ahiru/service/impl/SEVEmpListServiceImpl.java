package com.webservice.ahiru.service.impl;

import com.webservice.ahiru.entity.SEVEmpList;
import com.webservice.ahiru.entity.VEmpList;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.mapper.SEVEmpListMapper;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.SEVEmpListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.webservice.ahiru.service.impl.VEmpListServiceImpl.date2TimeStamp;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanghao
 * @since 2020-02-28
 */
//service标注业务层组件
@Service
public class SEVEmpListServiceImpl implements SEVEmpListService {

    //Service接口的实现类
    @Autowired
    SEVEmpListMapper seVEmpListMapper;

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //伪代码,表示重写（下面的方法名是否是你父类中所有的）
    @Override
    //获取视图（V_PM_CHOSEN）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据三个主键），返回resultPmChosen
//    public List<SEVEmpList> getInFo(SEVEmpList svl) {
    public Result getInFo(String startDt, String endDt) {
        Result resul = null;
        try {
            List<SEVEmpList> result = seVEmpListMapper.getInfoX(startDt,endDt);
            resul = new Result(result);
        } catch (Exception e) {
            resul = Result.error((e.getMessage()));
            logger.info("数据异常"+e.getMessage());
        }

        return resul;
    }

    public Result getInfoAll(SEVEmpList sevEmpList) {
        Result resul = null;
        try {
            System.out.println("===============code:"+sevEmpList.getId() +"=================");

            List<SEVEmpList> result = new ArrayList<SEVEmpList>();

            if(sevEmpList != null){
                result = seVEmpListMapper.getInfoAll(sevEmpList);

                //获取当前时间戳
                long nowDate = System.currentTimeMillis();
                //两个月60天的毫秒数
                String twomonth = "5184000000";

                //将两个月的毫秒数转换成long
                long month = Long.parseLong(twomonth);

                //将当前时间+60天
                long nowAddtwomonth = nowDate + month;
//                System.out.println("nowAddtwomonth="+nowAddtwomonth);
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
                //计算入部年份
//                String Indeptime = "";
                for(int i = 0;i <result.size();i++){
                    String Indeptime = result.get(i).getInDepTime();//获取入部天数
                    if(Indeptime == null){//判断入部天数是否为空
                        result.get(i).setInDepYear("无");//如果入部天数为空 入部年数显示为空
                    }else {//如果入部天数不为空
                        int year = (Integer.valueOf(Indeptime))/365;//把入部天数转成int型 并计算入部年数
                        if(Integer.parseInt(Indeptime) < 365){//判断入部时间是否小于一年
                            result.get(i).setInDepYear(Indeptime+"天");//如果小于一年返回入部多少天
                        } else{//如果入部天数大于一年
                            String year1 = String.valueOf(year);//把入部年数转String
//                        System.out.println(year1+"****************************");
                            result.get(i).setInDepYear(year1+"年");//把入部年数返回给前台
                        }

                    }
                }
                //年齡
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY");//日期格式化
                Date date = new Date();//获取当前系统日期
                String nowyear = sdf.format(date);//把获取到的日期格式化为YYYY
                int nowyear1 = Integer.valueOf(nowyear);//把当前日期转换为int型

                for(int i=0;i<result.size();i++){
                    String birthDay = result.get(i).getBirthDay();//获取生日
                    if(birthDay == null){//如果生日为空
                        result.get(i).setAge("无");//显示年龄为 “无”
                    }else{//如果生日不为空
                        String substring = birthDay.substring(0, 4);
                        int birthDay1 = Integer.valueOf(substring);//把生日转换成int型
                        int age = nowyear1 - birthDay1;//当前年份减出生年份 算出年龄
                        String age1 = String.valueOf(age);//把算出的年龄转换成字符型
//                        System.out.println(age1+"*******************");
                        result.get(i).setAge(age1+"岁");//返回年龄是多少岁
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

}
