package bitsandpiecestwo;


public class Fish implements Comparable<Fish>{
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

	@Override
	public int compareTo(Fish another) {
		return weight - another.weight;
	}
}
