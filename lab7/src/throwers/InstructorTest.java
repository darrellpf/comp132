package throwers;
import static org.junit.Assert.*;

import org.junit.Test;

public class InstructorTest {
	
	@Test
	public void instructorInterface() {
		Instructor anInstructor = new Instructor("Fred");
		assertTrue(anInstructor instanceof InstructorInterface);
	}

	@Test
	public void initalized() {
		Instructor anInstructor = new Instructor("Fred");
		
		assertTrue(anInstructor.getNickName().equals("Fred"));
		assertTrue(anInstructor.getDunks() == 0);
		assertTrue(anInstructor.getTotalMoneyRaised() == 0);
	}
	
	@Test
	public void moneyUp() {
		Instructor anInstructor = new Instructor("Fred");

		anInstructor.addToMoneyRaised(10.0F);
		assertTrue(anInstructor.getTotalMoneyRaised() == 10.0);
		assertTrue(anInstructor.getDunks() == 0);
		
		anInstructor.addToMoneyRaised(20.0F);
		double expectedMoney = 10.0 + 20.0;
		double actualMoney = anInstructor.getTotalMoneyRaised();
		assertTrue(inRange(actualMoney, expectedMoney, 0.001));
		assertTrue(anInstructor.getDunks() == 0);
	}
	
	@Test
	public void dunksUp() {
		Instructor anInstructor = new Instructor("Fred");

		anInstructor.wasDunked();
		assertTrue(anInstructor.getTotalMoneyRaised() == 0);
		assertTrue(anInstructor.getDunks() == 1);
		
		anInstructor.wasDunked();
		assertTrue(anInstructor.getTotalMoneyRaised() == 0);
		assertTrue(anInstructor.getDunks() == 2);
	}
	
	@Test
	public void compareable() {
		Instructor anInstructor = new Instructor("Fred");
		assertTrue(anInstructor instanceof Comparable);
	}
	
	@Test
	public void compareToWorks() {
		Instructor lower = new Instructor("lower");		
		lower.addToMoneyRaised(30);
		
		Instructor higher = new Instructor("higher");		
		higher.addToMoneyRaised(999);
		
		assertTrue(lower.compareTo(higher) < 0);
	}
	
	@Test
	public void equalsWorks() {
		Instructor fred = new Instructor("Fred");
		Instructor fakeFred = new Instructor("Fred");
		Instructor notFred = new Instructor("Not Fred");
		
		assertTrue(fred.equals(fred) == true);
		assertTrue(fakeFred.equals(fred) == true);
		assertTrue(notFred.equals(fred) == false);
	}
	
	private boolean inRange(double value, double actual, double delta) {
		if(value < actual - delta) {
			return false;
		}
		
		if(value > actual + delta) {
			return false;
		}
		
		return true;
	}
}
