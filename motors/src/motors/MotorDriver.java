package motors;

import java.util.ArrayList;
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
		
		for(Motor someMotor : allMotors) {
			String serial = someMotor.getSerialNumber();
			System.out.println(serial);
		}
		
		System.out.println("***");
		Motor numberTwo = allMotors.get(2);
		System.out.println(numberTwo.getSerialNumber());
		
		int itemCount = allMotors.size();
		System.out.println("Size is " + itemCount);
		
		System.out.println("***");

		for(int i = 0; i < allMotors.size(); i++) {
			Motor anyMotor = allMotors.get(i);
			String serial = anyMotor.getSerialNumber();
			System.out.println(serial);
		}
	}

}
