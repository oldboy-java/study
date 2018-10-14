package com.tk.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@Component
public class RedisConfig {
	
	@Value("${redis.host}")
	private String host;
	
	@Value("${redis.port}")
	private Integer port;
	
	@Value("${redis.pool.maxIdle}")
	private Integer maxIdle;
	
	@Value("${redis.pool.maxTotal}")
	private Integer maxTotal;
	
	@Value("${redis.pool.maxWaitMillis}")
	private Long maxWaitMillis;
	
	
	@Bean(name="jedisPoolConfig")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxTotal(maxTotal);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		return jedisPoolConfig;
	}
	
	@Bean(name="jedisConnectionFactory")
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(host);
		jedisConnectionFactory.setPort(port);
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
		jedisConnectionFactory.afterPropertiesSet();
		return jedisConnectionFactory;
	}
	
	@Bean(name="stringRedisSerializer")
	public StringRedisSerializer stringRedisSerializer() {
		return new StringRedisSerializer();
	}
	
	@Bean(name="jdkSerializationRedisSerializer")
	public JdkSerializationRedisSerializer jdkSerializationRedisSerializer() {
		return new JdkSerializationRedisSerializer();
	}
	
	@Bean(name="redisTemplate")
	public RedisTemplate redisTemplate() {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setStringSerializer(stringRedisSerializer());
		redisTemplate.setValueSerializer(stringRedisSerializer());
		redisTemplate.setDefaultSerializer(stringRedisSerializer());
		return redisTemplate;
	}
}
