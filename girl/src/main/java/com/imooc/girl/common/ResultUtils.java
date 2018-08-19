package com.imooc.girl.common;

import com.imooc.girl.enums.ResultEnum;

public class ResultUtils {

	public static Result<Object> success(Object data) {
		Result<Object> result = new Result<Object>();
		result.setCode(ResultEnum.SUCCESS.getCode());
		result.setMsg(ResultEnum.SUCCESS.getMessage());
		result.setData(data);
		return result;
	}
	
	public static Result<Object> success() {
		return success(null);
	}
	
	public static Result<Object> error(Integer code,String message) {
		Result<Object> result = new Result<Object>();
		result.setCode(code);
		result.setMsg(message);
		return result;
	}
}
