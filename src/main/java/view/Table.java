package view;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Util.booksDTO;

public class Table
{
	private JScrollPane scrollPane;
	private ArrayList<booksDTO> books;
	private JTable table;
	private Object columnNames[];
	private Object rowData[][];
	private DefaultTableModel model;
	
	Table(ArrayList<booksDTO> books) 
	{
		this.books = books;
		rowData = new Object[books.size()][5];
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
		/*
			    Object columnNames[] = { "Title", "Author", "Year", "Comment",
			    		"Grade"};
			    		*/
				columnNames = new Object[5];
				columnNames[0] = "Title";
				columnNames[1] = "Author";
				columnNames[2] = "Year";
				columnNames[3] = "Comment";
				columnNames[4] = "Grade";
			    		
				model = new DefaultTableModel(rowData,columnNames) {

				    @Override
				    public boolean isCellEditable(int row, int column) {
				       return false;
				    }
				};
				table = new JTable(model);
			    scrollPane = new JScrollPane(table);
		
	}
	
	public JScrollPane getTable()
	{
		return this.scrollPane;
	}
	public void updateData(ArrayList<booksDTO> data)
	{
		
		this.books = data;
		this.rowData = new Object[books.size()][5];
		for(int i = 0; i <  books.size(); i++)
		{
			booksDTO b = books.get(i);
			rowData[i][0] = b.getTitle();
			rowData[i][1] = b.getAuthor();
			rowData[i][2] = b.getYear();
			rowData[i][3] = b.getComment();
			rowData[i][4] = b.getGrade();
		}
		model.setDataVector(rowData, columnNames);
	}

	
}
