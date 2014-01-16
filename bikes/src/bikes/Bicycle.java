package bikes;

public class Bicycle {
	private int maximumGears;
	private int currentSpeed;
	private int currentGear;
	private String decal;
	
	public Bicycle(int inGears) {
		maximumGears = inGears;
		currentSpeed = 0;
		currentGear = 1;
		decal = "";
	}
	
	public Bicycle(int inGears, String inDecal) {
		maximumGears = inGears;
		currentSpeed = 0;
		currentGear = 1;
		decal = inDecal;
		
	}
	
	public String getDecal() {
		return decal;
	}
	
	public void shiftUp() {
		if(currentGear == maximumGears){
			return;
		}
		
		currentGear++;
	}
	
	public int getMaximumGears() {
		return maximumGears;
	}
	
	public void shiftDown() {
		currentGear--;
	}
	
	public int getCurrentGear() {
		return currentGear;
	}
	
	public int getGears() {
		return maximumGears;
	}
	
	public void pedal() {
		currentSpeed++;
	}
	
	public void brake() {
		if(currentSpeed == 0) {
			return;
		}
		
		currentSpeed--;
	}
	
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	
	@Override
	public String toString() {
		return "CurrentGear: " + currentGear
				+ " CurrentSpeed " + currentSpeed
				+ " MaximumGears: " + maximumGears
				+ "decal: " + decal;
	}

}
