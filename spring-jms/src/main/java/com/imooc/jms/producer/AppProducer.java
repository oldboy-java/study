package com.imooc.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:producer.xml");
		
		ProducerService producerService = context.getBean(ProducerService.class);
		
		for(int i = 0 ;i < 100;i++) {
			producerService.sendMessage("message" + i);
		}
		
		//关闭上下文，会关闭MQ连接：由于Spring为我们创建的链接工厂会忽略连接的close方法
		context.close();
	}

}
