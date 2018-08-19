package com.liuli.event.event;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.liuli.event.pojo.Email;
import com.liuli.event.pojo.TFlight;
import com.liuli.event.service.EmailService;


/***
 * 
 * 航班预订事件邮件处理
 * @date	2017年9月2日下午12:45:05
 * @version 1.0
 */
@Service
public class FlightOrderEventEmailHander implements ApplicationListener<FlightOrderEvent> {

	@Resource
	private EmailService emailService;
	
	@Override
	public void onApplicationEvent(FlightOrderEvent event) {
		TFlight flight = (TFlight) event.getSource();
		//调用邮件服务，发送邮件
		Email email = new Email("携程旅行", "张三", "航班预订信息", "您成功预订了航班，航班号："+flight.getFlightCode());
		emailService.sendEmail(email);
		
	}

}
