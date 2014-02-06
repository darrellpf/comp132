import javax.swing.table.AbstractTableModel;

public class FisherTableModel extends AbstractTableModel {
	
	String [] columnNames = { "Name", "Biggest Fish" };

	Derby theDerby;

	public void setDerby(Derby inDerby) {
		theDerby = inDerby;
	}

	public int getRowCount() {
		return theDerby.size();
	}

	public int getColumnCount() {
		// just the name and the biggest fish weight
		return 2;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Fisher who = theDerby.getFisher(rowIndex);

		switch (columnIndex) {
		case 0:
			return who.getName();
		case 1:
			Fish theFish = who.getBiggestFish();
			if(theFish == null) {
				return 0;
			}
			return theFish.getWeight();
		}
		return null;
	}
	
	public String getColumnName(int col)
	{
	return columnNames[col];
	}

public boolean isCellEditable(int row, int col)
	{
	return false;
	}

	public Class<?> getColumnClass(int c) {
		switch(c) {
		case 0:
			return String.class;
			
		case 1:
			return Integer.class;
		}
		
		return null;
	}

}
