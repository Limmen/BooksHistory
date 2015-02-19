package view;

import java.sql.ResultSet;
import java.util.ArrayList;

import Util.booksDTO;
import controller.Controller;

public class View 
{
	private GUI gui;
	private Controller contr;
	
	private ArrayList<booksDTO> books;
	public View(Controller contr)
	{
	this.contr = contr;
	}
	
	public void getData() throws Exception
	{
		ResultSet rs = contr.getData();
		buildTable(rs);
		this.gui = new GUI(books, this);
		
	}

	public void printResult(ResultSet rs) throws Exception
	{
        while (rs.next())
        {
            System.out.print(rs.getString("Title"));
            System.out.println(rs.getString("Author"));
            System.out.print(rs.getString("ReadYear"));
            System.out.print(rs.getString("Comment"));
            System.out.print(rs.getString("Grade"));
        }
	}
	
	public void buildTable(ResultSet rs) throws Exception
	{
		books = new ArrayList();
		while (rs.next())
        {            
            books.add(new booksDTO(rs.getString("Title"),
            		rs.getString("Author"),
            		rs.getString("ReadYear"),
            		rs.getString("Comment"),
            		rs.getString("Grade")));
            
        }
	}
    public void newBook(String title, String author, String year, String comment, String grade)
    {
 	 contr.newBook(title, author, year, comment, grade);
    }
	public void refreshData() throws Exception
	{
		ResultSet rs = contr.getData();
		buildTable(rs);
		gui.updateData(books);
	}
    public void edit(ArrayList<booksDTO> editedbooks, ArrayList<booksDTO> books)
    {
        contr.edit(editedbooks,books);
    }
    public void delete(ArrayList<booksDTO> deletedbooks)
    {
        contr.delete(deletedbooks);
    }
}
