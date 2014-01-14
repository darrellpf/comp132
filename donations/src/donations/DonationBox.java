package donations;

public class DonationBox {
	private String charityName;
	private int moneyTotal;
	
	public DonationBox(String inCharityName) {
		charityName  = inCharityName;
		moneyTotal = 0;
	}
	
	public String getCharityName() {
		return charityName;
	}
	
	public void donate(int moreMoney) {
		moneyTotal += moreMoney;
	}
	
	public int getMoneyTotal() {
		return moneyTotal;
	}
	
	public void clear() {
		charityName = "";
		moneyTotal = 0;
	}
}
