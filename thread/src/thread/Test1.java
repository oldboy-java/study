package thread;

import java.util.HashMap;
import java.util.Hashtable;

public class Test1 {

	public static void main(String[] args)  throws Exception{
		
		/*Thread t1 = new Thread(new A());
		t1.start();
		t1.join();
		
		Thread t2 = new Thread(new A());
		t2.start();
		t2.join();
		
		Thread t3 = new Thread(new A());
		t3.start();
		t3.join();*/
		
		
	//	new A().run();
		
		System.err.println(Thread.currentThread().getName());
	}
	
	
	static class A implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println(Thread.currentThread().getName());
		}
		
	}

}
