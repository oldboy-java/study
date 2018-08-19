package design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 事务处理器：在方法调用前开始事务，方法调用结束进行事务提交或者回滚
 * @author Administrator
 *
 */
public class TransactionlHandler implements InvocationHandler{
	
	//目标被代理对象
	private Object target;
	
	public TransactionlHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("######事务开始#########");
		try {
			//执行目标对象的方法 ,并获取被代理对象方法调用后的返回值
			result = method.invoke(target, args);
			
			//int a = 1/0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("######事务回滚#########");
			return null;
		}
		System.out.println("######事务提交#########");
		return result;
	}
	
	/**
	 * 返回代理对象
	 * @return
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
}
