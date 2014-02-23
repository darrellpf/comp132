package throwers;

import static throwers.BallPurchase.*;

public class DunkDriver {

	public static void main(String[] args) {
		EmceeAbstract dunkTank = new Emcee();

		Thrower fred = new Thrower("StudentA", FIVE_FOR_FIFTEEN);

		dunkTank.throwerStepsUp(fred);
		dunkTank.throwerChoosesVictim(new Instructor("DrillSargeant"));

		while (dunkTank.throwAnother()) {
			dunkTank.dunked();
		}

		Thrower sam = new Thrower("StudentB", FIVE_FOR_FIFTEEN);
		dunkTank.throwerStepsUp(sam);
		dunkTank.throwerChoosesVictim(new Instructor("Comp170"));

		while (dunkTank.throwAnother()) {
			dunkTank.dunked();
		}

		Thrower joe = new Thrower("StudentC", FIVE_FOR_FIFTEEN);
		dunkTank.throwerStepsUp(joe);
		dunkTank.throwerChoosesVictim(new Instructor("Comp170"));

		dunkTank.throwAnother();
		dunkTank.dunked();
		dunkTank.throwAnother();
		dunkTank.throwAnother();

		System.out.println("Instructor Money Dunks");
		System.out.println("----------------------");

		for (InstructorInterface who : dunkTank) {
			System.out.println(who.getNickName() + "\t" + who.getTotalMoneyRaised()
					+ "\t" + who.getDunks());
		}
		System.out.println("----------------------");

		System.out.println();
		System.out.println("Total money raised is "
				+ dunkTank.getTotalFundsRaised());
		
		System.out.println();
		System.out.println("Most dunked");
		System.out.println();
		System.out.println("Instructor Money Dunks");
		System.out.println("----------------------");

		for (InstructorInterface who : dunkTank.byDunks()) {
			System.out.println(who.getNickName() + "\t" + who.getTotalMoneyRaised()
					+ "\t" + who.getDunks());
		}
	}
}
