package bikes;

public class BikeDriver {

	public static void main(String[] args) {
		Bicycle myBike = new Bicycle(21);
		
		int gears = myBike.getGears();
		
		myBike.pedal();

	}

}
