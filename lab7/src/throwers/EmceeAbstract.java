package throwers;

import java.util.List;

public abstract class EmceeAbstract implements Iterable<InstructorInterface>{
	
	protected Thrower currentThrower;
	protected InstructorInterface currentVictim;

	public abstract ThrowerAbstract getCurrentThrower();
	public abstract InstructorInterface getCurrentVictim();
	public abstract void throwerStepsUp(Thrower nextThrower);
	public abstract void throwerChoosesVictim(InstructorInterface victim);
	public abstract boolean throwAnother();
	public abstract void dunked();
	public abstract float getTotalFundsRaised();
	public abstract List<InstructorInterface> byDunks();
}