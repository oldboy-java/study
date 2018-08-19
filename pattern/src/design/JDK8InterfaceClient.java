package design;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/***
 * 测试JDK8接口中新增的静态方法和默认方法
 * 1、JDK8中接口中可以定义static方法,在接口实现中是不可见的，只能通过类名调用。
 * 2、JDK8中接口中可以default方法,在接口实现中是可见的,只能通过实例对象进行调用
 * 
 * @author Administrator
 *
 */
public class JDK8InterfaceClient {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		
		//通过接口实例对象来调用接口中的默认方法
		userService.defaultMethod();
		
		//通过接口类名调用接口中的静态方法
		UserService.staticMethod();
		
		System.err.println(UserService.a);
		System.err.println(getValue(2)); 
		
	}
	
	
	public static int getValue(int i) {
		int result =0 ;
		switch (i) {
		case 1:
			result=result+i;
		case 2:
			result=result+i*2;

		case 3:
			result=result+i*3;
		}
		return result;
	}
}
