package com.tk.rabbitmq.consumer;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.tk.rabbitmq.common.entity.Order;

@Service
public class OrderReceiver2 {

	
	/***
	 * 接收消息并进行手动签收
	 * @param order 消息
	 * @param headers 消息头
	 * @param channel 通道
	 * @throws Exception
	 */
	@RabbitListener(queues="order-queue")
	public void onOrderMessage(@Payload Order order,@Headers Map<String, Object> headers,Channel channel) throws Exception {
		System.err.println("当前channel:"+channel.getChannelNumber() +"-"+OrderReceiver2.class.getSimpleName());
		//消费者操作
		System.out.println("------------收到消息，开始消费----------------");
		System.out.println("订单ID："+order.getId());
		
		long deliveryTag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
		//进行消息签收确认
		channel.basicAck(deliveryTag, false); //multiple 批量签收
	}
}
