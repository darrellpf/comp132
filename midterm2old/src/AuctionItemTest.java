
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AuctionItemTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void secondBidRejected() {
		AuctionItemInterface diamonds = new AuctionItem("Diamonds", 100);
		
		Bid firstFred = new Bid("Fred", 10);
		Bid secondFred = new Bid("Fred", 20);
		
		diamonds.makeBid(firstFred);
		diamonds.makeBid(secondFred);
		
		assertTrue(diamonds.getHighestBid() == firstFred);
	}
}
