package priceisright;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GuessOnItem extends AbstractGuessOnItem {
	
	public GuessOnItem(ItemOnDisplay inAnItem) {
		anItem = inAnItem;
		allContestants = new ArrayList<Contestant>();
	}
	
	public GuessOnItem(ItemOnDisplay inAnItem, List<Contestant> previousUnsuccessful) {
		anItem = inAnItem;
		allContestants = new ArrayList<Contestant>(previousUnsuccessful);
	}
	
	public void comeOnDown(Contestant who) {
		allContestants.add(who);
	}
	
	public void guess(Contestant looksLike, int amount) {
		int position = allContestants.indexOf(looksLike);
		Contestant real = allContestants.get(position);
		real.setAmount(amount);
	}
	
	public void guess(Contestant looksLike, int amount, int previousLowestPrice) {
		if(amount >= previousLowestPrice) {
			return;
		}
		
		guess(looksLike, amount);
	}
	
	public Contestant getWinner() {
		
		List<Contestant> copyOfContestants = new ArrayList<>(allContestants);
		
		Collections.sort(copyOfContestants);
		Collections.reverse(copyOfContestants);
		
		int price = anItem.getPrice();
		
		for(Contestant who : copyOfContestants) {
			if(who.getAmount() <= price) {
				return who;
			}
		}	
		
		return null;
	}
	
	public int getLowestPrice() {
		Contestant lowest = Collections.min(allContestants);
		return lowest.getAmount();
	}
	
	public boolean wasExactGuess() {
		Contestant winner = getWinner();
		if(winner == null) {
			return false;
		}
		
		int winnerAmount = winner.getAmount();
		int exactPrice = anItem.getPrice();
		
		return winnerAmount == exactPrice;
	}
	
	public List<Contestant> getUnsuccessful() {
		List<Contestant> losers = new ArrayList<Contestant>(allContestants);
		Contestant winner = getWinner();
		losers.remove(winner);
		return losers;
	}
	
	public Iterator<Contestant> iterator() {
		return allContestants.iterator();
	}
}
