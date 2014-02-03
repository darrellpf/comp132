package hockey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDriver {

	public static void main(String[] args) {
		List<HockeyPlayer> allPlayers = new ArrayList<HockeyPlayer>();

		HockeyPlayer henry = new HockeyPlayer("Henry", "Sedin");
		henry.scoredGoal();
		henry.scoredGoal();
		
		allPlayers.add(henry);
		
		HockeyPlayer roberto = new HockeyPlayer("Roberto", "Luongo");
		roberto.scoredGoal();
		roberto.scoredGoal();
		roberto.scoredGoal();
		
		allPlayers.add(roberto);
		
		allPlayers.add(new HockeyPlayer("Daniel", "Sedin"));
		
		Comparator<HockeyPlayer> alternateSorter = new AlternateSort();
		Collections.sort(allPlayers, alternateSorter);

		for(HockeyPlayer who : allPlayers) {
			System.out.println(who.getTotalPoints() + " " + who.getFirstName() + " " + who.getLastName());
		}
	}

}
