package design;

public interface UserService {

	public static final int a = 123;
	
	public  abstract void addUser(String name);
	
	public  static void staticMethod(){
		System.out.println("JDK8�нӿ��п��Զ���static����,�ڽӿ�ʵ�����ǲ��ɼ��ģ�ֻ��ͨ����������");
	}
	public  default void defaultMethod(){
		System.out.println("JDK8�нӿ��п���default����,�ڽӿ�ʵ�����ǿɼ���,ֻ��ͨ��ʵ��������е���");
	}
}
