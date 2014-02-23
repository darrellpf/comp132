public class CellPhone extends Phone {
	protected int planMinutes;

	public CellPhone(String inName, String inNumber, int inPlanMinutes) {
		super(inName, inNumber);
		planMinutes = inPlanMinutes;
	}
	
	public void setPlanMinutes(int minutes) {
		planMinutes = minutes;
	}

	public int getPlanMinutes() {
		return planMinutes;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		result += " " + planMinutes;
		
		return result;
	}

}
