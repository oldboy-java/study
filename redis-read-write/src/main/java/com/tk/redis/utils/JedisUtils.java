package com.tk.redis.utils;

import org.springframework.stereotype.Component;

import com.tk.redis.DynamicJedisPoolHolder;
import com.tk.redis.annotation.JedisPoolType;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Slf4j
@Component
public class JedisUtils {

	/**
	 * 设置单个key
	 * @param key
	 * @param value
	 * @return 返回执行结果
	 */
	@JedisPoolType("master")
	public  String set(String key,String value) {
		JedisPool jedisPool = DynamicJedisPoolHolder.getJedisPool();
		Jedis jedis = null;
		String result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.set(key, value);
		}catch (Exception e) {
			e.printStackTrace();
			log.error("set key={},value={} failed:{}",key,value,e);
		}finally {
			if(jedis!=null) {
				jedis.close();
			}
		}
		return result;
	}
	
	/**
	 * 获取单个key值
	 * @param key
	 * @return
	 */
	@JedisPoolType("slave")
	public  String get(String key) {
		JedisPool jedisPool = DynamicJedisPoolHolder.getJedisPool();
		Jedis jedis = null;
		String result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.get(key);
		}catch (Exception e) {
			e.printStackTrace();
			log.error("set key={} failed:{}",key,e);
		}finally {
			if(jedis!=null) {
				jedis.close();
			}
		}
		return result;
	}
}
