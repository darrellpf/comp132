

import java.util.Comparator;

public class HockeyPlayer implements Comparable<HockeyPlayer> {
	private String firstName;
	private String lastName;
	private int goals;
	private int assists;

	public HockeyPlayer(String inFirst, String inLast) {
		firstName = inFirst;
		lastName = inLast;
		goals = 0;
		assists = 0;
	}

	public int getGoals() {
		return goals;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAssists() {
		return assists;
	}

	public int getTotalPoints() {
		return goals + assists;
	}


	@Override
	public boolean equals(Object thing) {
		HockeyPlayer other = (HockeyPlayer) thing;
		if (!firstName.equals(other.firstName)) {
			return false;
		}

		if (!lastName.equals(other.lastName)) {
			return false;
		}

		return true;
	}

	public void scoredGoal() {
		goals++;
	}

	public void scoredAssist() {
		assists++;
	}

	@Override
	public int compareTo(HockeyPlayer other) {
		int myTotalPoints = getTotalPoints();
		int otherTotalPoints = other.getTotalPoints();

		int difference = myTotalPoints - otherTotalPoints;
		return difference;
	}

	public static Comparator<HockeyPlayer> byLastNameFirstName() {
		return new Comparator<HockeyPlayer>() {

			@Override
			public int compare(HockeyPlayer a, HockeyPlayer b) {

				int difference = a.lastName.compareTo(b.lastName);

				if (difference != 0) {
					return difference;
				}
				difference = a.firstName.compareTo(b.firstName);
				return difference;
			}
		};
	}
	
	public static Comparator<HockeyPlayer> byFirstNameLastName() {
		return new Comparator<HockeyPlayer>() {

			@Override
			public int compare(HockeyPlayer a, HockeyPlayer b) {

				int difference = a.firstName.compareTo(b.firstName);

				if (difference != 0) {
					return difference;
				}
				difference = a.lastName.compareTo(b.lastName);
				return difference;
			}
		};
	}
}
