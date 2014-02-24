package throwers;
import static org.junit.Assert.*;

import org.junit.Test;
import static throwers.BallPurchase.THREE_FOR_TEN;

public class ThrowerTest {

	@Test
	public void throwerInterface() {
		ThrowerAbstract aThrower = new Thrower("Fred", THREE_FOR_TEN);
		assertTrue(aThrower instanceof Thrower);
		
		assertTrue(aThrower.getName().equals("Fred"));
		assertTrue(aThrower.getBallPurchase().getBalls() == 3);
		
		float costPer = aThrower.getCostPerBall();
		assertTrue(inRange(costPer, 10/3.0, 0.01) == true);
	}
	
	@Test
	public void getsAll() {
		Thrower aThrower = new Thrower("Fred", THREE_FOR_TEN);
		
		assertTrue(aThrower.hasNext() == true);
		assertTrue(aThrower.getBallPurchase().getBalls() == 3);
		
		assertTrue(aThrower.next() == 3);
		
		assertTrue(aThrower.hasNext() == true);
		assertTrue(aThrower.getBallPurchase().getBalls() == 3);
		
		assertTrue(aThrower.next() == 2);
		
		assertTrue(aThrower.hasNext() == true);
		assertTrue(aThrower.getBallPurchase().getBalls() == 3);
		
		assertTrue(aThrower.next() == 1);
		
		assertTrue(aThrower.hasNext() == false);
		assertTrue(aThrower.getBallPurchase().getBalls() == 3);
		
		float costPer = aThrower.getCostPerBall();
		assertTrue(inRange(costPer, 10/3.0, 0.01) == true);

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
