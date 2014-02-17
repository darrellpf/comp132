package midterm1;

public class BundleMaker {
	private int maximumSize;
	private int numberMade;
	private int requiredAmount;
	private int partialSize;
	private boolean hasStarted;
	private boolean hasFinished;

	public BundleMaker(int inMaximumSize) {
		maximumSize = inMaximumSize;
		numberMade = 0;
		requiredAmount = 0;
		partialSize = 0;
		hasStarted = false;
		hasFinished = false;
	}

	public BundleMaker(int inMaximumSize, int inRequiredAmount) {
		maximumSize = inMaximumSize;
		numberMade = 0;
		requiredAmount = inRequiredAmount;
		partialSize = 0;
		hasStarted = false;
	}

	public void tick() {
		if (hasFinished == true) {
			return;
		}

		if (hasStarted == false) {
			return;
		}

		partialSize++;

		if (partialSize == maximumSize) {
			numberMade++;
			partialSize = 0;
		}

		if (requiredAmount == 0) {
			return;
		}

		if (numberMade == requiredAmount) {
			hasFinished = true;
			return;
		}
	}

	public void reset() {
		partialSize = 0;
		numberMade = 0;
		hasFinished = false;
		hasStarted = false;
	}

	public void start() {
		hasStarted = true;
	}
	
	public void stop() {
		hasFinished = true;
	}

	public int getMaximumSize() {
		return maximumSize;
	}

	public int getNumberMade() {
		if (requiredAmount != 0) {
			int numberLeft = requiredAmount - numberMade;
			return numberLeft;
		}

		return numberMade;
	}

	public int getPartialSize() {
		return partialSize;
	}
	
	public boolean getHasStarted() {
		return hasStarted;
	}
	
	public boolean getHasFinished() {
		return hasFinished;
	}
}
