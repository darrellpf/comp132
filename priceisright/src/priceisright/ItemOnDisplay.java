package priceisright;

public class ItemOnDisplay {
	private String description;
	private int price;
	
	public ItemOnDisplay(String inDescription, int inPrice) {
		description = inDescription;
		price = inPrice;
	}
	
	public int getPrice() {
		return price;
	}
}
