package com.webservice.ahiru.handler;

import com.webservice.ahiru.exception.AhiruException;
import com.webservice.ahiru.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value= AhiruException.class)
    @ResponseBody
    private Result exceptionHandler(HttpServletRequest req, Exception e){

        Result result = Result.error(e.getMessage());
        return result;
    }
}
