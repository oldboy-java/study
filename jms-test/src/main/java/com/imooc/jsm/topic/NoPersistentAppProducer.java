package com.imooc.jsm.topic;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/***
 * 非持久化
 * @author	刘力
 * @date	2018年1月20日下午6:40:09
 * @version 1.0
 */
public class NoPersistentAppProducer {
	public static final String url = "tcp://127.0.0.1:61616";
	public static final String topicName = "topic-test";
	
	public static void main(String[] args) throws JMSException {
		
		// 1、创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		// 2、 创建连接
		Connection connection = connectionFactory.createConnection();
		
		// 3、启动连接
		connection.start();
		
		// 4、 创建 会话：此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
		Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
		
		// 5、创建目的地
		Destination destination = session.createTopic(topicName);
		
		// 6、创建生产者
		MessageProducer producer = session.createProducer(destination);
		
		
		for(int i = 0; i < 3;i++) {
			// 7、创建消息
			TextMessage message = session.createTextMessage("test" + i);
			
			// 8、发布消息
			producer.send(message);
			
			System.out.println("发送消息:" + message.getText());
		}
		
		//提交事务
		session.commit();
		
		// 10、关闭连接
		connection.close();
	}
}
