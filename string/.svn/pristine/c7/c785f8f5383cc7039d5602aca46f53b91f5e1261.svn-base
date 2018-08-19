package string;

import java.lang.reflect.Field;



public class Test {

	public static void main(String[] args) throws Exception {
		
		String a = "abcd";
		Field field =  String.class.getDeclaredField("value");
		field.setAccessible(true);
		
		char c[] = (char[]) field.get(a);
		c[1]='A';
		System.out.println(a);
	}

}
