import java.util.Iterator;


public class ElectionDriver {

	public static void main(String[] args) {
		
		Riding victoria = new Riding("Victoria");
		victoria.addCandidate(new Candidate("Fred", "Flintstone"));
		victoria.addCandidate(new Candidate("Wilma", "Flintstone"));
		victoria.addCandidate(new Candidate("Barney", "Rubble"));
		victoria.addCandidate(new Candidate("Betty", "Rubble"));
		
		Candidate fakeFred		= new Candidate("Fred", "Flintstone");
		Candidate fakeWilma		= new Candidate("Wilma", "Flintstone");
		Candidate fakeBarney	= new Candidate("Barney", "Rubble");
		Candidate fakeBetty		= new Candidate("Betty", "Rubble");
		
		victoria.voteFor(fakeFred);
		victoria.voteFor(fakeFred);
		victoria.voteFor(fakeFred);

		victoria.voteFor(fakeWilma);
		victoria.voteFor(fakeWilma);
		victoria.voteFor(fakeWilma);
		victoria.voteFor(fakeWilma);
		
		victoria.voteFor(fakeBarney);

		victoria.voteFor(fakeBetty);
		victoria.voteFor(fakeBetty);
		victoria.voteFor(fakeBetty);
		
		CandidateInterface winner = victoria.getWinner();
		
		System.out.println("The winner of " + victoria.getName() +
				" is " + winner.getFirstName() + " " + winner.getLastName());
		
		System.out.println();
		
		for(CandidateInterface who : victoria) {
			System.out.println(who.getLastName() + ", " + who.getFirstName() + 
					" " + who.getVoteCount());
		}
		
		System.out.println();
		System.out.println("Candidates by last name");
		System.out.println();
		
		Iterator<CandidateInterface> iter = victoria.byLastName();		
		while(iter.hasNext()) {
			CandidateInterface who = iter.next();
			System.out.println(who.getLastName() + ", " + who.getFirstName() + 
					" " + who.getVoteCount());
		}
	}
}
