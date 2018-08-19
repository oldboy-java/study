package com.liuli.pattern.stat;


/**
 *  土豪
 * @author	刘力
 * @date	2017年9月8日下午6:09:04
 * @version 1.0
 */
public class Client {

	public static void main(String[] args) {
		
		Girl girl = new TeacherCang();
		Broker broker = new Broker(girl);
		broker.date(1.8f);
		
	}

}
