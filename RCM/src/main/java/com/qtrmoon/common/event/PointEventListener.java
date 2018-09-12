package com.qtrmoon.common.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Yhkzxx;
import com.qtrmoon.zygl.serdao.IZyglService;

/***
 * 积分事件监听
 */
@Component
public class PointEventListener implements ApplicationListener<PointEvent> {

	@Autowired
	private IZyglService zyglService;
	
	@Override
	@Async
	public void onApplicationEvent(PointEvent event) {
		Yhkzxx yhkzxx = (Yhkzxx) event.getSource();
		zyglService.updYhjf(yhkzxx);
	}

}
