package donations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DonationBoxTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void boxSetUpCorrectly() {
		DonationBox	bayCenter = new DonationBox("SPCA");
		
		String name = bayCenter.getCharityName();
		assertTrue(name.equals("SPCA"));
		
		int money = bayCenter.getMoneyTotal();
		assertTrue( money == 0);		
	}
	
	@Test
	public void willAcceptInitalMoney() {
		DonationBox	bayCenter = new DonationBox("SPCA");
		
		bayCenter.donate(100);
		int money = bayCenter.getMoneyTotal();
		assertTrue( money == 100);		
	}
	
	@Test
	public void willContinueToAddMoney() {
		DonationBox	bayCenter = new DonationBox("SPCA");
		
		bayCenter.donate(100);
		int money = bayCenter.getMoneyTotal();
		assertTrue( money == 100);	
		
		bayCenter.donate(50);
		money = bayCenter.getMoneyTotal();
		assertTrue( money == 100 + 50);	
		
		bayCenter.donate(25);
		money = bayCenter.getMoneyTotal();
		assertTrue( money == 100 + 50 + 25);	
	}
	
	@Test
	public void clearWorks() {
		DonationBox	bayCenter = new DonationBox("SPCA");
		
		bayCenter.donate(100);
		int money = bayCenter.getMoneyTotal();
		assertTrue( money == 100);	
		
		bayCenter.donate(50);
		money = bayCenter.getMoneyTotal();
		assertTrue( money == 100 + 50);	
		
		bayCenter.clear();
		
		String name = bayCenter.getCharityName();
		assertTrue(name.equals("SPCA"));

		money = bayCenter.getMoneyTotal();
		assertTrue( money == 0);		
		
	}

}
