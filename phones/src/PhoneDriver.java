
public class PhoneDriver {

	public static void main(String[] args) {
		Phone myPhone = new Phone("Fred", "555-1212");
		
		myPhone.talk(10);
		myPhone.talk(30);
		
		System.out.println("Fred Talked for " + myPhone.getTalkTime());
		
		CellPhone otherPhone = new CellPhone("Sam", "555-6666", 200);

		System.out.println(otherPhone);
		
		PrepaidPhone burnerPhone = new PrepaidPhone("Sam", "557-6666");
		burnerPhone.buyMinutes(200);

	}

}
