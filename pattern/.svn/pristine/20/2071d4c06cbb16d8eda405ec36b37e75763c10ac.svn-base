package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(21, "zhangsan"));
		list.add(new Student(11, "lisi"));
		list.add(new Student(11, "wangwu"));
		
		Collections.sort(list,new StudentComparator());
		
		for(Student student:list){
			System.out.println(student.getId()+","+student.getName());
		}

	}

}
