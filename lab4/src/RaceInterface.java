public interface RaceInterface  extends Iterable<RaceCar>{

	public String getName();

	public int getLapsInRace();

	public void add(RaceCar aCar);

	public void addLap(int carNumber);

	public RaceCarInterface findCar(int carNumber);

	public void disqualify(int carNumber);

	public RaceCarInterface findFinishPosition(int position);

	public RaceCarInterface findRacer(RaceCarInterface findMe);

}