package com.tk.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages= {"com.tk.redis"})
@PropertySource(value= {"classpath:redis.properties"})  //@PropertySource引入属性文件 ,@ImportResource引入xml文件
@EnableAspectJAutoProxy(proxyTargetClass=true)//启用切面自动代理且使用CGLIB代理
public class AppConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
