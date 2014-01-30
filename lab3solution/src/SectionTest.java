
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SectionTest {
	
	private Section aSection;
	
	private Student aStudent;
	private Student bStudent;
	private Student cStudent;
	private Student dStudent;
	private Student eStudent;

	@Before
	public void setUp() throws Exception {
		aSection = new Section("Comp132", 3);
		
		aStudent = new Student("AFirst", "ALast", 20);
		bStudent = new Student("BFirst", "BLast", 20);
		cStudent = new Student("CFirst", "CLast", 20);
		dStudent = new Student("DFirst", "DLast", 20);
		eStudent = new Student("EFirst", "ELast", 20);
	}
	
	@Test
	public void initialize() {
		String name = aSection.getName();
		assertTrue(name.equals("Comp132"));		
		
		assertTrue(aSection.getMaximumStudents() == 3);
		
		assertTrue(aSection.getSignedUpSize() == 0);
		assertTrue(aSection.getWaitingSize() == 0);
	}
	
	@Test
	public void positionOnList() {
		aSection.signUp(aStudent);
		aSection.signUp(bStudent);
		aSection.signUp(cStudent);
		
		int position = aSection.positionOnList(aStudent);
		assertTrue(position == 1);
		
		position = aSection.positionOnList(bStudent);
		assertTrue(position == 2);
		
		position = aSection.positionOnList(cStudent);
		assertTrue(position == 3);
		
		position = aSection.positionOnList(dStudent);
		assertTrue(position == 0);

	}
	
	@Test
	public void signUpGoesUp() {
		aSection.signUp(aStudent);		
		assertTrue(aSection.getSignedUpSize() == 1);
		assertTrue(aSection.getWaitingSize() == 0);
		assertTrue(aSection.positionOnList(aStudent) == 1);
		
		aSection.signUp(bStudent);
		assertTrue(aSection.getSignedUpSize() == 2);
		assertTrue(aSection.getWaitingSize() == 0);
		assertTrue(aSection.positionOnList(aStudent) == 1);
		assertTrue(aSection.positionOnList(bStudent) == 2);
		
		aSection.signUp(cStudent);
		assertTrue(aSection.getSignedUpSize() == 3);
		assertTrue(aSection.getWaitingSize() == 0);
		assertTrue(aSection.positionOnList(aStudent) == 1);
		assertTrue(aSection.positionOnList(bStudent) == 2);
		assertTrue(aSection.positionOnList(cStudent) == 3);
		
		aSection.signUp(dStudent);
		assertTrue(aSection.getSignedUpSize() == 3);
		assertTrue(aSection.getWaitingSize() == 1);
		assertTrue(aSection.positionOnList(aStudent) == 1);
		assertTrue(aSection.positionOnList(bStudent) == 2);
		assertTrue(aSection.positionOnList(cStudent) == 3);
		assertTrue(aSection.positionOnWaitList(dStudent) == 1);
		}
	
	@Test
	public void waitListUsed() {
		
		aSection.signUp(aStudent);
		aSection.signUp(bStudent);
		aSection.signUp(cStudent);
		assertTrue(aSection.getSignedUpSize() == 3);
		assertTrue(aSection.getWaitingSize() == 0);
		
		aSection.signUp(dStudent);
		assertTrue(aSection.getSignedUpSize() == 3);
		assertTrue(aSection.getWaitingSize() == 1);
		
		aSection.signUp(eStudent);
		assertTrue(aSection.getSignedUpSize() == 3);
		assertTrue(aSection.getWaitingSize() == 2);

		aSection.withdraw(bStudent);
		assertTrue(aSection.getSignedUpSize() == 3);
		assertTrue(aSection.getWaitingSize() == 1);
		
		aSection.withdraw(cStudent);
		
		assertTrue(aSection.getSignedUpSize() == 3);
		assertTrue(aSection.getWaitingSize() == 0);

		aSection.withdraw(aStudent);
		
		assertTrue(aSection.getSignedUpSize() == 2);
		assertTrue(aSection.getWaitingSize() == 0);
		
		assertTrue(aSection.positionOnList(dStudent) == 1);
		assertTrue(aSection.positionOnList(eStudent) == 2);

	}

}
