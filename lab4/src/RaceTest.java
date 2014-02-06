
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RaceTest {

	RaceInterface aRace;
	
	@Before
	public void setUp() throws Exception {
		aRace = new Race("Indy", 20);
	}
	
	@Test
	public void findCarWorks() {
		RaceCar carA = new RaceCar("fred", 10);
		RaceCar carB = new RaceCar("sam", 17);
		RaceCar carC = new RaceCar("joe", 8);
		
		aRace.add(carA);
		aRace.add(carB);
		aRace.add(carC);
		
		RaceCarInterface foundCar;
		
		foundCar = aRace.findCar(10);
		assertTrue(foundCar == carA);
		
		foundCar = aRace.findCar(17);
		assertTrue(foundCar == carB);
		
		foundCar = aRace.findCar(8);
		assertTrue(foundCar == carC);		
	}

	@Test
	public void findFinishPosition() {
		RaceCar carA = new RaceCar("fred", 10);
		RaceCar carB = new RaceCar("sam", 17);
		RaceCar carC = new RaceCar("joe", 8);
		
		aRace.add(carA);
		aRace.add(carB);
		aRace.add(carC);
		
		for(int i = 0; i < 20; i++) {
			aRace.addLap(17);
			aRace.addLap(10);
			aRace.addLap(8);
		}
		
		RaceCarInterface foundCar;
		
		foundCar = aRace.findFinishPosition(1);
		assertTrue(foundCar == carB);
		
		foundCar = aRace.findFinishPosition(2);
		assertTrue(foundCar == carA);
		
		foundCar = aRace.findFinishPosition(3);
		assertTrue(foundCar == carC);		
	}
	
	@Test
	public void findRacer() {
		RaceCar carA = new RaceCar("albert", 10);
		RaceCar carB = new RaceCar("benny", 17);
		RaceCar carC = new RaceCar("carl", 8);
		
		aRace.add(carA);
		aRace.add(carB);
		aRace.add(carC);
		
		RaceCarInterface foundCar;
		
		foundCar = aRace.findRacer(new RaceCar("carl", 0));
		assertTrue(foundCar == carC);
		
		foundCar = aRace.findRacer(new RaceCar("benny", 0));
		assertTrue(foundCar == carB);
		
		foundCar = aRace.findRacer(new RaceCar("albert", 0));
		assertTrue(foundCar == carA);
		
		foundCar = aRace.findRacer(new RaceCar("nobody", 17));
		assertTrue(foundCar == null);
	}

}
