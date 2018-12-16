package com.itmayiedu.service;

//##lock 锁 定义分布式锁
public interface Lock {

	 //获取锁
	 public void getLock();
	 //釋放鎖
	 public void unLock();
}
