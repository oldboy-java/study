package design;

/***
 * 静态代理
 * @author Administrator
 */
public class UserServiceProxy implements UserService {

	private UserService userService = new UserServiceImpl();

	@Override
	public void addUser(String name) {
		System.out.println("######事务开始#########");
		try {
			userService.addUser(name);
			System.out.println("######事务开始#########");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("######事务回滚#########");
		}
	}
}
