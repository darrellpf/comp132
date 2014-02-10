package batters;

public class BaseballDriver {

	public static void main(String[] args) {
		
		InningInterface first = new Inning(1);
		
		Batter fred = new Batter("Fred", 2);
		Batter barney = new Batter("Barney", 3);
		Batter wilma = new Batter("Wilma", 1);
		Batter bambam = new Batter("Bam-Bam", 4);
		
		first.addToLineup(fred);
		first.addToLineup(barney);
		first.addToLineup(wilma);
		first.addToLineup(bambam);
		
		first.batterUp();
		
		first.ballCalled();
		first.ballCalled();
		first.strikeCalled();
		first.strikeCalled();
		first.strikeCalled();
		
		first.batterUp();
		first.scoredRun(new Batter("Fred", 0));
		
		first.batterUp();
		first.ballCalled();
		first.fieldedOut();
		
		first.batterUp();
		first.strikeCalled();
		first.strikeCalled();
		first.ballCalled();
		first.strikeCalled();
		
		System.out.println("Player Balls Strikes Out Scored");
		System.out.println();
		
		for(BatterInterface who : first) {
			System.out.println(who.getName() + " " + who.getBallCount() + " " + who.getStrikeCount() + " " + who.getWasCalledOut() + " " + who.getDidScore());
		}
		
		System.out.println();
		System.out.println("Total runs for first team in inning " + first.getInningNumber() + " is " + first.getTotalRuns());
		
		System.out.println("Runs by player (ordered by runs, then alphabetical");
		System.out.println();
		
		for(BatterInterface who : first.byScoreName()) {
			System.out.println(who.getName()  + " " + who.getDidScore());
		}
	}

}
