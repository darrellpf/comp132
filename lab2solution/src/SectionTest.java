
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SectionTest {
	
	private Section aSection;

	@Before
	public void setUp() throws Exception {
		aSection = new Section("Comp139", 3);
	}
	
	@Test
	public void initialize() {
		String name = aSection.getName();
		assertTrue(name.equals("Comp139"));		
		
		assertTrue(aSection.getMaximumStudents() == 3);
		
		assertTrue(aSection.getSignedUp() == 0);
		assertTrue(aSection.getWaiting() == 0);
	}
	
	@Test
	public void signUpGoesUp() {
		aSection.signUp();		
		assertTrue(aSection.getSignedUp() == 1);
		assertTrue(aSection.getWaiting() == 0);
		
		aSection.signUp();
		assertTrue(aSection.getSignedUp() == 2);
		assertTrue(aSection.getWaiting() == 0);
		
		aSection.signUp();
		assertTrue(aSection.getSignedUp() == 3);
		assertTrue(aSection.getWaiting() == 0);
		
		aSection.signUp();
		assertTrue(aSection.getSignedUp() == 3);
		assertTrue(aSection.getWaiting() == 1);
	}
	
	@Test
	public void waitListUsed() {
		
		aSection.signUp();
		aSection.signUp();
		aSection.signUp();
		assertTrue(aSection.getSignedUp() == 3);
		assertTrue(aSection.getWaiting() == 0);
		
		aSection.signUp();
		assertTrue(aSection.getSignedUp() == 3);
		assertTrue(aSection.getWaiting() == 1);
		
		aSection.signUp();
		assertTrue(aSection.getSignedUp() == 3);
		assertTrue(aSection.getWaiting() == 2);

		aSection.withdraw();
		assertTrue(aSection.getSignedUp() == 3);
		assertTrue(aSection.getWaiting() == 1);
		
		aSection.withdraw();
		
		assertTrue(aSection.getSignedUp() == 3);
		assertTrue(aSection.getWaiting() == 0);

		aSection.withdraw();
		
		assertTrue(aSection.getSignedUp() == 2);
		assertTrue(aSection.getWaiting() == 0);

	}

}
