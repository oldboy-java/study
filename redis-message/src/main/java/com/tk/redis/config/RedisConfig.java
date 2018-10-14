package com.tk.redis.config;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import com.tk.redis.listener.RedisMessageListener;

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
	
	@Resource
	private RedisMessageListener redisMessageListener;
	
	@Resource
	private RedisMessageListener redisMessageListener2;
	
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
	
	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer() {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		
		//设置ConnectionFactory
		container.setConnectionFactory(jedisConnectionFactory());
		
		//模式订阅，支持模式匹配订阅，*为模糊匹配符
		Topic patternTopic = new PatternTopic("topic.*");

		//模式订阅,匹配所有频道
		Topic patternTopic2 = new PatternTopic("*");
				
		//普通订阅，订阅具体的频道 
		Topic channelTopic = new ChannelTopic("topic.channel");
		
		Collection<Topic> topics = new ArrayList<Topic>();
		topics.add(patternTopic);
		topics.add(patternTopic2);
		topics.add(channelTopic);
		
		Topic channelTopic2 = new ChannelTopic("topic.channel2");
		
		//设置线程池
		container.setTaskExecutor(taskExecutor());
		
		//设置监听者
		//container.addMessageListener(redisMessageListener,topics);
		container.addMessageListener(redisMessageListener2, channelTopic2);
		
		
		return container;
	}
	
	/**
	 * 配置线程池
	 * @return
	 */
	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(3);
		return taskScheduler;
	}
}
