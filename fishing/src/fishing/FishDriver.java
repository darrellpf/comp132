package fishing;

public class FishDriver {

	public static void main(String[] args) {
		Derby registrationDesk = new Derby("Sooke Classic 2014");

		// registration
		
		Bucket fred = new Bucket("Fred", "Flintstone");
		registrationDesk.register(fred);
		

		registrationDesk.register(new Bucket("Barney", "Rubble"));
		registrationDesk.register(new Bucket("Wilma", "Flintstone"));
		
		
		// catch fish
		
		Fish aFish = new Fish(20, "Tuna");
		
		Bucket matchingBucket = new Bucket("Barney", "Rubble");
		
		registrationDesk.addFish(aFish, matchingBucket);
		
		registrationDesk.addFish(new Fish(30, "Tuna"), new Bucket("Barney", "Rubble"));
		registrationDesk.addFish(new Fish(40, "Tuna"), new Bucket("Wilma", "Flintstone"));
		registrationDesk.addFish(new Fish(55, "Tuna"), new Bucket("Fred", "Flintstone"));
		registrationDesk.addFish(new Fish(10, "Tuna"), new Bucket("Fred", "Flintstone"));
		
		// derby over
		
		Bucket winner = registrationDesk.getWinner();
		
		System.out.println("Winner is " + winner.getFirstName() + " " + winner.getLastName());
		Fish biggest = winner.getBiggestFish();
		System.out.println("With a " + biggest.getWeight() + " " + biggest.getType());
	}

}
