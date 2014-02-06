import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Derby implements Iterable<Fisher>, Serializable {
	private String name;
	private ArrayList<Fisher> allFishers;
	
	Derby(String inName) {
		name			= inName;
		allFishers		= new ArrayList<Fisher>();
	}
	
	public void add(Fisher who) {
		allFishers.add(who);
	}
	
	public int size() {
		return allFishers.size();
	}
	
	public Fisher getFisher(int position) {
		return allFishers.get(position);
	}
	
	public String getName() {
		return name;
	}
	
	public void addFish(Fish someFish, Fisher fakeFisher) {
		Fisher realFisher;
		
		int position = allFishers.indexOf(fakeFisher);
		realFisher = allFishers.get(position);
		realFisher.addToBucket(someFish);
	}
	
	public Fisher findWinner() {
		Fisher returnFisher = null;
		
		if(allFishers.size() == 0) {
			return null;
		}
		
		returnFisher = Collections.max(allFishers);
		
		return returnFisher;
	}
	
	public Iterator<Fisher> iterator() {
		Collections.sort(allFishers);
		Collections.reverse(allFishers);
		return allFishers.iterator();
	}
}
