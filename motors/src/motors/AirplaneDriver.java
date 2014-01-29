package motors;

import java.util.Iterator;
import java.util.List;

public class AirplaneDriver {

	public static void main(String[] args) {
		Airplane myPlane = new Airplane("C-ZRTC");
		
		Motor aMotor = new Motor("AA", 100);
		
		myPlane.addMotor(aMotor);
		myPlane.addMotor(new Motor("BB", 100));
		
		
		myPlane.addFlyingHours(20);
		
		for(int i = 0; i < myPlane.getNumberOfMotors(); i++) {
			Motor someMotor = myPlane.getMotor(i);
			System.out.println(someMotor);
		}
		
		for(Motor someMotor : myPlane) {
			System.out.println(someMotor);
		}
		
		Iterator<Motor> secretary = myPlane.iterator();
		while(secretary.hasNext()) {
			Motor someMotor = secretary.next();
			System.out.println(someMotor);
		}
		
		List<Motor> planeMotors = myPlane.getAllMotors();
		
		for(Motor someMotor : planeMotors) {
			System.out.println(someMotor);
		}
		
		planeMotors.remove(0);
		
		System.out.println("After removal");
		
		for(Motor someMotor : myPlane) {
			System.out.println(someMotor);
		}
	}

}
