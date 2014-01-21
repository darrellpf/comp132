package motors;

public class Motor {
	private String serialNumber;
	private int hoursOfService;
	private int maximumHoursBeforeService;

	public Motor(String inSerialNumber, int inMaximumHoursBeforeService) {
		serialNumber = inSerialNumber;
		hoursOfService = 0;
		maximumHoursBeforeService = inMaximumHoursBeforeService;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public int getHoursOfService() {
		return hoursOfService;
	}

	public int getMaximumHoursBeforeService() {
		return maximumHoursBeforeService;
	}

	public void addHoursOfService(int moreFlightHours) {
		hoursOfService += moreFlightHours;
	}

	public int hoursOfServiceLeft() {
		int hoursLeft = maximumHoursBeforeService - hoursOfService;
		return hoursLeft;
	}
	
	public boolean isPastService() {
		if(hoursOfService > maximumHoursBeforeService) {
			return true;
		}
		
		return false;
	}
}
