
public class Bottle implements Comparable<Bottle> {
	private String label;
	private int maxVolume;
	private int currentVolume;
	
	private int singlePours;
	private int doublePours;
	
	public Bottle(String inLabel, int inMaxVolume) {
		label = inLabel;
		maxVolume = inMaxVolume;
		currentVolume = inMaxVolume;
		
		singlePours = 0;
		doublePours = 0;
	}
	
	public String getLabel() {
		return label;
	}
	
	public int getMaxVolume() {
		return maxVolume;
	}
	
	public int getCurrentVolume() {
		return currentVolume;
	}
	
	public void pourSingle() {
		if(currentVolume == 0) {
			return;
		}
		
		currentVolume -= 1;
		singlePours++;
	}
	
	public void pourDouble() {
		if(currentVolume < 2) {
			return;
		}
		
		currentVolume -= 2;
		doublePours++;
	}
	
	public boolean allPoursAccounted() {
		int actuallyPoured = maxVolume - currentVolume;
		int volumeByPourCount = singlePours + (doublePours * 2);
		
		if(actuallyPoured != volumeByPourCount) {
			return false;
		}
		
		return true;
	}
	
	public int compareTo(Bottle other) {
		int difference = label.compareTo(other.label);
		if(difference != 0) {
			return difference;
		}
		
		difference = currentVolume - other.currentVolume;
		return difference;
	}
	
	public boolean equals(Object what) {
		Bottle other = (Bottle) what;
		
		if( ! label.equals(other.label)) {
			return false;
		}
		
		if( maxVolume != other.maxVolume) {
			return false;
		}
		
		return true;
	}
}
