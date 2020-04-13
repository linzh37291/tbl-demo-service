package com.ligeit.demo.facade.handle;


import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.ligeit.demo.infrastructure.commons.BizErrorCode;
import com.ligeit.demo.infrastructure.commons.BusinessException;

import java.util.List;


@Slf4j
@Aspect
@Component
public class ParamValidateAspect {

    @Pointcut("execution(* com.ligeit.supply.rules..*(..))")
    public void aspect(){	}

    /*
	 * 配置前置通知,使用在方法aspect()上注册的切入点
	 * 同时接受JoinPoint切入点对象,可以没有该参数
	 */
    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        Object[] params = joinPoint.getArgs();
        for(Object param:params){
            if(param instanceof Errors){
                Errors errors = (Errors)param;
                if (errors.hasErrors()) {
                    List<ObjectError> errorList = errors.getAllErrors();
                    StringBuilder sb = new StringBuilder();
                    FieldError fieldError = (FieldError) errorList.get(0);
                    sb.append(fieldError.getDefaultMessage());
                    log.warn("======参数校验异常======"+sb.toString().trim());
                    throw new BusinessException(BizErrorCode.REQUEST_PARAM_ILLEGAL);
                }
            }
        }
    }
}
