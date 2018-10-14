package com.tk.redis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TxMain {

	public static void main(String[] args) {
		
		demo1();
	}
	
	/**
	 * 事务中命令格式和数据类型都正常，事务全部提交
	 */
	public static void demo1() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
		
		String channel = "topic.channel2";
		redisTemplate.convertAndSend(channel, "普通频道消息");
	}
}
