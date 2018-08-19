package com.imooc.jsm.queue;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AppProducer {
	//public static final String url = "failover:(tcp://localhost:61617,tcp://localhost:61618)";
	
	public static final String url = "tcp://localhost:61616";
	
	public static final String queueName = "queue-test";
	
	public static void main(String[] args) throws JMSException {
		
		// 1、创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		// 2、 创建连接
		Connection connection = connectionFactory.createConnection();
		
		// 3、启动连接
		connection.start();
		
		// 4、 创建 会话：此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式。事务可以保证消息发送的原子性
		Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
		
		// 5、创建目的地
		Destination destination = session.createQueue(queueName);
		
		// 6、创建生产者
		MessageProducer producer = session.createProducer(destination);
		
		
		for(int i = 0; i < 100;i++) {
			// 7、创建消息
			TextMessage message = session.createTextMessage("test" + i);
			
			// 8、发布消息
			producer.send(message);
			
			System.out.println("发送消息:" + message.getText());
		}
		
		// 9、提交事务（session在事务环境中，需求提交事务，才能发送消息到队列；非事务环境无需提交事务，提交事务则报错Not a transacted session）
		session.commit();
		
		// 10、关闭连接
		connection.close();
	}
}
