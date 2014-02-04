package fishing;

public class FishDriver {

	public static void main(String[] args) {
		Derby registrationDesk = new Derby("Sooke Classic 2014");

		// registration
		
		Bucket fred = new Bucket("Fred", "Flintstone");
		registrationDesk.register(fred);
		
	}

}
