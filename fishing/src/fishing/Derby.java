package fishing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Derby {
	private String name;
	private List<Bucket> allBuckets;
	
	public Derby(String inName) {
		name = inName;
		allBuckets = new ArrayList<Bucket>();
	}
	
	public String getName() {
		return name;
	}
	
	public Bucket getWinner() {
		Bucket bestBucket = Collections.max(allBuckets);
		return bestBucket;
	}
	
	public void addFish(Fish aFish, Bucket matchThisOne) {
		int position= allBuckets.indexOf(matchThisOne);
		Bucket actualBucket = allBuckets.get(position);
		actualBucket.add(aFish);
	}
	
	public void register(Bucket aBucket) {
		allBuckets.add(aBucket);
	}
}
