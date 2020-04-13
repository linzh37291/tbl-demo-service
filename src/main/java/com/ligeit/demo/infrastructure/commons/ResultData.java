package com.ligeit.demo.infrastructure.commons;

import java.io.Serializable;
import lombok.Data;

@Data
public class ResultData<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	// 处理成功
	public static final String OK = "0000";
	public static final String OK_MSG = "操作成功";
	// 其他错误
	public static final String ERR = "9999";
	// 其他错误
	public static final String ERR_MSG = "操作失败";

	private static final ResultData SUCESS = new ResultData(OK, OK_MSG);

	private static final ResultData UNKNOWN_EXCEPTION = new ResultData(ERR, ERR_MSG);

	private String code = ERR;
	private String msg = "";
	private T data;

	public static ResultData getFailResult(){
		return new ResultData(ERR, ERR_MSG);
	}


	public static ResultData getFailResult(String message){

		return new ResultData(ERR, message);
	}

	public static ResultData getSuccessResult(String message){
		return new ResultData(OK, message);
	}

	public static ResultData getSuccessResult(){
		return ResultData.SUCESS;
	}

	/**
	 * 成功
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> ResultData getSuccessData(T data){
		return new ResultData(OK, OK_MSG, data);
	}

	/**
	 * 成功
	 * @param data
	 * @param message
	 * @return
	 */
	public static <T> ResultData getSuccessResult(T data, String message){
		return new ResultData(OK, message, data);
	}

	public ResultData(){
	}

	public ResultData(String code, String message){
		this.code = code;
		this.msg = message;
	}

	public ResultData(String code, String message, T result){
		this.code = code;
		this.msg = message;
		this.data = result;
	}

	public ResultData(T result){
		this(OK, "操作成功！", result);
	}

	/**
	 * 设置编码和消息
	 * @param serverCode
	 * @return
	 */
	public static ResultData setResultData(BizErrorCode bizErrorCode){
		return new ResultData(bizErrorCode.getCode(), bizErrorCode.getMsg());
	}


	/**
	 * 设置编码,信息和数据
	 * @param serverCode
	 * @return
	 */
	public static ResultData setResultData(BizErrorCode bizErrorCode, Object data){
		return new ResultData(bizErrorCode.getCode(), bizErrorCode.getMsg(), data);
	}


	public T getData(){
		return data;
	}

	public ResultData setData(T data){
		this.data = data;
		return this;
	}

}
