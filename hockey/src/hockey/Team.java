package hockey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Team implements Iterable<HockeyPlayer>{
	private String name;
	private List<HockeyPlayer> allPlayers;
	
	public Team(String inName) {
		name = inName;
		allPlayers = new ArrayList<HockeyPlayer>();
	}
	
	public void add(HockeyPlayer who) {
		allPlayers.add(who);
	}
	
	public int getTotalPoints() {
		int totalPoints = 0;
		
		for(HockeyPlayer someone : allPlayers) {
			int points = someone.getTotalPoints();
			totalPoints += points;
		}
		
		return totalPoints;
	}
	
	public void scoredGoal(HockeyPlayer looksLike) {
		int location = allPlayers.indexOf(looksLike);
		HockeyPlayer foundPlayer = allPlayers.get(location);
	
		foundPlayer.scoredGoal();
	}
	
	public void scoredAssist(HockeyPlayer looksLike) {
		int location = allPlayers.indexOf(looksLike);
		HockeyPlayer foundPlayer = allPlayers.get(location);
	
		foundPlayer.scoredAssist();
	}

	@Override
	public Iterator<HockeyPlayer> iterator() {
		Collections.sort(allPlayers);
		Collections.reverse(allPlayers);
		return allPlayers.iterator();
	}
}
