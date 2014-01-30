package hockey;

public class HockeyPlayer {
	private String firstName;
	private String lastName;
	private int goals;
	
	public HockeyPlayer(String inFirst, String inLast) {
		firstName = inFirst;
		lastName = inLast;
		goals = 0;
	}
	
	public int getGoals() {
		return goals;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public boolean equals(Object thing) {
		HockeyPlayer other = (HockeyPlayer) thing;
		if( ! firstName.equals(other.firstName)) {
			return false;
		}
		
		if( ! lastName.equals(other.lastName)) {
			return false;
		}
		
		return true;
	}
	
	public void scoredGoal() {
		goals++;
	}
}
