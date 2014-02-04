package fishing;

import java.util.ArrayList;
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
	
	public void register(Bucket aBucket) {
		allBuckets.add(aBucket);
	}
}
