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
 * ����JDK8�ӿ��������ľ�̬������Ĭ�Ϸ���
 * 1��JDK8�нӿ��п��Զ���static����,�ڽӿ�ʵ�����ǲ��ɼ��ģ�ֻ��ͨ���������á�
 * 2��JDK8�нӿ��п���default����,�ڽӿ�ʵ�����ǿɼ���,ֻ��ͨ��ʵ��������е���
 * 
 * @author Administrator
 *
 */
public class JDK8InterfaceClient {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		
		//ͨ���ӿ�ʵ�����������ýӿ��е�Ĭ�Ϸ���
		userService.defaultMethod();
		
		//ͨ���ӿ��������ýӿ��еľ�̬����
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
