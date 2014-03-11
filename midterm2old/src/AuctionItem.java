import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class AuctionItem implements AuctionItemInterface {
	private String description;
	private List<Bid> allBids;
	private int minimumBid;
	
	public AuctionItem(String inDescription, int inMinimumBid) {
		description = inDescription;
		allBids = new ArrayList<Bid>();
		minimumBid = inMinimumBid;
	}
	
	public void makeBid(Bid newBid) {
		
		if(newBid.getAmount() < minimumBid) {
			return;
		}
		
		if(allBids.size() == 0) {
			allBids.add(newBid);
			return;
		}
		
		int position = allBids.indexOf(newBid);
		if(position >= 0) {
			return;
		}
		
		Bid highestBid = Collections.max(allBids);
		if(newBid.compareTo(highestBid) < 0) {
			return;
		}
		
		allBids.add(newBid);
	}
	
	public String getDescription() {
		return description;
	}
	
	public Bid getHighestBid() {
		return Collections.max(allBids);
	}
	
	public Iterator<Bid> iterator() {
		Collections.sort(allBids);
		return allBids.iterator();
	}

	public Iterator<Bid> byName() {
		Collections.sort(allBids, Bid.getByName());
		return allBids.iterator();
	}
}
