package batters;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class InningTest {
	
	private Batter aBatter;
	private Batter bBatter;
	private Batter cBatter;
	
	private Inning anInning;

	@Before
	public void setUp() throws Exception {
		aBatter = new Batter("AA", 1);
		bBatter = new Batter("BB", 2);
		cBatter = new Batter("CC", 3);
		
		anInning = new Inning(2);
		
		anInning.addToLineup(aBatter);
		anInning.addToLineup(bBatter);
		anInning.addToLineup(cBatter);
		
	}

	@Test
	public void initialized() {
		InningInterface middle = new Inning(5);
		
		assertTrue(middle.getInningNumber() == 5);
		
		assertTrue(middle.getOuts() == 0);
		assertTrue(middle.getTotalRuns() == 0);
		
		assertTrue(middle.inningOver() == false);
	}
	
	@Test
	public void outsGoesUp() {
		
		anInning.batterUp();	
		assertTrue(anInning.getCurrentBatter() == 1);
		anInning.strikeCalled();
		anInning.strikeCalled();
		anInning.strikeCalled();
	
		assertTrue(anInning.getOuts() == 1);
		assertTrue(anInning.getTotalRuns() == 0);
		
		anInning.batterUp();		
		assertTrue(anInning.getCurrentBatter() == 2);
		anInning.strikeCalled();
		anInning.strikeCalled();
		anInning.strikeCalled();
		
		assertTrue(anInning.getOuts() == 2);
		assertTrue(anInning.getTotalRuns() == 0);
		
		anInning.batterUp();		
		assertTrue(anInning.getCurrentBatter() == 3);
		anInning.strikeCalled();
		anInning.strikeCalled();
		anInning.strikeCalled();
		
		assertTrue(anInning.getOuts() == 3);
		assertTrue(anInning.getTotalRuns() == 0);
		
		assertTrue(anInning.inningOver() == true);
		
		assertTrue(anInning.getCurrentBatter() == 3);
		
		anInning.batterUp();
		assertTrue(anInning.inningOver() == true);
		assertTrue(anInning.getCurrentBatter() == 3);
	}
	
	@Test
	public void battersInOrder() {
		anInning = new Inning(2);
		
		anInning.addToLineup(bBatter);
		anInning.addToLineup(aBatter);
		anInning.addToLineup(cBatter);
		
		Iterator<BatterInterface> iter = anInning.iterator();
		
		assertTrue(iter.next() == aBatter);
		assertTrue(iter.next() == bBatter);
		assertTrue(iter.next() == cBatter);
	}
	
	@Test
	public void battersInScoringOrder() {
		anInning = new Inning(2);
		
		Batter dBatter = new Batter("DD", 1);
		Batter cBatter = new Batter("CC", 2);
		Batter bBatter = new Batter("BB", 3);
		Batter aBatter = new Batter("AA", 4);
		
		// should really play the game here
		// but will cheat and give runs early to be clear
		
		cBatter.didScore();
		aBatter.didScore();
		
		anInning.addToLineup(aBatter);
		anInning.addToLineup(bBatter);
		anInning.addToLineup(cBatter);
		anInning.addToLineup(dBatter);
		
		Iterator<BatterInterface> iter = anInning.byScoreName().iterator();
		
		assertTrue(iter.next() == aBatter);
		assertTrue(iter.next() == cBatter);
		assertTrue(iter.next() == bBatter);
		assertTrue(iter.next() == dBatter);
		
		assertTrue(anInning.getTotalRuns() == 2);
	}
	
	@Test
	public void noRunsAfterInningOver() {
		anInning.batterUp();
		anInning.fieldedOut();
		
		anInning.batterUp();
		anInning.fieldedOut();
		
		anInning.batterUp();
		anInning.fieldedOut();
		
		anInning.scoredRun(cBatter);
		
		assertTrue(anInning.getTotalRuns() == 0);
	}

}
