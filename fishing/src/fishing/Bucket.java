package fishing;

import java.util.ArrayList;
import java.util.List;

public class Bucket {

	private String firstName;
	private String lastName;
	private List<Fish> allFish;
	
	public Bucket(String inFirst, String inLast) {
		firstName = inFirst;
		lastName = inLast;
		allFish = new ArrayList<Fish>();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
}
