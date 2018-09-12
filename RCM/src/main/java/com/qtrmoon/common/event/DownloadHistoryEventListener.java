package com.qtrmoon.common.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Zyxz;
import com.qtrmoon.zygl.serdao.IZyglService;

/**
 * 下载事件监听
 */
@Component
public class DownloadHistoryEventListener implements ApplicationListener<DownloadHistoryEvent> {

	@Autowired
	private IZyglService zyglService;
	
	@Override
	@Async
	public void onApplicationEvent(DownloadHistoryEvent event) {
		Zyxz zyxz = (Zyxz)event.getSource();
		zyglService.addZyxz(zyxz);
	}

}
