public interface CandidateInterface extends Comparable<CandidateInterface>{

	public void addVote();

	public int getVoteCount();

	public String getFirstName();

	public String getLastName();

}