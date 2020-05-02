package com.webservice.ahiru.controller;

import com.webservice.ahiru.entity.VEmpList;
import com.webservice.ahiru.mapper.VEmpListMapper;
import com.webservice.ahiru.service.VEmpListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuxianlong
 * @since 2020-01-13
 */

//进行标记这是一个Controller
@RestController
//控制器处理所有“/vemplist”的URL请求
@RequestMapping("/vemplist")
public class VEmpListController {

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(VEmpListController.class);

    //Service接口的实现类
    @Autowired
    private VEmpListService VEmpListService;

    //Service接口的实现类
    @Autowired
    private VEmpListMapper VEmpListMapper;

    /**
     *
     * @Target(ElementType.METHOD) intf
     * @Target(ElementType.PARAMETER) @RequestBody VEmpList VEmpList
     * 表的数据放到obj对象中，返回对象obj
     *
     * @author wanghao
     * @since 2020-2-18
     */
    //控制器处理“/api”的URL请求，POST请求
    @RequestMapping(value = "/api",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object intf(@RequestBody VEmpList VEmpList){
        System.out.println("=============START=======");

        Object obj = VEmpListService.getInfo(VEmpList);

        System.out.println("=============END=======");

        return obj;
    }

    //测试该方法是否通畅
    @RequestMapping("/test2")
    public Object test(){
        return "TEST2 ok!!!";
    }

    /**
     *
     * @Target(ElementType.METHOD) getInfo
     * @Target(ElementType.PARAMETER) VEmpList VEmpList
     * 查询视图（V_EMP_LIST）的数据以列表的形式输出，调用VEmpListMapper的getInfo方法，返回对象result
     *
     *
     * @author wanghao
     * @since 2020-2-18
     */

//    public List<VEmpList> getInfo(VEmpList VEmpList) {
//
//        System.out.println("===============code:"+VEmpList.getId() +"=================");
//
//        List<VEmpList> result = new ArrayList<VEmpList>();
//
//        if(VEmpList != null){
//            result = VEmpListMapper.getInfo(VEmpList);
//
//            //获取当前时间戳
//            long nowDate = System.currentTimeMillis();
//            //两个月60天的毫秒数
//            String twomonth = "5184000000";
//
//            //将两个月的毫秒数转换成long
//            long month = Long.parseLong(twomonth);
//
//            //将当前时间+60天
//            long nowAddtwomonth = nowDate + month;
//            System.out.println("nowAddtwomonth="+nowAddtwomonth);
//            for(int i=0;i<result.size();i++){
//                char first=result.get(i).getId().charAt(0);
//                System.out.println(first+"-"+i+""+result.get(i).getOutDate());
//                if(first == '9'){
//                    //将数据中离职时间信息转换成时间戳
//                    if(result.get(i).getOutDate() != null && result.get(i).getOutDate() !=""){
//                        String timeStamp = date2TimeStamp(result.get(i).getOutDate(), "yyyy-MM-dd");
//                        long personalleveltime = Long.parseLong(timeStamp);
//                        if(nowAddtwomonth >= personalleveltime){
//                            result.get(i).setColor("yellow");
//                        }else {
//                            result.get(i).setColor("white");
//                        }
//                    }
//                    else{
//                        result.get(i).setColor("white");
//                    }
//                }else {
//                    if(result.get(i).getOutDate() != null){
//                        result.get(i).setColor("gray");
//                    }
//                    else{
//                        result.get(i).setColor("white");
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    public static String date2TimeStamp(String date_str,String format){
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(format);
//            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//            return String.valueOf(sdf.parse(date_str).getTime());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

}

