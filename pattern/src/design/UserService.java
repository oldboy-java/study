package design;

public interface UserService {

	public static final int a = 123;
	
	public  abstract void addUser(String name);
	
	public  static void staticMethod(){
		System.out.println("JDK8中接口中可以定义static方法,在接口实现中是不可见的，只能通过类名调用");
	}
	public  default void defaultMethod(){
		System.out.println("JDK8中接口中可以default方法,在接口实现中是可见的,只能通过实例对象进行调用");
	}
}
