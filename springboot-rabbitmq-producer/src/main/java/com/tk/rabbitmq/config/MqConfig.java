package com.tk.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MqConfig {

	private static final String  ORDER_QUEUE = "order-queue";
	private static final String ORDER_EXCHANGE = "order-exchange";
	private static final String ORDER_ROUTINGKEY = "order.*"; // * 表示0个或1个 ， # 0个或多个
	
	@Bean
	public Queue topicQueue() {
		return new Queue(ORDER_QUEUE, true);
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(ORDER_EXCHANGE);
	}
	
	@Bean
	public Binding  topicBinding() {
		return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(ORDER_ROUTINGKEY);
	}
}
