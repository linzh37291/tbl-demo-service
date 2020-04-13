package com.ligeit.demo.facade.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ligeit.demo.infrastructure.commons.BusinessException;
import com.ligeit.demo.infrastructure.commons.ResultData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData exceptionHandler(Exception ex, HttpServletResponse response) throws  Exception{
    	ResultData rs = new ResultData();
        rs.setMsg("系统繁忙，请稍后再试！");
        if (ex instanceof BusinessException) {
            BusinessException be = (BusinessException) ex;
            rs.setCode(be.getCode());
            rs.setMsg(be.getMessage());
        }else if(ex instanceof ServletException){
            return ResultData.getFailResult();
        }else{
            log.error("系统异常：",ex);
        }
        return rs;
    }
}
