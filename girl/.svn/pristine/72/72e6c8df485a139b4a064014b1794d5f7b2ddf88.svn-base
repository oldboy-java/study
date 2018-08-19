package com.imooc.girl.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



/**
 * 定义拦截控制器方法的切面，记录请求日志
 * @author	刘力
 * @date	2018年4月6日下午7:11:37
 * @version 1.0
 */
@Component
@Aspect
public class HttpAspect {

	private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	private ThreadLocal<Long> inTime = new ThreadLocal<Long>();
	
	
	@Pointcut("execution(public * com.imooc.girl.controller..*.*(..))")
	public void log() {
		
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		  inTime.set(System.currentTimeMillis());
		  ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		  HttpServletRequest request = requestAttributes.getRequest(); 
		  
		  //url
		  logger.info("url={}",request.getRequestURL());
		  
		  //method
		  logger.info("method={}", request.getMethod());
		  
		  //ip
		  logger.info("ip={}", request.getRemoteAddr());
		  
		  //类名-方法名
		  logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
	
		  //参数
		  logger.info("args={}", joinPoint.getArgs());
		  
	}
	
	@After("log()")
	public void doAfter(JoinPoint joinPoint) {
		long endTime = System.currentTimeMillis();
		logger.info("execute method {} costs {} millisecond", joinPoint.getSignature().getName(),endTime-inTime.get());
	}
	
	//这里的Object是定义请求方法的返回值类型，其中returning的值等于参数obj
	@AfterReturning(pointcut="log()",returning="obj")
	public void doAfterReturning(Object obj) {
		logger.info("response={}", obj.toString());
	}
}
