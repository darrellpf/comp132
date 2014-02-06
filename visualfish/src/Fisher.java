import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Fisher implements Comparable<Fisher>, Iterable<Fish>, Serializable {
	private String name;
	private ArrayList<Fish> bucket;
	
	Fisher(String inName) {
		name = inName;
		bucket = new ArrayList<Fish>();
	}
	
	public boolean equals(Object what) {
		Fisher who = (Fisher) what;
		
		return name.equals(who.name);
	}
	
	public void addToBucket(Fish aFish) {
		bucket.add(aFish);
	}
	
	public String getName() {
		return name;
	}
	
	public Iterator<Fish> iterator() {
		return bucket.iterator();
	}
	
	public Fish getBiggestFish() {
		if(bucket.size() == 0) {
			return null;
		}
		
		Fish aFish = Collections.max(bucket);
		return aFish;
	}
	
	public int compareTo(Fisher another) {
		Fish myBiggestFish = getBiggestFish();
		if(myBiggestFish == null) {
			return -1;
		}
		
		Fish yourBiggestFish = another.getBiggestFish();
		if(yourBiggestFish == null) {
			return +1;
		}
		
		return myBiggestFish.compareTo(yourBiggestFish);
	}
}
