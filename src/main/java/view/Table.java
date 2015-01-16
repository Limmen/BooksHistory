package view;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import Util.booksDTO;

public class Table 
{
	private JScrollPane scrollPane;
	private ArrayList<booksDTO> books;
	
	Table(ArrayList<booksDTO> books)
	{
		this.books = books;
		Object rowData[][] = new Object[books.size()][5];
		for(int i = 0; i <  books.size(); i++)
		{
			booksDTO b = books.get(i);
			rowData[i][0] = b.getTitle();
			rowData[i][1] = b.getAuthor();
			rowData[i][2] = b.getYear();
			rowData[i][3] = b.getComment();
			rowData[i][4] = b.getGrade();
		}
		/*
		 		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3",
		 			"Row1-Column4","Row1-Column5" },
			        { "Row2-Column1", "Row2-Column2", "Row2-Column3","Row2-Column4",
			        		 "Row2-Column5" } };
			        		 */
			    Object columnNames[] = { "Title", "Author", "Year", "Comment",
			    		"Grade"};
			    		
			    JTable table = new JTable(rowData, columnNames);

			    scrollPane = new JScrollPane(table);
		
	}
	
	public JScrollPane getTable()
	{
		return this.scrollPane;
	}
}
