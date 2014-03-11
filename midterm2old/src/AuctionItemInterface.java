import java.util.Iterator;

public interface AuctionItemInterface extends Iterable<Bid> {
	
	public String getDescription();

	public void makeBid(Bid newBid);

	public Bid getHighestBid();

	public Iterator<Bid> byName();
}