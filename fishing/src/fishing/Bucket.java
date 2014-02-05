package fishing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bucket implements Comparable<Bucket> {

	private String firstName;
	private String lastName;
	private List<Fish> allFish;
	
	public Bucket(String inFirst, String inLast) {
		firstName = inFirst;
		lastName = inLast;
		allFish = new ArrayList<Fish>();
	}
	
	@Override
	public boolean equals(Object what) {
		Bucket another = (Bucket) what;
		
		if(! lastName.equals(another.lastName)) {
			return false;
		}
		
		if(! firstName.equals(another.firstName)) {
			return false;
		}
		
		return true;
	}
	
	public void add(Fish aFish) {
		allFish.add(aFish);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Fish getBiggestFish() {
		Fish myBiggestFish = Collections.max(allFish);
		return myBiggestFish;
	}

	@Override
	public int compareTo(Bucket another) {
		Fish myBiggestFish = Collections.max(allFish);
		Fish yourBiggestFish = Collections.max(another.allFish);

		int difference = myBiggestFish.compareTo(yourBiggestFish);		
		return difference;
	}
}
