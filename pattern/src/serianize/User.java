package serianize;

import java.io.Serializable;

public class User implements Serializable {

	private String name;
	
	public  transient int age;
	
	public static String height;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static String getHeight() {
		return height;
	}

	public static void setHeight(String height) {
		User.height = height;
	}

	public User(String name, int age,String height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
}
