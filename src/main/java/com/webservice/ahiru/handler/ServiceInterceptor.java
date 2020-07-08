package com.webservice.ahiru.handler;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.webservice.ahiru.common.RedisUtil;
import com.webservice.ahiru.common.UserUtil;
import com.webservice.ahiru.controller.EmployeeWorkController;
import com.webservice.ahiru.entity.MEmpDtl;
import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.UserService;
import io.lettuce.core.RedisCommandTimeoutException;
import io.lettuce.core.RedisException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;

@Component
public class ServiceInterceptor implements HandlerInterceptor {

    private String USERNAME = "USERNAME";
    private String WECHARTID = "OPENID";
    private long EXPIRE_TEIM = 60;

    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("开始拦截........." + request.getRequestURL());
        //System.out.println("aaa==="+redisUtil.get("aaa"));
        String loginUser = request.getHeader(USERNAME);
        String openid = request.getHeader(WECHARTID);
        PrintWriter writer=null;
        try {
            if (loginUser == null || loginUser.equals("")) {
                throw new Exception("无权限访问资源");
            }

            if (openid == null || openid.equals("")) {
                throw new Exception("无权限访问资源");
            }
            String resOpenid =null;
            try {
                resOpenid = (String) redisUtil.get(loginUser);
            }catch (RedisException ex){
                resOpenid =null;
                logger.error("Redis error", ex);
            }catch (RedisConnectionFailureException cex){
                resOpenid =null;
                logger.error("Redis error", cex);
            }
            if (StringUtils.isEmpty(resOpenid)){
                MEmpDtl emp = userService.getUserInfo(loginUser);
                if (emp != null && openid.equals(emp.getWeChatId())) {
                    try {
                        redisUtil.set(loginUser,openid,EXPIRE_TEIM);
                    }catch (RedisException ex){
                        logger.error("Redis error", ex);
                    }catch (RedisConnectionFailureException cex){
                        logger.error("Redis error", cex);
                    }
                    return true;
                } else {
                    throw new Exception("无权限访问资源");

                }
            }else if (openid.equals(resOpenid)){
                return true;
            }else{
                throw new Exception("无权限访问资源");
            }
        } catch (Exception ex) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            writer = response.getWriter();

            Result result = Result.error(ex.getMessage());
            String strResult = JSONObject.toJSONString(result);
            writer.print(strResult);
            writer.flush();
            logger.error("response error", ex);
            return false;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}

