package com.sky.sell.vo;

import lombok.Data;

/***
 * Http请求响应最外层对象
 * @author	刘力
 * @date	2017年12月2日下午7:33:11
 * @version 1.0
 */
@Data
public class ResultVO<T> {

	/** 状态码 **/
	private Integer code;
	/** 提示消息 **/
	private String msg ;
	
	/** 返回内容 **/
	private T data;
	
}
