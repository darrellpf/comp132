import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Riding implements RidingInterface {
	private String name;
	private ArrayList<CandidateInterface> allCandidates;
	
	public Riding(String inName) {
		name	= inName;
		allCandidates = new ArrayList<CandidateInterface>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addCandidate(CandidateInterface who) {
		allCandidates.add(who);
	}
	
	public void voteFor(CandidateInterface fakeWho) {
		int position	= allCandidates.indexOf(fakeWho);
		CandidateInterface who	= allCandidates.get(position);
		who.addVote();
	}
	
	public CandidateInterface getWinner() {
		return Collections.max(allCandidates);
	}
	
	public Iterator<CandidateInterface> iterator() {
		Collections.sort(allCandidates);
		Collections.reverse(allCandidates);
		return allCandidates.iterator();
	}
	
	public Iterator<CandidateInterface> byLastName() {
		Collections.sort(allCandidates, Candidate.byLastName());
		return allCandidates.iterator();
		
	}
	
	@Override
	public String toString() {
		return
			"Name: " + name +
			" Candidates: " + allCandidates;
	}
}
