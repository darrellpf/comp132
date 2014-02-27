package batters;

import java.util.Comparator;

public class Batter implements BatterInterface {
	private String name;
	private int order;
	
	private int balls;
	private int strikes;
	private int fouls;
	
	private boolean walked;
	private boolean calledOut;
	private boolean wasOnBase;
	private boolean scored;
	private boolean finishedAtBat;
	
	public Batter(String inName, int inOrder) {
		name = inName;
		order = inOrder;
		balls = 0;
		strikes = 0;
		fouls = 0;
		walked = false;
		calledOut = false;
		wasOnBase = false;
		scored = false;
		finishedAtBat = false;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getOrder() {
		return order;
	}
	
	@Override
	public void tookBall() {
		if(finishedAtBat == true) {
			return;
		}
		
		balls++;
		
		if(balls == 4) {
			walked = true;
			finishedAtBat = true;
			wasOnBase = true;
		}
	}
	
	@Override
	public int getBallCount() {
		return balls;
	}
	
	@Override
	public boolean getFinishedAtBat() {
		return finishedAtBat;
	}
	
	@Override
	public void tookStrike() {
		if(finishedAtBat == true) {
			return;
		}
		
		strikes++;
		
		if(strikes == 3) {
			calledOut = true;
			finishedAtBat = true;
		}
	}
	
	@Override
	public boolean getWasWalked() {
		return walked;
	}
	
	@Override
	public int getStrikeCount() {
		return strikes;
	}
	
	@Override
	public void fouled() {
		if(finishedAtBat == true) {
			return;
		}
		
		fouls++;
		
		if(strikes == 2) {
			return;
		}
		
		strikes++;
	}
	
	@Override
	public int getFoulCount() {
		return fouls;
	}
	
	@Override
	public void wasCalledOut() {
		calledOut = true;
		finishedAtBat = true;
	}
	
	@Override
	public boolean getWasCalledOut(){
		return calledOut;
	}
	
	@Override
	public void didScore() {
		scored = true;
	}
	
	@Override
	public void madeItOnBase() {
		wasOnBase = true;
	}
	
	@Override
	public boolean getDidScore() {
		return scored;
	}
	
	@Override
	public boolean getWasOnBase() {
		return wasOnBase;
	}
	
	@Override
	public void finishedAtBat() {
		finishedAtBat = true;
	}
	
	@Override
	public boolean equals(Object what) {
		Batter other = (Batter) what;
		return name.equals(other.name);
	}
	
	@Override
	public int compareTo(BatterInterface other) {
		return order - other.getOrder();
	}
	
	public static Comparator<BatterInterface> byScoreName() {
		return new Comparator<BatterInterface>() {

			@Override
			public int compare(BatterInterface a, BatterInterface b) {
				int aScore = 0;
				if(a.getDidScore() == true) {
					aScore = +1;
				}
				
				int bScore = 0;
				if(b.getDidScore() == true) {
					bScore = +1;
				}
				
				int difference = bScore - aScore; // reverse order
				if(difference != 0) {
					return difference;
				}
				
				String aName = a.getName();
				String bName = b.getName();
				
				difference = aName.compareTo(bName);
				
				return difference;
			}
			
		};
	}
}
