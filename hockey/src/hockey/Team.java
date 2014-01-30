package hockey;

import java.util.ArrayList;
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
	
	public void scoredGoal(HockeyPlayer looksLike) {
		int location = allPlayers.indexOf(looksLike);
		HockeyPlayer foundPlayer = allPlayers.get(location);
	
		foundPlayer.scoredGoal();
	}

	@Override
	public Iterator<HockeyPlayer> iterator() {
		return allPlayers.iterator();
	}
}
