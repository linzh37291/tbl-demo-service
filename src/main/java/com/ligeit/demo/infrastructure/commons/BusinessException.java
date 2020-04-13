package com.ligeit.demo.infrastructure.commons;

import lombok.Data;

/**
 * 业务异常
 */
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String code = ResultData.ERR;

    /**
     * 异常类型，用于区分打印日志级别,默认为warn
     */
    ExceptionTypeEnum type = ExceptionTypeEnum.WARN;


    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code, String message,Throwable t) {
        super(message,t);
        this.code = code;
    }

    public BusinessException(BizErrorCode bizErrorCode) {
        super(bizErrorCode.getMsg());
        this.code = bizErrorCode.getCode();
    }

    public BusinessException(String message,ExceptionTypeEnum type) {
        super(message);
        this.type=type;
    }

    public BusinessException(String code, String message,ExceptionTypeEnum type) {
        super(message);
        this.code = code;
        this.type=type;
    }

    public BusinessException(String code, String message,Throwable t,ExceptionTypeEnum type) {
        super(message,t);
        this.code = code;
        this.type=type;
    }

    public BusinessException(BizErrorCode bizErrorCode,ExceptionTypeEnum type) {
        super(bizErrorCode.getMsg());
        this.code = bizErrorCode.getCode();
        this.type=type;
    }


    public static enum ExceptionTypeEnum{
        ERROR,
        WARN
    }
}
