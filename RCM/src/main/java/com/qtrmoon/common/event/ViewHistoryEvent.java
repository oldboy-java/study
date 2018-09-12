package com.qtrmoon.common.event;

import org.springframework.context.ApplicationEvent;

import com.qtrmoon.zygl.pojo.Zyll;

/***
 * 定义资源浏览记录事件
 *
 */
public class ViewHistoryEvent extends ApplicationEvent {

	public ViewHistoryEvent(Zyll zyll) {
		super(zyll);
	}
}
