package com.imooc.jsm.queue;


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

public class AppConsumer {
	//public static final String url = "failover:(tcp://localhost:61616,tcp://localhost:61617,tcp://localhost:61618)";
	
	public static final String url = "tcp://localhost:61616";
	
	public static final String queueName = "queue-test";
	
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
		Destination destination = session.createQueue(queueName);
		
		// 6、创建消费者
		MessageConsumer consumer = session.createConsumer(destination);
		
		// 7、创建一个监听器：监听是一个异步过程，一直阻塞
		consumer.setMessageListener(new MessageListener() {
			//执行onMessage时代表已接受到消息
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage)message;
				try {
					//处理消息
					System.out.println("读取到消息：" + textMessage.getText());
					
					// 8 事务环境下，提交事务进行消息消费确认
					session.commit();
					
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		
	
		
		// 这里不能关闭消息，如果关闭消息，可能第7步还未处理完，连接就关闭
		//connection.close();
	}
}
