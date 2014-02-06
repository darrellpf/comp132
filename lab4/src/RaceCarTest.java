
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RaceCarTest {
	
	RaceCarInterface aCar;

	@Before
	public void setUp() throws Exception {
		aCar = new RaceCar("Fred", 20);
	}
	
	@Test
	public void lapsIncrease() {
		assertTrue(aCar.getLapsCompleted() == 0);
		
		aCar.addLap();
		assertTrue(aCar.getLapsCompleted() == 1);
		
		aCar.addLap();
		assertTrue(aCar.getLapsCompleted() == 2);
		
		aCar.addLap();
		assertTrue(aCar.getLapsCompleted() == 3);
	}
	
	@Test
	public void equalsWorks() {
		RaceCarInterface firstCar = new RaceCar("Fred", 10);
		RaceCarInterface sameAsFirstCar = new RaceCar("", 10);
		
		assertTrue(firstCar.equals(sameAsFirstCar));
		
		RaceCarInterface notSameCar = new RaceCar("Fred", 22);
		
		assertTrue( ! firstCar.equals(notSameCar));
	}
	
	@Test
	public void compareToWorks() {
		// Note that the car numbers are reversed order from the
		// finish positions.
		
		RaceCar lowPosition = new RaceCar("few", 22);
		lowPosition.setFinishPosition(20);
		
		RaceCar highPosition = new RaceCar("many", 17);
		highPosition.setFinishPosition(55);
		
		assertTrue(lowPosition.compareTo(highPosition) == 20 - 55);
		assertTrue(highPosition.compareTo(lowPosition) == 55 - 20);
	}
	
	@Test
	public void disqualifiedDoesntAddLaps() {
		aCar.addLap();
		assertTrue(aCar.getLapsCompleted() == 1);
		
		aCar.disqualify();
		
		aCar.addLap();
		assertTrue(aCar.getLapsCompleted() == 1);		
	}

}
