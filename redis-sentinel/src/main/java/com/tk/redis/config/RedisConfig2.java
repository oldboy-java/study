package com.tk.redis.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;


/***
 * 哨兵\JedisSentinelPool进行操作
 * @author	刘力
 * @date	2018年10月10日下午1:38:06
 * @version 1.0
 */
@Configuration
@Component
public class RedisConfig2 {
	
	@Value("${redis.pool.maxIdle}")
	private Integer maxIdle;
	
	@Value("${redis.pool.maxTotal}")
	private Integer maxTotal;
	
	@Value("${redis.pool.maxWaitMillis}")
	private Long maxWaitMillis;
	
	@Value("${redis.sentinel.master}")
	private String sentinelMaster; 
	
	@Value("${redis.sentinel.nodes}")
	private String sentinelNodes;
	
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
	 * 实例化JedisSentinelPool
	 * @return
	 */
	@Bean
	public JedisSentinelPool jedisSentinelPool() {
		//哨兵信息：这里需要注意哨兵端口和redis端口对外开放
		Set<String> sentinels = new HashSet<String>(Arrays.asList(sentinelNodes.split(",")));
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration(sentinelMaster,sentinels);
		JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(sentinelMaster, sentinels);
		return jedisSentinelPool;
	}
}
