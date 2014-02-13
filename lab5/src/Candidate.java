import java.util.Comparator;


public class Candidate implements CandidateInterface {
	private String	firstName;
	private String	lastName;
	private int		voteCount;
	
	public Candidate(String inFirstName, String inLastName) {
		firstName	= inFirstName;
		lastName	= inLastName;
		voteCount	= 0;
	}
	
	public void addVote() {
		voteCount++;
	}
	
	public int getVoteCount() {
		return voteCount;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public boolean equals(Object what) {
		Candidate who = (Candidate) what;
		
		if( ! lastName.equals(who.lastName)) {
			return false;
		}
		
		if( ! firstName.equals(who.firstName)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int compareTo(CandidateInterface who) {
		int difference = voteCount - who.getVoteCount();
		
		if(difference != 0) {
			return difference;
		}
		
		difference = lastName.compareTo(who.getLastName());
		
		if(difference != 0) {
			return difference;
		}
		
		return firstName.compareTo(who.getFirstName());
	}
	
	@Override
	public String toString() {
		return
			"FirstName: " + firstName +
			" LastName: " + lastName +
			" VoteCount: " + voteCount;
	}
	
	public static Comparator<CandidateInterface> byLastName() {
		return new Comparator<CandidateInterface> () {
			@Override
			public int compare(CandidateInterface aa, CandidateInterface bb) {
				Candidate a = (Candidate) aa;
				Candidate b = (Candidate) bb;

				int difference = a.lastName.compareTo(b.lastName);
				
				if(difference != 0) {
					return difference;
				}
				
				difference = a.firstName.compareTo(b.firstName);
				
				return difference;
			}
		};
	}
}
