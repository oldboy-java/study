package com.liuli.reflect;

import java.awt.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

import javax.swing.plaf.metal.MetalInternalFrameTitlePane;

interface message{
	public static final String COLOR="red";
}

class Person {
	private Integer weight;
	
	public void say() {
		
	}
}

class Student  extends Person implements message{
	
	private String name;
	private Integer age;
	
	public Student (String name,Integer age) {
		System.out.println("Student的有参构造方法");
	}
	
	public Student () {
		System.out.println("Student的无参构造方法");
	}
	
	public String toString() {
		return "Student类的toString方法";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}


public class ReflectDemo {

	public static void main(String[] args) throws Exception{
		//invokeDefalutConstructor();
		//invokeParamConstructor();
		//getMethods();
		//getDeclaredMethods();
		//invokeMethod();
		//getFields();
		operateField();
	}
	
	public static void invokeDefalutConstructor() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> cls = Class.forName("com.liuli.reflect.Student");
		Object object = cls.newInstance();
		System.out.println(object);
	}
	
	public static void invokeParamConstructor()  throws Exception{
		Class<?> cls = Class.forName("com.liuli.reflect.Student");
		
		//获取指定构造方法
		Constructor<?> constructor = cls.getConstructor(String.class,Integer.class);
		
		//调用构造方法实例化
		constructor.newInstance("zhangsan",19);
	}
	
	/***
	 * 获取全部方法：包括从父类中继承来的方法
	 * <p>Title: getMethods</p>
	 * <p>Description: </p>
	 * @throws Exception
	 */
	public static void getMethods() throws Exception {
		Class<?> cls = Class.forName("com.liuli.reflect.Student");
		Method method[] = cls.getMethods();
		for (int i = 0; i < method.length; i++) {
			//获取方法修饰符字符串
			System.out.print(Modifier.toString(method[i].getModifiers())+" ");
			
			//获取方法返回值的简单名称（不含包名）
			System.out.print(method[i].getReturnType().getSimpleName() +" ");
			
			//获取方法名称
			System.out.print(method[i].getName()+" (");
			
			//获取方法参数类型
			Class<?> paramTypes [] = method[i].getParameterTypes();
			if(paramTypes.length > 0) {
				for (int j = 0; j < paramTypes.length; j++) {
					System.out.print(paramTypes[j].getSimpleName() + "  arg-" +j );
					if(j < paramTypes.length-1) {
						System.out.print(",");
					}
				}
			}
			
			System.out.print(")");
			
			//获取方法抛出的异常
			Class<?> exps [] = method[i].getExceptionTypes();
			if(exps.length > 0) {
				System.out.print(" throws ");
				for (int j = 0; j < exps.length; j++) {
					System.out.print(exps[j].getSimpleName() + "  arg-" +j );
					if(j < exps.length-1) {
						System.out.print(",");
					}
				}
			}
			
			System.out.println();
		}
		
	}
	
	/**
	 * 获取本类中定义的方法
	 * <p>Title: getDeclaredMethods</p>
	 * <p>Description: </p>
	 * @throws Exception
	 */
	public static void getDeclaredMethods() throws Exception {
		System.out.println("***************");
		Class<?> cls = Class.forName("com.liuli.reflect.Student");
		Method method[] = cls.getDeclaredMethods();
		for (int i = 0; i < method.length; i++) {
			System.out.println(method[i]);
		}
	}
	
	
	/***
	 * 调用指定方法
	 * <p>Title: invokeMethod</p>
	 * <p>Description: </p>
	 * @throws Exception
	 */
	public static void invokeMethod() throws Exception  {
		Class<?> cls = Class.forName("com.liuli.reflect.Student");
		Object obj = cls.newInstance();
		
		Method setAgeMethod = cls.getMethod("setAge",Integer.class);
		Method getAgeMethod = cls.getMethod("getAge");
		
		setAgeMethod.invoke(obj, 18);
		Object returnResult = getAgeMethod.invoke(obj, null);
		System.out.println(returnResult);
	}
	
	
	/***
	 * 获取属性
	 * <p>Title: getFields</p>
	 * <p>Description: </p>
	 * @throws Exception
	 */
	public static void getFields()  throws Exception {
		Class<?> cls = Class.forName("com.liuli.reflect.Student");
		
		{//获取继承而来的全部属性（这里仅只从接口中继承来的属性）
			Field fields[] = cls.getFields();
			for (int i = 0; i < fields.length; i++) {
				System.out.println(fields[i]);
			}
		}
		
		{
			//获取本类定义的全部属性
			Field fields[] = cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				System.out.println(fields[i]);
			}
		}
		
		{
			//获取父类定义的全部属性
			Field fields[] = cls.getSuperclass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				System.out.println(fields[i]);
			}
		}
	}
	
	
	/***
	 * 为Person类的weight属性设置值和读取其值
	 * <p>Title: operateField</p>
	 * <p>Description: </p>
	 * @throws Exception
	 */
	public static void operateField()  throws Exception {
		Class<?> cls = Class.forName("com.liuli.reflect.Person");
		Object object = cls.newInstance();
		
		//获取属性
		Field field = cls.getDeclaredField("weight");
		
		//由于weigth属性采用private修饰，进行了封装，不能直接操作，需要取消封装。其他修饰如：public,protected都能
		//访问，为了统一情况，可以一并设置为取消封装
		field.setAccessible(true);
		
		//为属性设值
		field.set(object, 120);
		
		//获取属性值
		Object fieldValue = field.get(object);
		System.out.println(fieldValue);
	}
}
