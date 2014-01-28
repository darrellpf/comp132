package motors;

public interface MotorStandard extends Comparable<MotorStandard>{


	public String getSerialNumber();

	public int getHoursOfService();

	public int getMaximumHoursBeforeService();

	public void addHoursOfService(int moreFlightHours);

	public int hoursOfServiceLeft();
	
	public boolean isPastService();
	
}
