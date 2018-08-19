package com.liuli.pattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/***
 * 定义调用处理器实现
 * @author	刘力
 * @date	2017年9月9日上午9:22:59
 * @version 1.0
 */
public class InvocationHandlerImpl implements InvocationHandler {

	private Object obj;
	
	public InvocationHandlerImpl(Object obj) {
		super();
		this.obj = obj;
	}

	public InvocationHandlerImpl() {
		super();
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		doSomethingBefore();
		result = method.invoke(obj, args);
		doSomethingAfter();
		return result;
	}
	
	
	private void doSomethingAfter() {
		System.out.println("您约会后，感觉怎么样？");
	}

	private void doSomethingBefore() {
		System.out.println("已经试过了，确实不错，强烈推荐！！");
	}

}
