import java.util.ArrayList;




public class OneDriver {

	public static void main(String[] args) {
		OneBasedListInterface aList = new OneBasedList();
		
		aList.add(new Fish(20, "Carp"));
		
		Fish aFish = (Fish) aList.get(1);
		

	}

}
