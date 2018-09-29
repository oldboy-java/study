package lambda;


import java.util.*;
import java.util.stream.Collectors;

import static lambda.Lambda.lambdaMap;

public class Lambda001 {

	public static void main(String[] args) {
		lambdaImplRunnable();
		commonImpl();
	}
	
	/**
	 * 使用Thread匿名内部类方式创建线程
	 */
	public static void commonImpl2(){
		new Thread(){
			@Override
			public void run() {
				System.out.println("使用Thread匿名内部类方式创建线程");
			}
		}.start();
	}
	
	/***
	 * lambda表达式实现Runnable接口的Thread
	 */
	public static void  lambdaImplRunnable() {
		new Thread(
				()->{System.out.println("使用lambda表达式实现Runnable接口的Thread ");}
		).start();
	}

	/***
	 * 使用匿名内部类实现Runnable接口的Thread
	 */
	public static void commonImpl(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("使用匿名内部类实现Runnable接口的Thread");
			}
		}).start();
	}
	

}
