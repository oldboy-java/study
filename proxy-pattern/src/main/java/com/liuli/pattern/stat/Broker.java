package com.liuli.pattern.stat;

/**
 * 代理对象：经纪人
 * @author	刘力
 * @date	2017年9月8日下午6:01:05
 * @version 1.0
 */
public class Broker implements Girl {

	private Girl girl;
	
	public Broker(Girl girl) {
		this.girl = girl;
	}
	
	public boolean date(float height) {
		boolean result = false;
		doSomethingBefore();
		result = this.girl.date(height);
		doSomethingAfter();
		return result;
	}

	private void doSomethingAfter() {
		System.out.println("您约会后，感觉怎么样？");
	}

	private void doSomethingBefore() {
		System.out.println("小子成熟稳重，帅气迷人，强烈推荐！！");
	}

}
