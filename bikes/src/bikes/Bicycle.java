package bikes;

public class Bicycle {
	private int gears;
	private int currentSpeed;
	
	public Bicycle(int inGears) {
		gears = inGears;
	}
	
	public int getGears() {
		return gears;
	}
	
	public void pedal() {
		currentSpeed++;
	}
	
	public int getCurrentSpeed() {
		return currentSpeed;
	}
}
