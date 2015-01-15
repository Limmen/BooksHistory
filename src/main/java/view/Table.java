package view;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table 
{
	private JScrollPane scrollPane;
	Table()
	{
		 		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
			        { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
			    Object columnNames[] = { "Column One", "Column Two", "Column Three" };
			    JTable table = new JTable(rowData, columnNames);

			    scrollPane = new JScrollPane(table);
		
	}
	
	public JScrollPane getTable()
	{
		return this.scrollPane;
	}
}
