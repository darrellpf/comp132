public interface RidingInterface extends Iterable<CandidateInterface> {

	public String getName();

	public void addCandidate(CandidateInterface who);

	public void voteFor(CandidateInterface fakeWho);

	public CandidateInterface getWinner();

}