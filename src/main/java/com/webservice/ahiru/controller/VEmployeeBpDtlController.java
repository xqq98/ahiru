package com.webservice.ahiru.controller;


import com.webservice.ahiru.entity.VEmployeeBpDtl;
import com.webservice.ahiru.mapper.VEmployeeBpDtlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vemployeebpdtl")
public class VEmployeeBpDtlController {

    @Autowired
    private VEmployeeBpDtlMapper vEmployeeBpDtlMapper;

    //查询所有
    @RequestMapping(value = "/getinfo",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object findall() {
        System.out.println("=============START=======");

        Object obj = getInfo();

        System.out.println("=============END=======");

        return obj;
    }

    //查询所有人员信息
    public List<VEmployeeBpDtl> getInfo() {
        List<VEmployeeBpDtl> result = new ArrayList<VEmployeeBpDtl>();
        result = vEmployeeBpDtlMapper.getInfo();

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
            System.out.println(first+"-"+i+""+result.get(i).getScheduledExitDt());
            if(first == '9'){
                //将数据中离职时间信息转换成时间戳
                if(result.get(i).getScheduledExitDt() != null && result.get(i).getScheduledExitDt() !=""){
                    String timeStamp = date2TimeStamp(result.get(i).getScheduledExitDt(), "yyyy-MM-dd HH:mm:ss");
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
                if(result.get(i).getPlanLeavingDate() != null){
                    result.get(i).setColor("gray");
                }
                else{
                    result.get(i).setColor("white");
                }
            }
        }
        return result;
    }
    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //查询条件
    @RequestMapping(value = "/getby",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object findPmORManager(@RequestBody VEmployeeBpDtl vEmployeeBpDtl){
        System.out.println("=============START=======");

        Object obj = getby(vEmployeeBpDtl);

        System.out.println("=============END=======");

        return obj;
    }
    //通过pm和department查询
    public List<VEmployeeBpDtl> getby(VEmployeeBpDtl vEmployeeBpDtl) {
        List<VEmployeeBpDtl> resultby = new ArrayList<VEmployeeBpDtl>();
        resultby = vEmployeeBpDtlMapper.getby(vEmployeeBpDtl);
        return resultby;
    }

    //按月查询

    @RequestMapping(value = "/getmonth/{month}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object findmonth(@PathVariable(value = "month") String month){
        System.out.println("=============START=======");

        Object obj = getmonth (month);

        System.out.println("=============END=======");

        return obj;
    }
    public List<VEmployeeBpDtl> getmonth(String month) {
        List<VEmployeeBpDtl> resultmonth = vEmployeeBpDtlMapper.getmonth(month);
        System.out.println(resultmonth.size());
        return resultmonth;

    }
    //查询空闲
    @RequestMapping(value = "/getidle",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object findidle(){
        System.out.println("=============START=======");

        Object obj = getidle();

        System.out.println("=============END=======");

        return obj;
    }
    //通过时间判断查询空闲人员信息
    public List<VEmployeeBpDtl> getidle() {
        long nowTime = System.currentTimeMillis();
        System.out.println("");
        List<VEmployeeBpDtl> resultidle = new ArrayList<VEmployeeBpDtl>();
        List<VEmployeeBpDtl> result = new ArrayList<VEmployeeBpDtl>();
        resultidle = vEmployeeBpDtlMapper.getidle();
        for (int i = 0; i < resultidle.size(); i++) {

        }
        return result;
    }
}
