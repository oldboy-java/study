package com.qtrmoon.common;

/***
 * 请求体ContentType类型
 */
public enum RequestBobyContentType {
	//JSON格式
	json("application/json"),
	
	//含文件
	multipart("multipart/form-data"),
	
	//普通表单
	form("application/x-www-form-urlencoded");
	
	String contentType;

	private RequestBobyContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
