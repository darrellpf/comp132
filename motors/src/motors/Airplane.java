package motors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Airplane implements Iterable<Motor> {
	private String tailNumber;
	private int totalFlyingHours;
	private List<Motor> allMotors;
	
	public Airplane(String inTailNumber) {
		tailNumber = inTailNumber;
		totalFlyingHours = 0;
		allMotors = new ArrayList<Motor>();
	}
	
	public int getTotalFlyingHours() {
		return totalFlyingHours;
	}
	
	public Iterator<Motor> iterator() {
		return allMotors.iterator();
	}
	
	public void addFlyingHours(int moreHours) {
		totalFlyingHours += moreHours;
		
		for(Motor aMotor : allMotors) {
			aMotor.addHoursOfService(moreHours);
		}
	
	}
	
	public void addMotor(Motor another) {
		allMotors.add(another);
	}
	
	public int getNumberOfMotors() {
		return allMotors.size();
	}
	
	public Motor getMotor(int position) {
		Motor retrieved = allMotors.get(position);
		return retrieved;
	}
	
	public void removeMotor(int position) {
		
		
		allMotors.remove(position);
	}
	
	public List<Motor> getAllMotors() {
		List<Motor> copyOfAllMotors = new ArrayList<Motor>(allMotors);


		return copyOfAllMotors;
	}
}
