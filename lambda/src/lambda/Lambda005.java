package lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 适用Lambda的Steam操作,使用filter过滤男性用户，并遍历打印
 */
public class Lambda005 {

	public static void main(String[] args) {
		//获取集合的Stream
		Stream<Person> stream = initPersonList().stream();

		//过滤出男性用户，返回Stream
		stream = stream.filter(person -> person.getSex() == Person.Sex.MALE);

		//遍历
		stream.forEach(person -> {
			System.out.println(person.toString());
		});
	}

	/***
	 * 初始化用户列表
	 * @return 用户列表
	 */
	public static List<Person> initPersonList(){
		List<Person> personList = new ArrayList<Person>();
		Person person1 = new Person("张三丰",43, Person.Sex.MALE);
		personList.add(person1);

		Person person2 = new Person("赵雅芝",63, Person.Sex.FEMEAL);
		personList.add(person2);

		Person person3 = new Person("宇津锦健",83, Person.Sex.MALE);
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
