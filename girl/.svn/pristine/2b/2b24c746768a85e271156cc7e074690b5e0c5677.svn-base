package com.imooc.girl.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.girl.common.Result;
import com.imooc.girl.common.ResultUtils;
import com.imooc.girl.enums.ResultEnum;
import com.imooc.girl.exception.GirlException;

@ControllerAdvice
public class ExceptionHandle {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result<Object> handle(Exception e){
		if(e instanceof GirlException) {
			GirlException girlException = (GirlException) e;
			logger.error("出现错误，错误码={},错误消息={}", girlException.getCode(), girlException.getMessage());
			return ResultUtils.error(girlException.getCode(), girlException.getMessage());
		}else {
			logger.error("出现错误，错误码={},错误消息={}", ResultEnum.UNKNOWN_ERROR.getCode(), e.getMessage());
			return ResultUtils.error(ResultEnum.UNKNOWN_ERROR.getCode(), e.getMessage());
		}
	}
}
