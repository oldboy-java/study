package com.liuli.event.event;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.liuli.event.pojo.TFlight;
import com.liuli.event.pojo.TMsg;
import com.liuli.event.service.MsgService;


/***
 * 
 * 航班预订事件短信处理
 * @date	2017年9月2日下午12:45:05
 * @version 1.0
 */
@Service
public class FlightOrderEventMsgHander implements ApplicationListener<FlightOrderEvent> {

	@Resource
	private MsgService msgService;
	
	@Override
	public void onApplicationEvent(FlightOrderEvent event) {
		TFlight flight = (TFlight) event.getSource();
		TMsg msg = new TMsg();
		msg.setUser(1);
		msg.setPhone("18201019885");
		msg.setContent("您成功预订了航班，航班号"+flight.getFlightCode());
		msgService.addMsg(msg);
		
	}

}
