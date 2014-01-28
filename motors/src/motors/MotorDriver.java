package motors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MotorDriver {

	public static void main(String[] args) {
		Motor aMotor = new Motor("A", 10);
		aMotor.addHoursOfService(6);

		Motor bMotor = new Motor("B", 5);
		bMotor.addHoursOfService(9);

		Motor cMotor = new Motor("C", 8);
		cMotor.addHoursOfService(4);

		List<Motor> allMotors = new ArrayList<Motor>();

		allMotors.add(aMotor);
		allMotors.add(bMotor);
		allMotors.add(cMotor);

		for (Motor someMotor : allMotors) {
			String serial = someMotor.getSerialNumber();
			System.out.println(serial);
		}

		System.out.println("***");
		Motor numberTwo = allMotors.get(2);
		System.out.println(numberTwo.getSerialNumber());

		int itemCount = allMotors.size();
		System.out.println("Size is " + itemCount);

		System.out.println("***");

		cMotor.addHoursOfService(300);

		cMotor = null;

		for (int i = 0; i < allMotors.size(); i++) {
			Motor anyMotor = allMotors.get(i);
			int hours = anyMotor.getHoursOfService();
			System.out.println(hours);
		}

		// Only > 8 hours service

		for (Motor someMotor : allMotors) {
			if (someMotor.getHoursOfService() > 8
					&& someMotor.getHoursOfService() < 32) {
				System.out.println(someMotor.getHoursOfService());
			}
		}

		for (Motor xMotor : allMotors) {
			int hours = xMotor.getHoursOfService();

			if (hours <= 8) {
				continue;
			}

			if (hours >= 32) {
				continue;
			}

			System.out.println(hours);
		}

		// add all items > 20 hours to a list

		List<Motor> needsWork = new ArrayList<Motor>();

		for (Motor anyMotor : allMotors) {
			int hours = anyMotor.getHoursOfService();
			if (hours <= 20) {
				continue;
			}

			needsWork.add(anyMotor);
		}

		for (Motor work : needsWork) {
			System.out.println(work.getSerialNumber());
		}

		// find a motor that has most hours

		Motor biggestMotorSoFar = allMotors.get(0);

		for (int i = 1; i < allMotors.size(); i++) {
			Motor nextOne = allMotors.get(i);

			int difference = nextOne.compareTo(biggestMotorSoFar);
				
			if (difference > 0) {
				biggestMotorSoFar = nextOne;
			}
		}
		
		Motor actualBiggest = biggestMotorSoFar;
		
		System.out.println("Worst is " + actualBiggest);
		
		Motor biggest = Collections.max(allMotors);
		System.out.println("Worst is " + biggest);
		
		Motor smallest = Collections.min(allMotors);
		System.out.println("Smallest is " + smallest);

		Collections.sort(allMotors);
		Collections.reverse(allMotors);
		
		System.out.println(allMotors);
		
		// search for an item
		
		String serialToFind  = "B";
		
		for (Motor someMotor : allMotors) {
			String serial = someMotor.getSerialNumber();
			if(serialToFind.equals(serial)) {
				System.out.println(serial);
				break;
			}

		}
		
		Motor fakeMotor = new Motor("B", 0);
		Motor foundMotor = null;
		
		for(Motor someMotor : allMotors) {
			if(fakeMotor.equals(someMotor)) {
				foundMotor = someMotor;
				break;
			}
		}
		
		System.out.println("Found " + foundMotor);
		
		int positionOnList = allMotors.indexOf(fakeMotor);
		Motor theOneIWant = allMotors.get(positionOnList);
		System.out.println("Found another " + theOneIWant);

		
		Iterator<Motor> secretary = allMotors.iterator();
		
		while(secretary.hasNext()) {
			Motor someMotor = secretary.next();
			System.out.println(someMotor);
		}
		
		for(Motor someMotor : allMotors) {
			System.out.println(someMotor);			
		}
	}

}
