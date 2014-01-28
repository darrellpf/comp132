public interface RaceCarInterface {

	public String getDriverName();

	public int getCarNumber();

	public int getLapsCompleted();

	public void addLap();

	public boolean isDisqualified();

	public void disqualify();

	public void setFinishPosition(int position);

	public int getFinishPosition();

}