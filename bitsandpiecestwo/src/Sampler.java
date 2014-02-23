import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sampler {

	public static final int PEOPLE_ON_TEAM = 12;
	public static final int EGGS_PER_DOZEN = 12;

	private static final int DIRECTION_NORTH = 0;
	private static final int DIRECTION_EAST = 1;
	private static final int DIRECTION_SOUTH = 2;
	private static final int DIRECTION_WEST = 3;

	enum Directions {
		NORTH, EAST, SOUTH, WEST
	};

	public static void main(String[] args) {

		int eggsPerDozen = 12;
		int peopleOnTeam = 12;

		int peopleSoFar = 6;
		int eggsInHand = 3;

		if (peopleSoFar == PEOPLE_ON_TEAM) {
			System.out.println("Full team here");
		}

		peopleOnTeam = 4;
		// PEOPLE_ON_TEAM = 56;

		if (eggsInHand == EGGS_PER_DOZEN) {
			System.out.println("got eggs needed");
		}

		int currentDirection = 56;

		switch (currentDirection) {
		case DIRECTION_NORTH:
			System.out.println("Heading north");
			break;

		case DIRECTION_EAST:
			System.out.println("Heading east");
			break;

		case DIRECTION_SOUTH:
			System.out.println("Heading south");
			break;

		case DIRECTION_WEST:
			System.out.println("Heading west");
			break;

		default:
			System.out.println("not valid direction");
		}

		Directions aDirection = Directions.WEST;
		// aDirection = 56;

		switch (aDirection) {
		case NORTH:
			System.out.println("Heading north");
			break;

		case EAST:
			System.out.println("Heading east");
			break;

		case SOUTH:
			System.out.println("Heading south");
			break;

		case WEST:
			System.out.println("Heading west");
			break;

		default:
			System.out.println("not valid direction");
		}

		for (Directions someDirection : Directions.values()) {
			System.out.println(someDirection);
		}

		String selection = "Fred";

		switch (selection) {

		case "Joe":
			System.out.println("This is Joe");
			break;

		case "Fred":
			System.out.println("This is Fred");
			break;

		default:
			System.out.println("This is nobody");
			break;
		}

		// arrays

		int[] grades = new int[4];

		grades[0] = 57;
		int nextAvailableGradesSlot = 1;

		// grades[43] = 5;

		System.out.println(grades.length);

		for (int i = 0; i < nextAvailableGradesSlot; i++) {
			System.out.println(grades[i]);
		}

		for (int anInt : grades) {
			System.out.println(anInt);
		}

		int[] numbers = { 5, -4, 6, 23 };

		for (int anInt : numbers) {
			System.out.println(anInt);
		}

		String[] someNames = { "Fred", "Sam", "Joe" };

		for (String aName : someNames) {
			System.out.println(aName);
		}

		Fish[] allFish = { new Fish(20, "Carp"), new Fish(32, "Salmon"),
				new Fish(20, "Carp"), };

		List<Fish> fishies = new ArrayList<Fish>();

		for (Fish aFish : allFish) {
			fishies.add(aFish);
		}

		List<Fish> moreFishies = new ArrayList<Fish>(Arrays.asList(allFish));
	}
}
