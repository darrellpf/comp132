

import java.util.ArrayList;

public class OneBasedList extends ArrayList implements OneBasedListInterface{

	@Override
	public Object get(int position) {
		position--;
		return super.get(position);
	}
	
	@Override
	public Object remove(int position) {
		position--;
		return super.remove(position);
	}
}
