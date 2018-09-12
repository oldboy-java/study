package com.qtrmoon.common;

/**
 * 响应结果枚举
 */
public enum ResultEnum {
	SUCCESS(1,"操作成功"),FAILURE(0,"操作失败"),LOGIN_ERROR(1001,"错误的用户名或密码"), OLD_PWD_ERROR(1002,"原密码错误");
	
	private Integer code;
	private String message;
	
	private ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
