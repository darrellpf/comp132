package batters;

public interface BatterInterface extends Comparable<BatterInterface> {

	public String getName();

	public int getOrder();

	public void tookBall();

	public int getBallCount();

	public boolean getFinishedAtBat();

	public void tookStrike();

	public boolean getWasWalked();

	public int getStrikeCount();

	public void fouled();
	
	public void finishedAtBat();

	public int getFoulCount();

	public void wasCalledOut();

	public boolean getWasCalledOut();

	public void didScore();

	public void madeItOnBase();

	public boolean getDidScore();

	public boolean getWasOnBase();
}