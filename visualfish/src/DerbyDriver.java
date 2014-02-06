
public class DerbyDriver {

public static void main(String[] args) {
	
	Derby sooke = new Derby("Sooke Classic");
	
	// register people for the derby
	
	sooke.add(new Fisher("Fred"));
	sooke.add(new Fisher("Barney"));
	sooke.add(new Fisher("Wilma"));
	
	// start fishing
	
	Fish tuna = new Fish(2000, "Tuna");
	
	Fisher fakeSomebody = new Fisher("Fred");
	
	sooke.addFish(tuna, fakeSomebody);
	
	sooke.addFish(new Fish(10, "Trout"), new Fisher("Wilma"));
	sooke.addFish(new Fish(100, "Bass"), new Fisher("Barney"));
	
	// horn sounds, time to find a winner
	
	Fisher winner = sooke.findWinner();
	
	System.out.println("Winner is: " + winner.getName());
	
	System.out.println("All Contestants");
	
	for(Fisher who : sooke) {
		Fish biggest = who.getBiggestFish();
		System.out.println(who.getName() + " " + biggest.getWeight());
	}
	}

}
