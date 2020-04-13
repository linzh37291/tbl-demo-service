package com.ligeit.demo.infrastructure.commons;

import lombok.Getter;


@Getter
public enum BizErrorCode {

    SUCCESS("0000","请求成功"),

    //========================================================================//
    //                              系统错误
    //========================================================================//
    UNKNOWN_EXCEPTION("9999","系统未知错误"),
    //                              请求校验
    //========================================================================//
    REQUEST_PARAM_ILLEGAL("0001","请求参数非法"),
    REQUEST_SIGNED_INVALID("0002","验签异常"),
    REQUEST_LOADING("0003","网络异常"),

	//========================================================================//
    //                              交易类错误1XXX
    //========================================================================//

    //========================================================================//
    //                              服务类错误2XXX
    //========================================================================//
    
    ;

    private final String code;

    private final String msg;

    private BizErrorCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    
    public static BizErrorCode getByCode(String code) {
        for (BizErrorCode status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }
}
