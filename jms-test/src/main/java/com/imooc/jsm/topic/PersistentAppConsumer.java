package com.imooc.jsm.topic;


import java.util.UUID;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class PersistentAppConsumer {
	public static final String url = "tcp://127.0.0.1:61616";
	public static final String topicName = "topic-persistent";
	
	public static void main(String[] args) throws JMSException {
		
		// 1、创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		// 2、 创建连接
		Connection connection = connectionFactory.createConnection();
		
		// 3、向JMS服务中注册消费者身份Id
		connection.setClientID("00755952-c181-437c-b6ea-079dab93b221");
		
		// 4、 创建 会话：此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
		final Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
		
		// 5、创建目的地
		Topic topic = session.createTopic(topicName);
		
		// 6、创建持久化订阅者
	    TopicSubscriber consumer = session.createDurableSubscriber(topic, "t2");
		
		
		// 7、启动连接
		 connection.start();
		
		// 8、创建一个监听器：监听是一个异步过程，一直阻塞,等待消息到来
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage)message;
				try {
					System.out.println("读取到消息：" + textMessage.getText());
					
					//事务环境下提交事务进行消费消息确认
					session.commit();
					
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		
		// 这里不能关闭消息，如果关闭消息，可能第8步还未处理完，连接就关闭
		//connection.close();
	}
}
