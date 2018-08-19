package com.liuli.jvm;

public class Test {

	public static void main(String[] args) throws Exception{
		CanReliveObj obj=new CanReliveObj();
		obj=null;   //可复活
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
		    System.out.println("obj 是 null");
		}else{
		    System.out.println("obj 可用");
		}
		System.out.println("第二次gc");
		obj=null;    //不可复活
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
		System.out.println("obj 是 null");
		}else{
		System.out.println("obj 可用");
		}


	}

}
