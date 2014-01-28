import java.util.Iterator;

																																		
public class RaceSampleUsage {

	public static void main(String[] args) {
		Race indy = new Race("Indianapolis 500", 500);
		
		indy.add(new RaceCar("Billy-Billy", 23));
		indy.add(new RaceCar("Billy-Joe", 17));
		indy.add(new RaceCar("Billy-Mae", 40));
		indy.add(new RaceCar("Billy-Bob", 12));
		
		System.out.println("Gentlemen, start your engines");
		
		indy.addLap(40);
		indy.addLap(12);
		indy.addLap(23);
		indy.addLap(23);
		indy.addLap(12);
		
		indy.disqualify(17);
		
		for(int i = 0; i < 500; i++) {
			indy.addLap(12);
			indy.addLap(40);
		}
		
		indy.disqualify(23);
		
		System.out.println("Race is finished.");
		
		System.out.print("The winner of the " + indy.getName() +
				" race of " + indy.getLapsInRace() + " laps is ");
		
		RaceCarInterface winner = indy.findFinishPosition(1);
		
		System.out.println(winner.getDriverName() + "" +
				" in car number " + winner.getCarNumber());
		
		System.out.println();
		System.out.println("The finishers in race were");
		System.out.println();
		
		System.out.println("Name Number Position Laps");
		
		for(RaceCarInterface aCar : indy) {
			if(aCar.isDisqualified()) {
				continue;
			}
			
			System.out.println(aCar.getDriverName() + " " + aCar.getCarNumber() +
					" " + aCar.getFinishPosition() + " " + aCar.getLapsCompleted());
		}
		
		Iterator<RaceCar> retriever = indy.iterator();
		
		while(retriever.hasNext()) {
			RaceCar nextCar = retriever.next();
			System.out.println(nextCar.getDriverName());
		}
		
		System.out.println();
		RaceCarInterface favorite = indy.findRacer(new RaceCar("Billy-Billy", 0));
		System.out.println("The favorite " + favorite.getDriverName() +
				" finished " + favorite.getLapsCompleted() + " laps.");
		
		
		
	}

}
