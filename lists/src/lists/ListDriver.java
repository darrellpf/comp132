package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDriver {

	public static void main(String[] args) {
		Student aStudent = new Student("a", "a", 23);
		Student bStudent = new Student("b", "b", 23);
		Student cStudent = new Student("c", "c", 23);

		List<Student> allStudents = new ArrayList<>();

		allStudents.add(aStudent);
		allStudents.add(bStudent);
		allStudents.add(cStudent);

		List<Student> copy = new ArrayList<>(allStudents);

		if (isSameListCounted(allStudents, copy)) {
			System.out.println("lists are the same counted");
		}

		if (isSameListForEach(allStudents.iterator(), copy.iterator())) {
			System.out.println("lists are the same iterator");
		}

		if (copy.equals(allStudents)) {
			System.out.println("lists are the same list equals");
		}

	}

	public static boolean isSameListForEach(Iterator<Student> aIterator,
			Iterator<Student> bIterator) {

		while (aIterator.hasNext()) {
			if (bIterator.hasNext() == false) {
				return false;
			}

			Student aStudent = aIterator.next();
			Student bStudent = bIterator.next();

			if (aStudent != bStudent) {
				return false;
			}
		}
		

		if (bIterator.hasNext() == true) {
			return false;
		}
		
		return true;

	}

	public static boolean isSameListCounted(List<Student> aList,
			List<Student> bList) {
		if (aList.size() != bList.size()) {
			return false;
		}

		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i) != bList.get(i)) {
				return false;
			}

		}

		return true;
	}
}
