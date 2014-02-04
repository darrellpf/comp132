
import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;
	
public class CandidateTest {
	
	Candidate who;

	@Before
	public void setUp() throws Exception {
		who = new Candidate("Jack", "Smith");
	}
	
	@Test
	public void constructorWorks() {
		String firstName = who.getFirstName();
		assertTrue(firstName.equals("Jack"));

		String lastName = who.getLastName();
		assertTrue(lastName.equals("Smith"));
		
		assertTrue(who.getVoteCount() == 0);
	}
	
	@Test
	public void addVoteWorks() {
		for(int i = 1; i <= 100; i++) {
			who.addVote();
			assertTrue(who.getVoteCount() == i);
		}
	}
	
	@Test
	public void equalsWorks() {
		assertTrue(who.equals(who));
		
		who.addVote();
		
		CandidateInterface similarToJackSmith = new Candidate("Jack", "Smith");
		assertTrue(who.equals(similarToJackSmith));
		
		CandidateInterface totallyDifferent = new Candidate("Fred", "Flintstone");
		assertTrue( ! who.equals(totallyDifferent));
		
		CandidateInterface firstNameDifferent = new Candidate("Matilda", "Smith");
		assertTrue( ! who.equals(firstNameDifferent));
		
		CandidateInterface lastNameDifferent = new Candidate("Jack", "Sprat");
		assertTrue( ! who.equals(lastNameDifferent));
	}
	
	@Test
	public void implementsComparable() {
		assertTrue(who instanceof Comparable);
	}
	
	@Test
	public void compareToWorks() {
		for(int i = 0; i < 10; i++) {
			who.addVote();
		}
		
		Candidate lessThanWho = new Candidate("Less", "Than");
		for(int i = 0; i < 6; i++) {
			lessThanWho.addVote();
		}
		
		Candidate greaterThanWho = new Candidate("Greater", "Than");
		for(int i = 0; i < 25; i++) {
			greaterThanWho.addVote();
		}
		
		assertTrue(who.compareTo(lessThanWho) == 4);
		assertTrue(lessThanWho.compareTo(who) == -4);
		
		assertTrue(who.compareTo(greaterThanWho) == -15);
		assertTrue(greaterThanWho.compareTo(who) == 15);
		
		Candidate sameVotesAsSmallerLastName = new Candidate("Jack", "Able");
		
		for(int i = 0; i < 10; i++) {
			sameVotesAsSmallerLastName.addVote();
		}
		
		assertTrue(who.compareTo(sameVotesAsSmallerLastName) > 0);
		assertTrue(sameVotesAsSmallerLastName.compareTo(who) < 0);
		
		Candidate sameVotesAsBiggerLastName = new Candidate("Jack", "Zigfried");
		
		for(int i = 0; i < 10; i++) {
			sameVotesAsBiggerLastName.addVote();
		}
		
		assertTrue(who.compareTo(sameVotesAsBiggerLastName) < 0);
		assertTrue(sameVotesAsBiggerLastName.compareTo(who) > 0);
		
		Candidate sameVotesSameLastSmallerFirstName = new Candidate("Abbie", "Smith");
		
		for(int i = 0; i < 10; i++) {
			sameVotesSameLastSmallerFirstName.addVote();
		}
		
		assertTrue(who.compareTo(sameVotesSameLastSmallerFirstName) > 0);
		assertTrue(sameVotesSameLastSmallerFirstName.compareTo(who) < 0);

		Candidate sameVotesSameLastLargerFirstName = new Candidate("Ziggy", "Smith");
		
		for(int i = 0; i < 10; i++) {
			sameVotesSameLastLargerFirstName.addVote();
		}
		
		assertTrue(who.compareTo(sameVotesSameLastLargerFirstName) < 0);
		assertTrue(sameVotesSameLastLargerFirstName.compareTo(who) > 0);
	}
	
	@Test
	public void comparatorByLastName() {
		Candidate aSmith = new Candidate("Able", "Smith");
		Candidate bSmith = new Candidate("Baker", "Smith");
		Candidate cSmith = new Candidate("Charlie", "Smith");
		
		Comparator<CandidateInterface> comp = Candidate.byLastName();
		
		assertTrue(comp.compare(aSmith, bSmith) < 0);
		assertTrue(comp.compare(bSmith, aSmith) > 0);
		
		assertTrue(comp.compare(bSmith, cSmith) < 0);
		assertTrue(comp.compare(cSmith, bSmith) > 0);
		
		assertTrue(comp.compare(aSmith, cSmith) < 0);
		assertTrue(comp.compare(cSmith, aSmith) > 0);
	}

}
