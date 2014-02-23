
public class Phone {
	private String name;
	private String number;
	private int talkTime;
	
	public Phone(String inName, String inNumber) {
		name = inName;
		number = inNumber;
		talkTime = 0;
	}
	
	@Override
	public String toString() {
		String ret = "";
		
		ret += " Name " + name;
		ret += " number " + number;
		ret += " talktime " + talkTime;
		
		return ret;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public int getTalkTime() {
		return talkTime;
	}
	
	public void talk(int minutes) {
		talkTime += minutes;
	}
}
