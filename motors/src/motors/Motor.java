package motors;

public class Motor implements Comparable<Motor>{
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
	
	
	@Override
	public int compareTo(Motor another) {
		int difference = hoursOfService - another.getHoursOfService();
		return difference;
	}
	
	public boolean isPastService() {
		if(hoursOfService > maximumHoursBeforeService) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result += "serialNumber " + serialNumber;
		result += " maximumHoursBeforeService " + maximumHoursBeforeService;
		result += " hoursOfService "  + hoursOfService;
		
		return result;
	}
}
