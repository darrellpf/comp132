import java.io.Serializable;

public class Fish implements Comparable<Fish>, Serializable {
	private int weight;
	private String type;
	
	Fish(int inWeight, String inType) {
		weight = inWeight;
		type = inType;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getType() {
		return type;
	}
	
	public int compareTo(Fish other) {
		return 
			weight - other.weight;
	}

}
