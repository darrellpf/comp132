
public class Section {
	private String name;
	private int	maximumStudents;
	private int signedUp;
	private int waiting;
	
	public Section(String inName, int inMaximum) {
		name = inName;
		maximumStudents = inMaximum;
		
		signedUp = 0;
		waiting = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaximumStudents() {
		return maximumStudents;
	}
	
	public int getSignedUp() {
		return signedUp;
	}
	
	public int getWaiting() {
		return waiting;
	}
	
	public void signUp() {
		if(signedUp == maximumStudents) {
			waiting++;
			return;
		}
			
		signedUp++;
	}
	
	public void withdraw() {
		if(signedUp <= 0) {
			return;
		}
		
		signedUp--;
		
		if(waiting > 0) {
			waiting--;
			signedUp++;
		}
	}
	
	public void withdrawFromWaitList() {
		if(waiting <= 0) {
			return;
		}
		
		waiting--;
	}
	
	public String toString() {
		String returnValue = "";
		
		returnValue += "Name: " + name;
		returnValue += " maximum: " + maximumStudents;
		returnValue += " signedUp: " + signedUp;
		returnValue += " waiting: " + waiting;
		
		return returnValue;
	}
}
