package com.imooc.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定义Service切面，模拟事务处理
 * @author	刘力
 * @date	2018年4月6日下午7:12:32
 * @version 1.0
 */
@Component
@Aspect
public class ServiceAspect {

	private static final Logger logger = LoggerFactory.getLogger(ServiceAspect.class);
	
	@Pointcut("execution(public * com.imooc.girl.service.*.*(..))\" ")
	public void transaction() {
		
	}
	
	@Before("transaction()")
	public void doBefore(JoinPoint joinPoint) {
		  logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		logger.info("开始事务");
	}
	
	@After("transaction()")
	public void doAfter() {
		logger.info("提交事务或者回滚事务");
	}
}
