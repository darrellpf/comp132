import java.util.Iterator;


public class BidDriver {

	public static void main(String[] args) {
		AuctionItemInterface diamonds = new AuctionItem("Diamonds", 5);
		
		diamonds.makeBid(new Bid("Fred", 10));
		diamonds.makeBid(new Bid("Chico", 15));
		diamonds.makeBid(new Bid("Barney", 20));
		
		System.out.println();
		System.out.println("Bidders by name");
		System.out.println();

		Iterator<Bid> iter = diamonds.byName();
		
		while(iter.hasNext()) {
			Bid aBid = iter.next();
			System.out.println(aBid.getName() + " " + aBid.getAmount());
		}
		
		System.out.println();
		System.out.println("Bidders by bid amount");
		System.out.println();

		
		for(Bid aBid : diamonds) {
			System.out.println(aBid.getName() + " " + aBid.getAmount());
		}		
	}

}
