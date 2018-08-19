package com.imooc.girl.exception;


/**
 * 自定义异常
 * @author	刘力
 * @date	2017年10月15日下午2:07:42
 * @version 1.0
 */
public class GirlException extends RuntimeException {

	private Integer code;

	public GirlException(Integer code,String message) {
		super(message);
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
