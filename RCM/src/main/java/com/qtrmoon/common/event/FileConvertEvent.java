package com.qtrmoon.common.event;

import org.springframework.context.ApplicationEvent;

import com.qtrmoon.zygl.pojo.Zy;

/***
 * 定义文件转换事件
 */
public class FileConvertEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	
	public FileConvertEvent(final Zy zy){
		super(zy);
	}

}
