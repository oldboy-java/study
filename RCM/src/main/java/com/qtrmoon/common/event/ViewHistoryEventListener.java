package com.qtrmoon.common.event;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Zyll;
import com.qtrmoon.zygl.serdao.IZyglService;

/***
 * 浏览资源记录监听
 */
@Component
public class ViewHistoryEventListener implements ApplicationListener<ViewHistoryEvent> {

	@Autowired
	private IZyglService zyglService;
	
	@Override
	@Async
	public void onApplicationEvent(ViewHistoryEvent event) {
		Zyll zyll = (Zyll)event.getSource();
		List<Zyll> zyllList = zyglService.schZyll(zyll);
		if(zyllList != null && zyllList.size()>0){
			zyll.setId(zyllList.get(0).getId());
			zyll.setLlsj(new Date());
			zyglService.updZyll(zyll);
		}else {
			zyglService.addZyll(zyll);
		}
	}

}
