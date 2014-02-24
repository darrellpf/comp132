package throwers;

public interface InstructorInterface extends Comparable<InstructorInterface>{

	public void addToMoneyRaised(float moreMoney);
	public void wasDunked();
	public String getNickName();
	public float getTotalMoneyRaised();
	public int getDunks();
}