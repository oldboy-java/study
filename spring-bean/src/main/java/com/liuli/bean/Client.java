package com.liuli.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		
		//获取A对象实例
		//A a = context.getBean(A.class);
		
		context.close();
	}

}
