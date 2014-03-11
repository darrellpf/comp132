import java.util.Comparator;


public class Bid implements Comparable<Bid> {
	private String name;
	private int amount;
	
	public Bid(String inName, int inAmount) {
		name = inName;
		amount = inAmount;
	}
	
	public void setAmount(int inAmount) {
		amount = inAmount;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAmount() {
		return amount;
	}
	
	@Override
	public boolean equals(Object what) {
		Bid other = (Bid) what;
		return name.equals(other.name);
	}
	
	@Override
	public int compareTo(Bid other) {
		return amount - other.amount;
	}
	
	public static Comparator<Bid> getByName() {
		return new Comparator<Bid>() {

			public int compare(Bid a, Bid b) {
				
				String aName = a.name;
				String bName = b.name;
				
				return aName.compareTo(bName);
			}		
		};
	}
}
