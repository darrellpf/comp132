package throwers;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static throwers.BallPurchase.*;

public class EmceeTest {
	
	Emcee host;
	
	Thrower aThrower;
	Thrower bThrower;
	Thrower cThrower;
	
	Instructor aInstructor;
	Instructor bInstructor;
	Instructor cInstructor;


	@Before
	public void setUp() throws Exception {
		host = new Emcee();
		
		aThrower = new Thrower("AThrower", FIVE_FOR_FIFTEEN);
		bThrower = new Thrower("BThrower", THREE_FOR_TEN);
		cThrower = new Thrower("CThrower", ONE_FOR_FIVE);
		
		aInstructor = new Instructor("a");
		bInstructor = new Instructor("b");
		cInstructor = new Instructor("c");
	}
	
	@Test
	public void emceeInterface() {
		ThrowerAbstract currentThrower = host.getCurrentThrower();
		assertTrue(currentThrower instanceof Thrower);
	}

	@Test
	public void initalized() {
		ThrowerAbstract currentThrower = host.getCurrentThrower();
		assertTrue(currentThrower.hasNext() == false);
		
		Iterator<InstructorInterface> iter = host.iterator();
		assertTrue(iter.hasNext() == false);
		
		InstructorInterface victim = host.getCurrentVictim();
		String name = victim.getNickName();
		assertTrue(name.equals(""));
	}
	
	@Test
	public void oneThrower() {
		host.throwerStepsUp(aThrower);
		assertTrue(host.getCurrentThrower() == aThrower);
		
		host.throwerChoosesVictim(aInstructor);
		assertTrue(host.getCurrentVictim() == aInstructor);
		
		assertTrue(host.throwAnother() == true);
		InstructorInterface who = host.getCurrentVictim();
		assertTrue(inRange(who.getTotalMoneyRaised(), 15.0/5, 0.1));
		assertTrue(who.getDunks() == 0);
		
		host.dunked();
		
		who = host.getCurrentVictim();
		assertTrue(inRange(who.getTotalMoneyRaised(), 15.0/5, 0.1));
		assertTrue(who.getDunks() == 1);
	}
	
	@Test
	public void twoThrowers() {
		oneThrower();
		
		host.throwerStepsUp(bThrower);
		assertTrue(host.getCurrentThrower() == bThrower);

		host.throwerChoosesVictim(bInstructor);
		assertTrue(host.getCurrentVictim() == bInstructor);
		
		assertTrue(host.throwAnother() == true);
		host.dunked();
		InstructorInterface who = host.getCurrentVictim();
		assertTrue(inRange(who.getTotalMoneyRaised(), 10.0/3, 0.1));
		assertTrue(who.getDunks() == 1);
	}
	
	@Test
	public void iteratorInterface() {
		assertTrue(host instanceof Iterable);
	}
	
	@Test
	public void iteratorOrder() {
		host.throwerStepsUp(aThrower);
		host.throwerChoosesVictim(aInstructor);

		assertTrue(host.throwAnother() == true);
		assertTrue(host.throwAnother() == true);
		
		host.throwerStepsUp(bThrower);
		host.throwerChoosesVictim(bInstructor);

		assertTrue(host.throwAnother() == true);
		assertTrue(host.throwAnother() == true);
		assertTrue(host.throwAnother() == true);

		assertTrue(host.throwAnother() == false);
		
		host.throwerStepsUp(cThrower);
		host.throwerChoosesVictim(cInstructor);

		assertTrue(host.throwAnother() == true);
		assertTrue(host.throwAnother() == false);

		Iterator<InstructorInterface> iter = host.iterator();
		
		assertTrue(iter.next() == bInstructor);
		assertTrue(iter.next() == aInstructor);
		assertTrue(iter.next() == cInstructor);
		
		assertTrue(iter.hasNext() == false);
		
		assertTrue(inRange(host.getTotalFundsRaised(), (2 * (15.0/5)) + (3 * (10.0/3)) + (1 * (5.0/1)), 0.1));
	}
	
	@Test
	public void dunkingOrder() {
		aInstructor = new Instructor("zzzz");
		bInstructor = new Instructor("b");
		cInstructor = new Instructor("c");
		
		host.throwerStepsUp(aThrower);
		host.throwerChoosesVictim(aInstructor);

		assertTrue(host.throwAnother() == true);
		host.dunked();
		assertTrue(host.throwAnother() == true);
		
		host.throwerStepsUp(bThrower);
		host.throwerChoosesVictim(bInstructor);

		assertTrue(host.throwAnother() == true);
		host.dunked();
		assertTrue(host.throwAnother() == true);
		host.dunked();
		assertTrue(host.throwAnother() == true);

		assertTrue(host.throwAnother() == false);
		
		host.throwerStepsUp(cThrower);
		host.throwerChoosesVictim(cInstructor);

		assertTrue(host.throwAnother() == true);
		host.dunked();
		assertTrue(host.throwAnother() == false);

		List<InstructorInterface> dunksList = host.byDunks();
		Iterator<InstructorInterface> iter = dunksList.iterator();
		
		assertTrue(iter.next() == bInstructor);
		assertTrue(iter.next() == cInstructor);
		assertTrue(iter.next() == aInstructor);
		
		assertTrue(iter.hasNext() == false);
		
		assertTrue(inRange(host.getTotalFundsRaised(), (2 * (15.0/5)) + (3 * (10.0/3)) + (1 * (5.0/1)), 0.1));

		dunksList.clear();
		
		Iterator<InstructorInterface> unchangedIter = host.iterator();
		
		assertTrue(unchangedIter.hasNext() == true);

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
