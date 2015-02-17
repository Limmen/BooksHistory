package view;

import java.sql.SQLException;
import java.util.ArrayList;

import Util.booksDTO;


public class GUI {
   
     private MainFrame main;
     private View view;
     private ArrayList<booksDTO> books;
     
    public GUI(ArrayList<booksDTO> books, View view) 
    {
    	main = new MainFrame(this, books);
    	this.view = view;
    }
    
    public void newBook(String title, String author, String year, String comment, String grade)
    {
     view.newBook(title, author, year, comment, grade);
    }
    
    public void refreshData() 
    {
    	try{
    	view.refreshData();
    	}
    	catch(Exception e)
    	{
    		System.out.println("Could not update data!!!");
    		e.printStackTrace();
    	}
    }
    public void updateData(ArrayList<booksDTO> data)
    {
    	main.updateData(data);
    }
    
    public void delBook(String title)
    {
    	view.delBook(title);
    }
    public void edit(ArrayList<booksDTO> editbooks, ArrayList<booksDTO> books)
    {
        view.edit(editbooks, books);
    }
}
