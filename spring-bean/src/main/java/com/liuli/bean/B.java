package com.liuli.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class B  implements BeanNameAware,BeanFactoryAware,ApplicationContextAware{
	
	private String name;
	
	public B() {
		System.out.println("B's constructor method is invoked");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("B is calling setApplicationContext method");
		
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("B is calling setBeanFactory method");
		
	}

	public void setBeanName(String name) {
		System.out.println("B is calling setBeanName method");
		
	}
}
