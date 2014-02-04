
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class RidingTest {

	Riding aRiding;
	Candidate lowVotes;
	Candidate mediumVotes;
	Candidate highVotes;
	
	@Before
	public void setUp() throws Exception {
		aRiding = new Riding("Victoria");
		
		lowVotes = new Candidate("Barney", "Rubble");
		mediumVotes = new Candidate("Fred", "Flintstone");
		highVotes = new Candidate("Wilma", "Flintstone");
	}
	
	@Test
	public void constructorWorks() {
		String ridingName = aRiding.getName();
		assertTrue(ridingName.equals("Victoria"));
	}
	
	@Test
	public void votingWorks() {
		aRiding.addCandidate(mediumVotes);
		aRiding.addCandidate(lowVotes);
		aRiding.addCandidate(highVotes);
		
		CandidateInterface voteForMe = new Candidate("Fred", "Flintstone");
		
		for(int i = 0; i < 20; i++) {
			aRiding.voteFor(voteForMe);
		}
		
		voteForMe = new Candidate("Wilma", "Flintstone");
		
		for(int i = 0; i < 500; i++) {
			aRiding.voteFor(voteForMe);
		}
		
		voteForMe = new Candidate("Barney", "Rubble");
		
		for(int i = 0; i < 5; i++) {
			aRiding.voteFor(voteForMe);
		}
		
		assertTrue(aRiding.getWinner() == highVotes);
	}
	
	@Test
	public void iteratorWorks() {
		votingWorks();	// use the previous test to set up some of the test data
		
		Iterator<CandidateInterface> iter = aRiding.iterator();
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == highVotes);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == mediumVotes);
		
		assertTrue(iter.hasNext() == true);
		assertTrue(iter.next() == lowVotes);
		
		assertTrue(iter.hasNext() == false);
	}
	
	@Test
	public void iteratorByLastName() {
		Riding victoria = new Riding("Victoria");
		
		Candidate fred		= new Candidate("Fred", "Flintstone");
		Candidate wilma		= new Candidate("Wilma", "Flintstone");
		Candidate barney	= new Candidate("Barney", "Rubble");
		Candidate betty		= new Candidate("Betty", "Rubble");
		
		victoria.addCandidate(wilma);
		victoria.addCandidate(betty);
		victoria.addCandidate(barney);
		victoria.addCandidate(fred);


		Iterator<CandidateInterface> iter = victoria.byLastName();		

		assertTrue(iter.next() ==  fred);
		assertTrue(iter.next() ==  wilma);
		assertTrue(iter.next() ==  barney);
		assertTrue(iter.next() ==  betty);
		
		assertTrue(iter.hasNext() == false);
	}
}
