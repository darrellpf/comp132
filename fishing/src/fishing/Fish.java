package fishing;

public class Fish {
	private int weight;
	private String type;
	
	public Fish(int inWeight, String inType) {
		weight = inWeight;
		type = inType;
	}
	
	public String getType() {
		return type;
	}
	
	public int getWeight() {
		return weight;
	}
}
