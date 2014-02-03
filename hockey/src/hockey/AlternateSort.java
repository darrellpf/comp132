package hockey;

import java.util.Comparator;

public class AlternateSort implements Comparator<HockeyPlayer>{

	@Override
	public int compare(HockeyPlayer a, HockeyPlayer b) {
		String aLastName = a.getLastName();
		String bLastName = b.getLastName();
		
		int difference = aLastName.compareTo(bLastName);
		
		if(difference != 0 ) {
			return difference;
		}
		
		String aFirstName = a.getFirstName();
		String bFirstName = b.getFirstName();
		
		difference = aFirstName.compareTo(bFirstName);
		return difference;
	}

}
