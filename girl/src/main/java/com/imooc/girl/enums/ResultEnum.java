package com.imooc.girl.enums;

/***
 * 
 * @author	刘力
 * @date	2017年10月15日下午2:26:41
 * @version 1.0
 */
public enum ResultEnum {
	SUCCESS(0, "成功"), UNKNOWN_ERROR(-1, "未知异常"), PRIMARY_SCHOOL(101, "你可能还在上小学"), MIDDLE_SCHOOL(102, "你可能还在上初中");
	
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
