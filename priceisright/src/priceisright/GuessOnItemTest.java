package priceisright;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GuessOnItemTest {
	
	private ItemOnDisplay car;
	private AbstractGuessOnItem firstItem;
	
	private Contestant alex;
	private Contestant bob;
	private Contestant charlie;
	private Contestant dave;

	@Before
	public void setUp() throws Exception {
		
		car = new ItemOnDisplay("New Car", 35000);
		firstItem = new GuessOnItem(car);
		
		alex = new Contestant("Alex");
		bob = new Contestant("Bob");
		charlie = new Contestant("Charlie");
		dave = new Contestant("Dave");
		
		firstItem.comeOnDown(alex);
		firstItem.comeOnDown(bob);
		firstItem.comeOnDown(charlie);
		firstItem.comeOnDown(dave);
		
		firstItem.guess(new Contestant("Alex"), 36000);
		firstItem.guess(new Contestant("Bob"), 37000);
		firstItem.guess(new Contestant("Charlie"), 38000);
		firstItem.guess(new Contestant("Dave"), 39000);
	}

	@Test
	public void allBidsRecordedInAddedOrder() {		
		
		Iterator<Contestant> iter = firstItem.iterator();		
		inSameOrder(iter, new Contestant[] {alex, bob, charlie, dave} );
	}
	
	@Test
	public void allBidsHighFirstRoundButWinnerSecondRound() {
		Contestant winner =  firstItem.getWinner();
		assertTrue(winner == null);
		
		int lowestGuess = firstItem.getLowestPrice();
		assertTrue(lowestGuess == 36000);
		
		firstItem.guess(new Contestant("Alex"), 99999, lowestGuess);

		firstItem.guess(new Contestant("Alex"), 15000, lowestGuess);
		
		assertTrue(alex.getAmount() == 15000);
		
		firstItem.guess(new Contestant("Bob"), 30001, lowestGuess);
		firstItem.guess(new Contestant("Charlie"), 35555, lowestGuess);
		firstItem.guess(new Contestant("Dave"), 30000, lowestGuess);
		
		inSameOrder(firstItem.iterator(), new Contestant[] {alex, bob, charlie, dave} );

		winner =  firstItem.getWinner();
		assertTrue(winner == bob);
		inSameOrder(firstItem.iterator(), new Contestant[] {alex, bob, charlie, dave} );
		
		assertTrue(firstItem.wasExactGuess() == false);
		
		List<Contestant> unsuccessful = firstItem.getUnsuccessful();
		Iterator<Contestant> iter = unsuccessful.iterator();
		
		inSameOrder(iter, new Contestant[] {alex, charlie, dave} );
				
		assertTrue(iter.hasNext() == false);
		
		assertTrue(isACompletelyIndependentCopy(firstItem, unsuccessful));
		
		GuessOnItem secondItem = new GuessOnItem(
				new ItemOnDisplay("Trunk", 60),
				firstItem.getUnsuccessful());
		
		iter = secondItem.iterator();
		inSameOrder(iter, new Contestant[] {alex, charlie, dave} );
	}
	
	@Test
	public void wasExactBeforeAnyGuesses() {
		assertTrue(firstItem.wasExactGuess() == false);
	}
	
	private boolean isACompletelyIndependentCopy(AbstractGuessOnItem anItem, List<Contestant> aCopy) {
		List<Contestant> preserveOriginal = new ArrayList<>();
		Iterator<Contestant> iter = anItem.iterator();
		while(iter.hasNext()) {
			preserveOriginal.add(iter.next());
		}
		
		aCopy.remove(0);
		
		iter = anItem.iterator();
		
		for(int i = 0; i < preserveOriginal.size(); i++) {
			assertTrue(preserveOriginal.get(i) == iter.next());
		}
		
		return true;
	}
	
	private void inSameOrder(Iterator<Contestant> firstIter, Contestant[] bList) {
		
		for(int i = 0; i < bList.length; i++) {		
			assertTrue(firstIter.next() == bList[i]);
		}
		
		assertTrue(firstIter.hasNext() == false);
	}
}
