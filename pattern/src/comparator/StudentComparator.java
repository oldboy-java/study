package comparator;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student o1, Student o2) {
		//��ȷ���0�����ڷ���1 ����  �� С�ڷ��� -1 ������
		return o1.getId()==o2.getId() ? 0 :(o1.getId() > o2.getId() ? 1 :-1);
	}
}
