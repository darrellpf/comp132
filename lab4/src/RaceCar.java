
public class RaceCar implements RaceCarInterface, Comparable<RaceCar> {
	private String name;
	private int carNumber;
	private int lapsCompleted;
	private boolean disqualified;
	private int finishPosition;
	
	public RaceCar(String inName, int inNumber){
		name = inName;
		carNumber = inNumber;
		lapsCompleted = 0;
		disqualified = false;
		finishPosition = 0;
	}
	
	public boolean equals(Object what) {
		RaceCar other = (RaceCar) what;
		
		return carNumber == other.carNumber;
	}

	@Override
	public String getDriverName() {

		return name;
	}

	@Override
	public int getCarNumber() {
		return carNumber;
	}

	@Override
	public int getLapsCompleted() {
		return lapsCompleted;
	}

	@Override
	public void addLap() {
		if(disqualified == true) {
			return;
		}
		
		lapsCompleted++;
		
	}

	@Override
	public boolean isDisqualified() {
		return disqualified;
	}

	@Override
	public void disqualify() {
		disqualified = true;		
	}

	@Override
	public void setFinishPosition(int position) {
		finishPosition = position;
	}

	@Override
	public int getFinishPosition() {
		return finishPosition;
	}
	
	public int compareTo(RaceCar another) {
		return finishPosition - another.finishPosition;
	}

}
