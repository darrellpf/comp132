package batters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Inning implements InningInterface {
	private int inningNumber;
	private List<BatterInterface> allBatters;
	private int nextBatterUp;
	private int outs;
	private BatterInterface currentBatter;

	public Inning(int inInningNumber) {
		inningNumber = inInningNumber;
		allBatters = new ArrayList<BatterInterface>();
		nextBatterUp = 0;
		outs = 0;
		currentBatter = new Batter("",1);
	}

	@Override
	public int getInningNumber() {
		return inningNumber;
	}

	@Override
	public void addToLineup(Batter aBatter) {
		allBatters.add(aBatter);
		Collections.sort(allBatters);
	}

	@Override
	public void batterUp() {
		if (inningOver()) {
			return;
		}

		currentBatter = allBatters.get(nextBatterUp);
		nextBatterUp++;
	}

	@Override
	public void strikeCalled() {

		if (currentBatter.getFinishedAtBat() == true) {
			return;
		}

		currentBatter.tookStrike();

		if (currentBatter.getStrikeCount() == 3) {
			outs++;
		}
	}

	@Override
	public void ballCalled() {

		if (currentBatter.getFinishedAtBat() == true) {
			return;
		}

		currentBatter.tookBall();

		if (currentBatter.getBallCount() == 4) {
			currentBatter.madeItOnBase();
			currentBatter.finishedAtBat();
		}
	}

	@Override
	public void foulCalled() {
		if (currentBatter.getFoulCount() == 2) {
			return;
		}

		currentBatter.fouled();
	}

	@Override
	public void fieldedOut() {
		if (inningOver()) {
			return;
		}

		currentBatter.wasCalledOut();
		outs++;
	}

	@Override
	public int getOuts() {
		return outs;
	}

	@Override
	public void scoredRun(BatterInterface looksLike) {
		if (inningOver()) {
			return;
		}

		int position = allBatters.indexOf(looksLike);
		BatterInterface real = allBatters.get(position);
		real.didScore();
	}

	@Override
	public int getCurrentBatter() {
		return currentBatter.getOrder();
	}

	@Override
	public int getTotalRuns() {

		int runs = 0;

		for (BatterInterface who : allBatters) {
			if (who.getDidScore() == true) {
				runs++;
			}
		}

		return runs;
	}

	@Override
	public boolean inningOver() {
		return outs == 3;
	}

	@Override
	public Iterator<BatterInterface> iterator() {
		return allBatters.iterator();
	}

	@Override
	public List<BatterInterface> byScoreName() {
		Collections.sort(allBatters, Batter.byScoreName());
		return allBatters;
	}

}
