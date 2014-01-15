package bikes;

public class Bicycle {
	private int gears;
	private int currentSpeed;
	private int currentGear;
	
	public Bicycle(int inGears) {
		gears = inGears;
		currentSpeed = 0;
		currentGear = 1;
	}
	
	public void shiftUp() {
		currentGear++;
	}
	
	public void shiftDown() {
		currentGear--;
	}
	
	public int getCurrentGear() {
		return currentGear;
	}
	
	public int getGears() {
		return gears;
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
}
