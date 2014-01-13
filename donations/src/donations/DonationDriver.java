package donations;

public class DonationDriver {

	public static void main(String[] args) {
	DonationBox	bayCenter = new DonationBox("SPCA");

	bayCenter.donate(100);
	
	int total = bayCenter.getMoneyTotal();
	
	System.out.println("Total is " + total);
	
	bayCenter.donate(100);
	total = bayCenter.getMoneyTotal();
	 
	System.out.println("Total is " + total);
	
	bayCenter.donate(100);
	bayCenter.donate(100);
	bayCenter.donate(100);
	
	total = bayCenter.getMoneyTotal();
	if(total != 500) {
		System.out.println("Error Total is " + total + "but should be 500");
	}

	System.out.println();
	}

}
