package priceisright;

import java.util.List;

public abstract class AbstractGuessOnItem implements Iterable<Contestant>{
	
	protected ItemOnDisplay anItem;
	protected List<Contestant> allContestants;

	public abstract void guess(Contestant who, int amount);
	public abstract void guess(Contestant who, int amount, int previousLowestPrice);
	
	public abstract void comeOnDown(Contestant who);
	public abstract Contestant getWinner();
	public abstract int getLowestPrice();
	public abstract boolean wasExactGuess();
	public abstract List<Contestant> getUnsuccessful();
}