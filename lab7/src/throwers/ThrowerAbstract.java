package throwers;

import java.util.Iterator;

public abstract class ThrowerAbstract implements Iterator<Integer>{

	protected String name;
	protected BallPurchase deal;

	public ThrowerAbstract(String inName, BallPurchase inDeal) {
		name = inName;
		deal = inDeal;
	}

	public String getName() {
		return name;
	}
	
	public abstract BallPurchase getBallPurchase();
	
	public abstract float getCostPerBall();
}