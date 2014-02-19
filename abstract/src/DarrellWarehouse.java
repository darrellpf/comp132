
public class DarrellWarehouse extends Warehouse {

	public DarrellWarehouse(String inName) {
		super(inName);
	}

	@Override
	public void add(Box aBox) {
		allBoxes.add(aBox);
		
	}

	@Override
	public Box get(int position) {
		return allBoxes.get(position);
	}
	
	public int getOne() {
		return 1;
	}

}
