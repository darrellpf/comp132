package studentform;

public class Student {

	private String firstName;
	private String lastName;
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
		
		if(suppliedAge > 120) {
			return;
		}
		
		age = suppliedAge;	
	}
	
	public int getAge() {
		return age;
	}
	
	public void setFirstName(String inFirst) {
		firstName = inFirst;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String inLast) {
		lastName = inLast;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result += firstName + " ";
		result += lastName + " ";
		result += age;
		
		return result;
	}
}
