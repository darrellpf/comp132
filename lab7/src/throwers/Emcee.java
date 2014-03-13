package throwers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static throwers.BallPurchase.*;

public class Emcee extends EmceeAbstract {
	
	private List<InstructorInterface> victims;

	public Emcee() {
		victims = new ArrayList<>();
		currentThrower = new Thrower("", NONE);
		currentVictim = new Instructor("");
	}

	@Override
	public ThrowerAbstract getCurrentThrower() {
		return currentThrower;
	}

	@Override
	public InstructorInterface getCurrentVictim() {
		return currentVictim;
	}

	@Override
	public void throwerStepsUp(ThrowerAbstract nextThrower) {
		currentThrower = nextThrower;
	}

	@Override
	public void throwerChoosesVictim(InstructorInterface victim) {
		int position = victims.indexOf(victim);
		if (position == -1) {
			victims.add(victim);
			currentVictim = victim;
			return;
		}

		currentVictim = victims.get(position);
	}

	@Override
	public boolean throwAnother() {
		if (currentThrower.hasNext() == false) {
			return false;
		}

		currentThrower.next();

		BallPurchase aPurchase = currentThrower.getBallPurchase();
		float fundsPayed = aPurchase.getCostPerBall();
		currentVictim.addToMoneyRaised(fundsPayed);
		return true;
	}

	@Override
	public void dunked() {
		currentVictim.wasDunked();
	}

	@Override
	public Iterator<InstructorInterface> iterator() {
		Collections.sort(victims);
		Collections.reverse(victims);
		return victims.iterator();
	}
	
	@Override
	public List<InstructorInterface> byDunks() {
		List<InstructorInterface> returnList = new ArrayList<>(victims);
		
		Collections.sort(returnList, new Comparator<InstructorInterface>() {

			@Override
			public int compare(InstructorInterface a, InstructorInterface b) {
				int aDunks = a.getDunks();
				int bDunks = b.getDunks();
				
				int difference = bDunks - aDunks;
				
				if(difference != 0) {
					return difference;
				}
				
				return a.getNickName().compareTo(b.getNickName());
			} });
		
		
		return returnList;
	}

	@Override
	public float getTotalFundsRaised() {
		float total = 0.0F;

		for (InstructorInterface who : victims) {
			total += who.getTotalMoneyRaised();
		}

		return total;
	}
}
