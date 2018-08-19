package design;

public class Client {

	public static void main(String[] args) {
		//被代理对象
		UserService userService = new UserServiceImpl();
		
		//实例化事务处理器
		TransactionlHandler handler = new TransactionlHandler(userService);
		
		//获取代理对象
		UserService proxy = (UserService) handler.getProxy();
		
		proxy.addUser("张三");
		
	}

}
