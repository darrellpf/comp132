package priceisright;

import java.util.Comparator;

public class Contestant implements Comparable<Contestant>{
	private String name;
	private int amount;
	
	public Contestant(String inName) {
		name = inName;
		amount = 0;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int inAmount) {
		amount = inAmount;
	}
	
	public boolean equals(Object what) {
		Contestant other = (Contestant) what;
		return name.equals(other.name);
	}
	
	public int compareTo(Contestant another) {
		return amount - another.amount;
	}
	
	public Comparator<Contestant> byName() {
		return new Comparator<Contestant>() {
			public int compare(Contestant a, Contestant b) {
				return a.name.compareTo(b.name);
			}
		};
	}
}
