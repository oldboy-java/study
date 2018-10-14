package com.tk.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/***
 * Redis主从配置
 * @author	刘力
 * @date	2018年10月10日下午1:38:06
 * @version 1.0
 */
@Configuration
@Component
public class RedisConfig {
	
	@Value("${redis.pool.maxIdle}")
	private Integer maxIdle;
	
	@Value("${redis.pool.maxTotal}")
	private Integer maxTotal;
	
	@Value("${redis.pool.maxWaitMillis}")
	private Long maxWaitMillis;
	
	@Value("${redis.master.host}")
	private String masterHost; 
	
	@Value("${redis.master.port}")
	private Integer masterPost ;
	
	@Value("${redis.slave.host}")
	private String slaveHost; 
	
	@Value("${redis.slave.port}")
	private Integer slavePost ;
	
	/**
	 * 实例化JedisPoolConfig
	 * @return
	 */
	@Bean(name="jedisPoolConfig")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxTotal(maxTotal);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		return jedisPoolConfig;
	}
	
	
	/**
	 * 实例化MasterJedisPool 
	 * @return
	 */
	@Bean("master")
	public JedisPool masterJedisPool() {
		JedisPool jedisPool = new JedisPool(jedisPoolConfig(),masterHost,masterPost);
		return jedisPool;
	}
	
	/**
	 * 实例化SlaveJedisPool 
	 * @return
	 */
	@Bean("slave")
	public JedisPool slaveJedisPool() {
		JedisPool jedisPool = new JedisPool(jedisPoolConfig(),slaveHost,slavePost);
		return jedisPool;
	}
}
