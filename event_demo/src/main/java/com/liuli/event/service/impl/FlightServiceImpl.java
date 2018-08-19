package com.liuli.event.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.liuli.event.event.FlightOrderEvent;
import com.liuli.event.mapper.TFlightMapper;
import com.liuli.event.pojo.Email;
import com.liuli.event.pojo.TFlight;
import com.liuli.event.pojo.TMsg;
import com.liuli.event.service.EmailService;
import com.liuli.event.service.FlightService;
import com.liuli.event.service.MsgService;

@Service
public class FlightServiceImpl implements FlightService,ApplicationContextAware {

	@Resource
	private TFlightMapper flightMapper;
	
	@Resource
	private EmailService emailService;
	
	@Resource
	private MsgService msgService;
	
	private ApplicationContext applicationContext;
	
	@Override
	public void orderFlight(int user,String flightCode) {
		//保存航班预订信息
		TFlight flight = new TFlight();
		flight.setFlightCode(flightCode);
		flight.setUser(user);
		flight.setOrderTime(new Date());
		flightMapper.insertSelective(flight);
		
		
		
	/*	*//**************以下非核心业务，其执行结果应该不能影响核心业务,此中情况如果短信和邮件服务网络有问题，将导致预订业务失败********//*
		//调用短信服务，发送短信
		TMsg msg = new TMsg();
		msg.setUser(1);
		msg.setPhone("18201019885");
		msg.setContent("您成功预订了航班，航班号"+flight.getFlightCode());
		msgService.addMsg(msg);
		
		
		//调用邮件服务，发送邮件
		Email email = new Email("携程旅行", "张三", "航班预订信息", "航班预订信息");
		emailService.sendEmail(email);*/
		
		
		//发布航班预订事件，还需配置异步处理，否则消息处理逻辑与当前预订航班是再同一个线程，在同一个事务中
		applicationContext.publishEvent(new FlightOrderEvent(flight));
		
		
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
