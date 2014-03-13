package throwers;

public class Instructor implements InstructorInterface {
	private String nickName;
	private float totalMoneyRaised;
	private int dunks;
	
	public Instructor(String inNickName) {
		nickName = inNickName;
		totalMoneyRaised = 0;
		dunks = 0;
	}
	
	@Override
	public void addToMoneyRaised(float moreMoney) {
		totalMoneyRaised += moreMoney;
	}
	
	@Override
	public void wasDunked() {
		dunks++;
	}
	
	@Override
	public String getNickName() {
		return nickName;
	}
	
	@Override
	public float getTotalMoneyRaised() {
		return totalMoneyRaised;
	}
	
	@Override
	public int getDunks() {
		return dunks;
	}
	
	@Override
	public boolean equals(Object what) {
		Instructor other = (Instructor) what;
		
		return nickName.equals(other.nickName);
	}
	
	@Override
	public int compareTo(InstructorInterface other) {
		Float myMoneyRaised = totalMoneyRaised;
		Float yourMoneyRaised = other.getTotalMoneyRaised();
		
		return myMoneyRaised.compareTo(yourMoneyRaised);
	}
}
