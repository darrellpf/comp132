package hockey;

import java.util.Iterator;
import java.util.List;



public class HockeyDriver {

	public static void main(String[] args) {
		Team myTeam = new Team("Canucks");
		
		myTeam.add(new HockeyPlayer("Henry", "Sedin"));
		myTeam.add(new HockeyPlayer("Roberto", "Luongo"));
		myTeam.add(new HockeyPlayer("Daniel", "Sedin"));

		for(HockeyPlayer who : myTeam) {
			System.out.println(who.getFirstName() + " " + who.getLastName());
		}
		
		myTeam.scoredGoal(new HockeyPlayer("Daniel", "Sedin"));

		int totalPoints = myTeam.getTotalPoints();
		
		myTeam.scoredGoal(new HockeyPlayer("Daniel", "Sedin"));
		myTeam.scoredGoal(new HockeyPlayer("Daniel", "Sedin"));

		myTeam.scoredAssist(new HockeyPlayer("Henry", "Sedin"));

		System.out.println("In order of points");
		
		for(HockeyPlayer who : myTeam) {
			System.out.println(who.getTotalPoints() + " " + who.getFirstName() + " " + who.getLastName());
		}
		
		System.out.println("Alphabetical");
		
		Iterator<HockeyPlayer> alpha = myTeam.iteratorByLastName();
		while(alpha.hasNext()) {
			HockeyPlayer who = alpha.next();
			System.out.println(who.getTotalPoints() + " " + who.getFirstName() + " " + who.getLastName());	
		}
		
		System.out.println("Alphabetical by list");
		
		for(HockeyPlayer who : myTeam.getPlayersByLastName()) {
			System.out.println(who.getTotalPoints() + " " + who.getFirstName() + " " + who.getLastName());		
		}
	}

}
