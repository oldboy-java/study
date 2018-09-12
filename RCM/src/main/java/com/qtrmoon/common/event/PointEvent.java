package com.qtrmoon.common.event;

import org.springframework.context.ApplicationEvent;

import com.qtrmoon.zygl.pojo.Yhkzxx;

/***
 * 积分处理事件
 */
public class PointEvent extends ApplicationEvent {

	public PointEvent(Yhkzxx yhkzxx) {
		super(yhkzxx);
	}

}
