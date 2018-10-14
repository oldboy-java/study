package com.tk.redis;

import redis.clients.jedis.JedisPool;

/***
 * 动态处理JedisPool
 * @author	刘力
 * @date	2018年10月12日上午9:10:33
 * @version 1.0
 */
public class DynamicJedisPoolHolder {

	private static ThreadLocal<JedisPool> holder = new ThreadLocal<JedisPool>(); 
	
	public static void setJedisPool(JedisPool jedisPool) {
		holder.set(jedisPool);
	}
	
	public static JedisPool getJedisPool() {
		return holder.get();
	}
}
