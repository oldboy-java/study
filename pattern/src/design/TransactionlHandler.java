package design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * �����������ڷ�������ǰ��ʼ���񣬷������ý������������ύ���߻ع�
 * @author Administrator
 *
 */
public class TransactionlHandler implements InvocationHandler{
	
	//Ŀ�걻�������
	private Object target;
	
	public TransactionlHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("######����ʼ#########");
		try {
			//ִ��Ŀ�����ķ��� ,����ȡ��������󷽷����ú�ķ���ֵ
			result = method.invoke(target, args);
			
			//int a = 1/0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("######����ع�#########");
			return null;
		}
		System.out.println("######�����ύ#########");
		return result;
	}
	
	/**
	 * ���ش������
	 * @return
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
}
