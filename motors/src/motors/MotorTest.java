package motors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void hoursOfService() {
		Motor aMotor = new Motor("A", 10);
		
		aMotor.addHoursOfService(6);
		assertTrue(aMotor.getHoursOfService() == 6);
		
		boolean timeForService = aMotor.isPastService();
		
		assertTrue(timeForService == false);
		
		aMotor.addHoursOfService(3);
		assertTrue(aMotor.getHoursOfService() == 9);
		timeForService = aMotor.isPastService();	
		assertTrue(timeForService == false);
		
		aMotor.addHoursOfService(1);
		assertTrue(aMotor.getHoursOfService() == 10);
		timeForService = aMotor.isPastService();	
		assertTrue(timeForService == false);
		
		aMotor.addHoursOfService(1);
		assertTrue(aMotor.getHoursOfService() == 11);
		timeForService = aMotor.isPastService();	
		assertTrue(timeForService == true);
	
		aMotor.addHoursOfService(4);
		assertTrue(aMotor.getHoursOfService() == 15);
		timeForService = aMotor.isPastService();	
		assertTrue(timeForService == true);

		
	}

}
