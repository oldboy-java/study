package com.imooc.jsm.topic;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class NoPersistentAppConsumer {
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
		final Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
		
		// 5、创建目的地
		Destination destination = session.createTopic(topicName);
		
		// 6、创建消费者
		MessageConsumer consumer = session.createConsumer(destination);
		
		// 7、创建一个监听器：监听是一个异步过程，一直阻塞,等待消息到来
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage)message;
				try {
					System.out.println("读取到消息：" + textMessage.getText());
					
					//session.commit();
					
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		// 这里不能关闭消息，如果关闭消息，可能第7步还未处理完，连接就关闭
		//connection.close();
	}
}
