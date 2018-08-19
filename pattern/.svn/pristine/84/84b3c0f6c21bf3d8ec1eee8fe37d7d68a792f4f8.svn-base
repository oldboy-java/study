package comparator;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student o1, Student o2) {
		//相等返回0，大于返回1 升序  ， 小于返回 -1 ，降序
		return o1.getId()==o2.getId() ? 0 :(o1.getId() > o2.getId() ? 1 :-1);
	}
}
