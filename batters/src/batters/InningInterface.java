package batters;

import java.util.List;

public interface InningInterface extends Iterable<BatterInterface> {

	public int getInningNumber();

	public void addToLineup(Batter aBatter);

	public void batterUp();

	public void strikeCalled();

	public void ballCalled();

	public void foulCalled();

	public void fieldedOut();

	public int getOuts();

	public void scoredRun(BatterInterface looksLike);

	public int getTotalRuns();

	public boolean inningOver();

	public List<BatterInterface> byScoreName();

	public int getCurrentBatter();
}