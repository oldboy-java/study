package lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * 适用Lambda的Steam计算姓名中含有芝的用户最大年龄、最小年龄、平均年龄
 *  DoubleStream的API
 *  stream.max().getAsDouble()  //获取最大值
 *  stream.min().getAsDouble() //获取最小值
 *  stream.average().getAsDouble() //获取平均值
 */
public class Lambda006 {

	public static void main(String[] args) {
		//获取集合的Stream
		Stream<Person> stream = initPersonList().stream();

		//过滤姓名中含有"芝"的用户并获取用户的Age转换成DoubleStream
		DoubleStream doubleStream = stream.filter(person -> person.getName().indexOf("芝") > -1)
								.mapToDouble(person->person.getAge());
		//获取最大年龄
		//double maxAge = doubleStream.max().getAsDouble();
		//System.out.println("姓名中含有芝的最大年龄："+maxAge);

		//获取最小年龄
		//double minAge = doubleStream.min().getAsDouble();
	//	System.out.println("姓名中含有芝的最小年龄："+minAge);

		double avgAge = doubleStream.average().getAsDouble();
		System.out.println("姓名中含有芝的平均年龄："+avgAge);
	}

	/***
	 * 初始化用户列表
	 * @return 用户列表
	 */
	public static List<Person> initPersonList(){
		List<Person> personList = new ArrayList<Person>();
		Person person1 = new Person("张芝丰",43, Person.Sex.MALE);
		personList.add(person1);

		Person person2 = new Person("赵雅芝",63, Person.Sex.FEMEAL);
		personList.add(person2);

		Person person3 = new Person("宇芝锦健",83, Person.Sex.MALE);
		personList.add(person3);
		return personList;
	}


	 public static class Person{
	 	 public static  enum Sex{
	 	 	MALE,FEMEAL;
		 }
	 	 private String name;
		 private Integer age;
		 private Enum sex;

		 public String getName() {
			 return name;
		 }

		 public void setName(String name) {
			 this.name = name;
		 }

		 public Integer getAge() {
			 return age;
		 }

		 public void setAge(Integer age) {
			 this.age = age;
		 }

		 public Enum getSex() {
			 return sex;
		 }

		 public void setSex(Enum sex) {
			 this.sex = sex;
		 }

		 public Person() {
		 }

		 public Person(String name, Integer age, Enum sex) {
			 this.name = name;
			 this.age = age;
			 this.sex = sex;
		 }

		 @Override
		 public String toString() {
			 return "Person{" +
					 "name='" + name + '\'' +
					 ", age=" + age +
					 ", sex=" + sex +
					 '}';
		 }
	 }

}
