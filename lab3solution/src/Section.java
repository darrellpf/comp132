import java.util.ArrayList;
import java.util.List;


public class Section {
	private String name;
	private int	maximumStudents;
	
	private List<Student> signedUp;
	private List<Student> waiting;
	
	public Section(String inName, int inMaximum) {
		name = inName;
		maximumStudents = inMaximum;
		
		signedUp = new ArrayList<Student>();
		waiting = new ArrayList<Student>();
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaximumStudents() {
		return maximumStudents;
	}
	
	public int getSignedUpSize() {
		return signedUp.size();
	}
	
	public int getWaitingSize() {
		return waiting.size();
	}
	
	public void signUp(Student addStudent) {
		if(signedUp.size() == maximumStudents) {
			waiting.add(addStudent);
			return;
		}
			
		signedUp.add(addStudent);
	}
	
	public void withdraw(Student removeStudent) {
		if(signedUp.size() <= 0) {
			return;
		}
		
		int removePosition = positionOnSomeList(removeStudent, signedUp);
		signedUp.remove(removePosition);
		
		if(waiting.size() == 0) {
			return;
		}
		
		Student firstFromWaitList = waiting.get(0);
		waiting.remove(0);
		signedUp.add(firstFromWaitList);
	}
	
	public void withdrawFromWaitList(Student removeStudent) {
		if(waiting.size() <= 0) {
			return;
		}
		
		int waitingPosition = positionOnSomeList(removeStudent, waiting);
		waiting.remove(waitingPosition);
	}
	
	public int positionOnList(Student who) {
		return 1 + positionOnSomeList(who, signedUp);
	}
	
	public int positionOnWaitList(Student who) {
		return 1 + positionOnSomeList(who, waiting);
	}
	
	private int positionOnSomeList(Student looksLike, List<Student> someList) {
		String whoFirst = looksLike.getFirstName();
		String whoLast = looksLike.getLastName();
		
		for(int i = 0; i < someList.size(); i++) {
			
			Student onList = someList.get(i);
			
			String onListFirst = onList.getFirstName();
			if( ! whoFirst.equals(onListFirst)) {
				continue;
			}
			
			String onListLast = onList.getLastName();
			if( ! whoLast.equals(onListLast)) {
				continue;
			}
			
			return i;
		}	
		
		return -1;
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
