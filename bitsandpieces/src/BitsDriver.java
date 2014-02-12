import java.util.ArrayList;
import java.util.List;


public class BitsDriver {

	public static void main(String[] args) {

		HockeyPlayer fred = new HockeyPlayer("Fred", "Flint");
		
		HockeyPlayer freddy = new HockeyPlayer("Fred", "Flint");
		
		
		if(fred == freddy) {
			System.out.println("Same 1");
		}
		
		HockeyPlayer thing = fred;
		if(thing.equals(freddy)) {
			System.out.println("Same 2");
		}
		
		List<HockeyPlayer> players = new ArrayList<HockeyPlayer>();
		players.add(fred);
		players.add(freddy);
		
		int position = players.indexOf(new HockeyPlayer("Fred", "Flint"));
		System.out.println(position);
		
		/////
	
		String a = "aa";
		String otherA = "aa";
		
		if(a.equals(otherA)) {
			System.out.println("Same 3");
		}
		
		if(a == otherA) {
			System.out.println("Same 4");
		}
		
		String newA = new String("aa");
		
		if(a == newA) {
			System.out.println("Same 5");
		}
		
		a += "b";
		otherA += "b";
		
		if(a == otherA) {
			System.out.println("Same 6");
		}
	}

}
