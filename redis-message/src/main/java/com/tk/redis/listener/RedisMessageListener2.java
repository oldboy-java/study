package com.tk.redis.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 配置消息监听器（消息接收者）
 * @author	刘力
 * @date	2018年10月8日下午5:58:36
 * @version 1.0
 */
@Component("redisMessageListener2")
public class RedisMessageListener2 implements MessageListener {

	@Autowired
	private RedisTemplate redisTemplate;
	
	public void onMessage(Message message, byte[] pattern) {
		//获取消息
		byte[] body = message.getBody();
		
		//获取channel
		byte[] channel = message.getChannel();
		
		//使用值序列化器转换
		String msg = (String)redisTemplate.getValueSerializer().deserialize(body);
		
		//使用字符串序列化器转换
		String channelStr = (String)redisTemplate.getStringSerializer().deserialize(channel);
		
		System.err.println("我是RedisMessageListener2，监听"+channelStr+",收到消息："+msg);
	}

}
