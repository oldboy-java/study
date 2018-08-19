package com.liuli.jvm;

public class CanReliveObj {
	public static CanReliveObj obj;
	@Override
	protected void finalize() throws Throwable {
	    super.finalize();
	    System.out.println("CanReliveObj finalize called");
	    obj=this;
	}
	@Override
	public String toString(){
	    return "I am CanReliveObj";
	}
}