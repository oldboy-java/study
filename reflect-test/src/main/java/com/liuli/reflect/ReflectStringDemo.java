package com.liuli.reflect;

import java.lang.reflect.Constructor;

public class ReflectStringDemo {

	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("java.lang.String");
		Constructor<?> constructors[] = cls.getConstructors();

		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i]);
		}
	}

}
