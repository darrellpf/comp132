package studentform;

public class Driver {

	public static void main(String[] args) {

		Student firstPerson = new Student("Fred", "Flintstone", 43);
		
		Student secondPerson = new Student("Wilma", "Flintstone", 23);
		
		firstPerson.setFirstName("Frederick");

		firstPerson.setAge(-23);
		
		int result = firstPerson.getAge();
		
		Student thirdStudent = new Student("Bambam", "Rubbble");		
		System.out.println(thirdStudent);
	}

}
