package com.tk.redis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.tk.redis.utils.JedisUtils;


public class TxMain {

	public static void main(String[] args) {
		writeRedis("age","89");
		readRedis("age");
	}
	
	
	/**
	 *  读操作
	 */
	public static void readRedis(String key) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		JedisUtils jedisUtils = (JedisUtils)ctx.getBean(JedisUtils.class);
		String value = jedisUtils.get(key);
		System.out.println("key="+key+",value="+value);
	}
	
	/**
	 *  写操作
	 */
	public static void writeRedis(String key,String value) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		JedisUtils jedisUtils = (JedisUtils)ctx.getBean(JedisUtils.class);
		String result = jedisUtils.set(key, value);
		System.out.println("result="+result);
	}
}
