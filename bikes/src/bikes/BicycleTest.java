package bikes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BicycleTest {
	
	Bicycle myBike;

	@Before
	public void setUp() throws Exception {
		myBike = new Bicycle(21);
	}

	@Test
	public void initialSetup() {
		int gears = myBike.getGears();
		assertTrue(gears == 21);
		
		int speed = myBike.getCurrentSpeed();
		assertTrue(speed == 0);
		
		int currentGear = myBike.getCurrentGear();
		assertTrue(currentGear == 1);
	}
	
	@Test
	public void pedalOnce() {
		Bicycle fifteenSpeedBike = new Bicycle(15);
		
		fifteenSpeedBike.pedal();
		int speed = fifteenSpeedBike.getCurrentSpeed();
		assertTrue(speed == 1);
	}
	
	@Test
	public void brakeOnce() {
		Bicycle myBike = new Bicycle(21);
		
		int speed = myBike.getCurrentSpeed();
		assertTrue(speed == 0);
		
		myBike.pedal();
		
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 1);
		
		myBike.brake();
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 0);
	}
	
	@Test
	public void noBrakingBelowZero() {
		Bicycle myBike = new Bicycle(21);
		
		int speed = myBike.getCurrentSpeed();
		assertTrue(speed == 0);
		
		myBike.pedal();
		
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 1);
		
		myBike.brake();
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 0);
		
		myBike.brake();
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 0);
	}
	
	@Test
	public void speedIncreases() {
		Bicycle myBike = new Bicycle(21);
		
		int speed = myBike.getCurrentSpeed();
		assertTrue(speed == 0);
		
		myBike.pedal();		
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 1);
		
		myBike.pedal();		
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 2);
		
		myBike.pedal();		
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 3);
		
	}

	public void brakingDecreases() {
		Bicycle myBike = new Bicycle(21);
		
		myBike.pedal();
		myBike.pedal();
		myBike.pedal();
		myBike.pedal();
		
		int speed = myBike.getCurrentSpeed();
		assertTrue(speed == 4);
		
		myBike.brake();
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 3);
		
		myBike.brake();
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 2);
		
		myBike.brake();
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 1);
		
		myBike.brake();
		speed = myBike.getCurrentSpeed();
		assertTrue(speed == 0);
	}
	
	@Test
	public void gearUpOnce() {
		int currentGear = myBike.getCurrentGear();
		assertTrue(currentGear == 1);
		
		myBike.shiftUp();
		
		currentGear = myBike.getCurrentGear();
		assertTrue(currentGear == 2);
		
	}
}
