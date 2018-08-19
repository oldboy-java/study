package com.imooc.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage)message;
		
		try {
			System.out.println("接受到消息：" + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
