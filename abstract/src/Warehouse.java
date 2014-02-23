import java.util.ArrayList;
import java.util.List;

public abstract class Warehouse {

	protected List<Box> allBoxes;
	private String name;

	public Warehouse(String inName) {
		allBoxes = new ArrayList<Box>();
		name = inName;
	}

	public abstract void add(Box aBox);

	public abstract Box get(int position);
}
