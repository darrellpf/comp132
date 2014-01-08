package studentform;

public class Student {

	String firstName;
	String lastName;
	private int age;
	
	Student(String suppliedFirstName, String suppliedLastName, int suppliedAge) {
		firstName = suppliedFirstName;
		lastName = suppliedLastName;
		age = suppliedAge;
	}
	
	public void setAge(int suppliedAge) {
		if(suppliedAge < 0) {
			return;
		}
		
		age = suppliedAge;	
	}
	
}
