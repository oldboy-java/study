package design;

import thread.MyThread;

public class StaticProxyClient {

	public static void main(String[] args) {
		UserService userService = new UserServiceProxy();
		userService.addUser("zhangsan");
		
		
		ThreadLocal<String> local = new ThreadLocal<>(); 
		
		MyThread thread = null;
		try {
			thread = new MyThread();
			thread.start();
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.err.println("**************");
		
	}


}
