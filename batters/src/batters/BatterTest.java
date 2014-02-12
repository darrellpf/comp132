package batters;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class BatterTest {
	
	private BatterInterface fred;

	@Before
	public void setUp() throws Exception {
		fred = new Batter("Fred", 2);
	}

	@Test
	public void initialized() {
		
		assertTrue(fred.getName().equals("Fred"));
		assertTrue(fred.getDidScore() == false);
		assertTrue(fred.getBallCount() == 0);
		assertTrue(fred.getStrikeCount() == 0);
		assertTrue(fred.getFoulCount() == 0);
		assertTrue(fred.getOrder() == 2);
		assertTrue(fred.getWasCalledOut() == false);
		assertTrue(fred.getWasOnBase() == false);
		assertTrue(fred.getWasWalked() == false);
	}
	
	@Test
	public void calledOut() {
		
		fred.wasCalledOut();
		
		assertTrue(fred.getWasCalledOut() == true);
		assertTrue(fred.getFinishedAtBat() == true);
		assertTrue(fred.getDidScore() == false);
	}
	
	@Test
	public void ballsGoUp() {
		fred.tookBall();	
		assertTrue(fred.getStrikeCount() == 0);
		assertTrue(fred.getBallCount() == 1);
		
		fred.tookBall();	
		assertTrue(fred.getStrikeCount() == 0);
		assertTrue(fred.getBallCount() == 2);
		
		fred.tookBall();	
		assertTrue(fred.getStrikeCount() == 0);
		assertTrue(fred.getBallCount() == 3);
		
		fred.tookBall();	
		assertTrue(fred.getStrikeCount() == 0);
		assertTrue(fred.getBallCount() == 4);
		
		assertTrue(fred.getWasOnBase() == true);
		assertTrue(fred.getFinishedAtBat() == true);
		assertTrue(fred.getWasWalked() == true);
		
		fred.tookBall();	
		assertTrue(fred.getStrikeCount() == 0);
		assertTrue(fred.getBallCount() == 4);
	}
	
	@Test
	public void strikesGoUp() {
		fred.tookStrike();	
		assertTrue(fred.getStrikeCount() == 1);
		assertTrue(fred.getBallCount() == 0);
		
		fred.tookStrike();	
		assertTrue(fred.getStrikeCount() == 2);
		assertTrue(fred.getBallCount() == 0);
		
		fred.tookStrike();	
		assertTrue(fred.getStrikeCount() == 3);
		assertTrue(fred.getBallCount() == 0);
		
		assertTrue(fred.getFinishedAtBat() == true);
		assertTrue(fred.getWasCalledOut() == true);
		
		fred.tookStrike();	
		assertTrue(fred.getStrikeCount() == 3);
		assertTrue(fred.getBallCount() == 0);	
	}
	
	@Test
	public void foulsGoUp() {
		fred.fouled();	
		assertTrue(fred.getStrikeCount() == 1);
		assertTrue(fred.getBallCount() == 0);
		assertTrue(fred.getFoulCount() == 1);
		
		fred.fouled();	
		assertTrue(fred.getStrikeCount() == 2);
		assertTrue(fred.getBallCount() == 0);
		assertTrue(fred.getFoulCount() == 2);
		
		fred.fouled();	
		assertTrue(fred.getStrikeCount() == 2);
		assertTrue(fred.getBallCount() == 0);
		assertTrue(fred.getFoulCount() == 3);
		
		assertTrue(fred.getFinishedAtBat() == false);
		
		fred.fouled();	
		assertTrue(fred.getStrikeCount() == 2);
		assertTrue(fred.getBallCount() == 0);
		assertTrue(fred.getFoulCount() == 4);
		
		assertTrue(fred.getFinishedAtBat() == false);
		
		fred.tookStrike();	
		assertTrue(fred.getStrikeCount() == 3);
		assertTrue(fred.getBallCount() == 0);
		assertTrue(fred.getFoulCount() == 4);
		
		assertTrue(fred.getFinishedAtBat() == true);
		assertTrue(fred.getWasCalledOut() == true);
		
		fred.tookStrike();	
		assertTrue(fred.getStrikeCount() == 3);
		assertTrue(fred.getBallCount() == 0);
	}
	
	@Test
	public void scored() {
		fred.didScore();
		
		assertTrue(fred.getDidScore() == true);
	}
	
	@Test
	public void equals() {
		BatterInterface a = new Batter("AA", 1);
		BatterInterface looksLikeA = new Batter("AA", 2);
		
		assertTrue(looksLikeA.equals(a));
		
		BatterInterface notA = new Batter("BB", 1);
		
		assertTrue( ! notA.equals(a));
	}
	
	@Test
	public void compareTo() {
		Batter smaller = new Batter("ZZ", 2);
		Batter larger = new Batter("AA", 9);
		
		assertTrue(smaller.compareTo(larger) < 0);
	}
	
	@Test
	public void comparator() {
		Comparator<BatterInterface> comp = Batter.byScoreName();
		
		Batter smallerScoreLast = new Batter("AA", 2);
		Batter largerScoreFirst = new Batter("ZZ", 9);
		largerScoreFirst.didScore();
		
		assertTrue(comp.compare(largerScoreFirst, smallerScoreLast) < 0);
		
		Batter sameScoreSmallerAlpha = new Batter("AA", 2);
		Batter sameScoreBiggerAlpha = new Batter("ZZ", 9);
		
		sameScoreSmallerAlpha.didScore();
		sameScoreBiggerAlpha.didScore();
		
		assertTrue(comp.compare(sameScoreSmallerAlpha, sameScoreBiggerAlpha) < 0);
	}

}
