package com.liuli.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class A  implements BeanNameAware,BeanFactoryAware,ApplicationContextAware{
	
	private B b;
	
	public A() {
		System.out.println("A's constructor method is invoked");
	}
	

	public B getB() {
		return b;
	}


	public void setB(B b) {
		System.err.println("B is autowired by spring container");
		this.b = b;
	}


	public void init() {
		System.err.println("init method is invoked  in Class A");
	}

	public void destory() {
		System.err.println("destory method is invoked  in Class A");
	}
	
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("A is calling setApplicationContext method");
		
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("A is calling setBeanFactory method");
		
	}

	public void setBeanName(String name) {
		System.out.println("A is calling setBeanName method");
		
	}


}
