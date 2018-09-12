package com.qtrmoon.common.event;

import org.springframework.context.ApplicationEvent;

import com.qtrmoon.zygl.pojo.Zyxz;

/***
 * 定义资源下载记录事件
 *
 */
public class DownloadHistoryEvent extends ApplicationEvent {

	public DownloadHistoryEvent(Zyxz zyxz) {
		super(zyxz);
	}
}
