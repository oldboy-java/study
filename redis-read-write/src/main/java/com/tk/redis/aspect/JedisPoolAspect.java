package com.tk.redis.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.tk.redis.DynamicJedisPoolHolder;
import com.tk.redis.annotation.JedisPoolType;

import redis.clients.jedis.JedisPool;

@Aspect
@Component
public class JedisPoolAspect implements ApplicationContextAware{
	
	private ApplicationContext cxt;
	
	/**
	 * 定义切点
	 */
	@Pointcut("execution(* com.tk.redis.utils.*.*(..))")
	public void pointcut() {
		
	}
	
	/***
	 * 设置前置通知
	 * @param joinPoint 连接点（拦截的方法）
	 */
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		//目标对象
		Object target = joinPoint.getTarget();
		Class<?> clz = target.getClass();
	
		//获取拦截方法签名
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		//拦截方法名
		String method = methodSignature.getName();
		//拦截方法参数
		Class<?>[]  parameterTypes = methodSignature.getParameterTypes();
		
		try {
			//反射方法
			Method m = clz.getMethod(method, parameterTypes);
			
			//获取方法注解
			if(m!=null && m.isAnnotationPresent(JedisPoolType.class)) {
				JedisPoolType jedisPoolType = m.getAnnotation(JedisPoolType.class);
				JedisPool jedisPool = (JedisPool) cxt.getBean(jedisPoolType.value());
				DynamicJedisPoolHolder.setJedisPool(jedisPool);
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.cxt = applicationContext;
	}
}
