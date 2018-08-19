package com.liuli.pattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.liuli.pattern.ProxyUtils;
import com.liuli.pattern.stat.Girl;
import com.liuli.pattern.stat.TeacherCang;

public class Client {

	public static void main(String[] args) {
		Boy teacherJia = new TeacherJia();
		InvocationHandler handler = new InvocationHandlerImpl(teacherJia);
		Boy proxy = (Boy) Proxy.newProxyInstance(teacherJia.getClass().getClassLoader(), teacherJia.getClass().getInterfaces(), handler);
		proxy.date('B');
		
		
		System.out.println("*******************************************");
		Girl teacherCang = new TeacherCang();
		handler = new InvocationHandlerImpl(teacherCang);
		Girl proxy2 = (Girl) Proxy.newProxyInstance(teacherCang.getClass().getClassLoader(), teacherCang.getClass().getInterfaces(), handler);
		proxy2.date(2.4f);
		
		ProxyUtils.generateClassFile(teacherJia.getClass(), "Boy","d:/");
	}
}
