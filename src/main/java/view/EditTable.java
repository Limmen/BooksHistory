package view;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Util.booksDTO;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EditTable
{
	private JScrollPane scrollPane;
	private ArrayList<booksDTO> books;
	private JTable table;
	private Object columnNames[];
	private Object rowData[][];
	private DefaultTableModel model;
	
	EditTable(ArrayList<booksDTO> books) 
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
				columnNames = new Object[5];
				columnNames[0] = "Title";
				columnNames[1] = "Author";
				columnNames[2] = "Year";
				columnNames[3] = "Comment";
				columnNames[4] = "Grade";
			    		
				model = new DefaultTableModel(rowData,columnNames) {

				    @Override
				    public boolean isCellEditable(int row, int column) 
                                    {
                                          //this.fireTableCellUpdated(row, column);
				      return true;
				    }
                                     public void setValueAt(Object value, int row, int col) 
                                     {
                                        rowData[row][col] = value;
                                        model.setDataVector(rowData, columnNames);
                                     }
				};
				table = new JTable(model);
                                table.setRowHeight(20);
                                table.setFont(new Font("Serif", Font.ITALIC, 12));
                                Font f = table.getFont();
                                table.getTableHeader().setFont(f.deriveFont(f.getStyle() | Font.BOLD));
                                scrollPane = new JScrollPane(table);
                                scrollPane.getViewport().setBackground(Color.darkGray);
		
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
        
        public ArrayList<booksDTO> edited ()
        {
            ArrayList<booksDTO> edited = new ArrayList();
            for (int i = 0; i < rowData.length; i++)
            {
                String title = (String) rowData[i][0];
                String author = (String) rowData[i][1];
                String year = (String) rowData[i][2];
                String comment = (String) rowData[i][3];
                String grade = (String) rowData[i][4];
                booksDTO b = new booksDTO(title,author,year,comment,grade);
                
                edited.add(b);
            }
            return edited;
        }

	
}
