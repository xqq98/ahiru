package com.webservice.ahiru.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {

    public static String getLoginUser(){
        String USERNAME = "USERNAME";

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String username = request.getHeader(USERNAME);
        return username;
    }

    public static String getOpenID(){
        String WECHARTID = "OPENID";
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String openId = request.getHeader(WECHARTID);
        return openId;
    }
}
