package midterm1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BundleMakerTest {

	@Test
	public void backwards() {
		BundleMaker maker = new BundleMaker(3, 2);
		
		maker.start();
		assertTrue(maker.getPartialSize() == 0);
		assertTrue(maker.getNumberMade() == 2);
		
		maker.tick();
		assertTrue(maker.getPartialSize() == 1);
		assertTrue(maker.getNumberMade() == 2);
		maker.tick();
		assertTrue(maker.getPartialSize() == 2);
		assertTrue(maker.getNumberMade() == 2);
		maker.tick();
		assertTrue(maker.getPartialSize() == 0);	
		assertTrue(maker.getNumberMade() == 1);
		
		maker.tick();
		assertTrue(maker.getPartialSize() == 1);
		assertTrue(maker.getNumberMade() == 1);
		maker.tick();
		assertTrue(maker.getPartialSize() == 2);
		assertTrue(maker.getNumberMade() == 1);
		maker.tick();
		assertTrue(maker.getPartialSize() == 0);
		assertTrue(maker.getNumberMade() == 0);
		
		maker.tick();
		
		assertTrue(maker.getPartialSize() == 0);
		assertTrue(maker.getNumberMade() == 0);
	}

}
