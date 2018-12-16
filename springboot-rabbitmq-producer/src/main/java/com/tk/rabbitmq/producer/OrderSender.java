package com.tk.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tk.rabbitmq.common.entity.Order;

@Component
public class OrderSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/**
	 * 发送消息
	 * @param order
	 */
	public void send(Order order) {
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(order.getMessageId());
		rabbitTemplate.convertAndSend("order-exchange",  //指定交换机
									"order.abcd",  //指定routingKey
									order,//消息体内容
									correlationData); //消息唯一ID
				 
	}
}
