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
	
	public void donate(int money) {
		moneyTotal += 100;
	}
	
	public int getMoneyTotal() {
		return moneyTotal;
	}
	
	public void clear() {
		moneyTotal = 0;
	}
}
