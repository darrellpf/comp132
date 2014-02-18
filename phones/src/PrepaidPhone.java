public class PrepaidPhone extends CellPhone {

	public PrepaidPhone(String inName, String inNumber) {
		super(inName, inNumber, 0);
	}
	
	public void buyMinutes(int moreMinutes) {
		super.setPlanMinutes(moreMinutes);
	}
	
	@Override
	public void talk(int minutes) {
		int currentMinutes = getPlanMinutes();
		currentMinutes -= minutes;
		setPlanMinutes(currentMinutes);
		
		planMinutes -= minutes;
	}
}
