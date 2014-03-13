package throwers;

public class Thrower extends ThrowerAbstract {
	
	private int softballsLeft;

	public Thrower(String inName, BallPurchase inDeal) {
		super(inName, inDeal);
		softballsLeft = inDeal.getBalls();
	}

	@Override
	public boolean hasNext() {
		if (softballsLeft == 0) {
			return false;
		}

		return true;
	}

	@Override
	public Integer next() {
		int oldSoftballsLeft = softballsLeft;

		softballsLeft--;

		return oldSoftballsLeft;
	}

	@Override
	public BallPurchase getBallPurchase() {
		return deal;
	}
	
	@Override
	public float getCostPerBall() {
		return deal.getCostPerBall();
	}
}
