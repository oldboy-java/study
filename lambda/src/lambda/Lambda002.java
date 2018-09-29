package lambda;

/**
 * 分别使用匿名内部类和lambda实现Runnable接口
 */
public class Lambda002 {

	public static void main(String[] args) {
		int i = 1;
		//使用匿名内部类实现Runnable接口,并调用run()
		new Runnable() {
			@Override
			public void run() {
				System.out.println("使用匿名内部类实现Runnable接口");
				System.out.println(i);
			}
		}.run();

	   
		//使用lambda实现Runnable接口，并调用run(),()表示run方法参数列表
		Runnable runnable = () -> {
			System.out.println("使用lambda表达式实现Runnable接口");
		};
		runnable.run();
	}
	

}
