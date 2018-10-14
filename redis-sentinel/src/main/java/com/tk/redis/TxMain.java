package com.tk.redis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class TxMain {

	public static void main(String[] args) {
		
		demo2();
	}
	
	/**
	 *  RedisTemplate操作
	 */
	public static void demo1() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
		//向master中写值
		redisTemplate.opsForValue().set("things", "领带");
	}
	
	/**
	 *  JedisSentinelPool操作
	 */
	public static void demo2() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		JedisSentinelPool jedisSentinelPool = ctx.getBean(JedisSentinelPool.class);
		
		//向master中写值
		Jedis jedis = null;
		try {
			jedis = jedisSentinelPool.getResource();
			jedis.set("type", "goldlion");
		}finally {
			if(jedis!=null) {
				jedis.close();
			}
		}
	}
}
