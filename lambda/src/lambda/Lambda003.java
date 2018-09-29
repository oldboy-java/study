package lambda;


/**
 * 分别使用匿名内部类和lambda实现自定义接口
 */
public class Lambda003 {

	public static void main(String[] args) {
		//使用匿名内部类实现接口
		new Action(){
			@Override
			public void execute(String content) {
				System.out.println(content);
			}
		}.execute("jdk8之前使用匿名内部类实现接口，并执行execute方法");


		//使用lambda实现接口(只适用于接口中只有一个需要实现的方法)
		Action action = (String content) ->{
			System.out.println(content);
		};
		action.execute("jdk8使用lambda实现接口，并执行execute方法");
	}

	/**
	 * 定义静态内部接口
	 */
	public static interface  Action{
		public void execute(String content);
	}

}
