package view;

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
 	 //System.out.println(title+ " "+ author +" "+ year +" "+ comment +" "+ grade); 
     view.newBook(title, author, year, comment, grade);
    }
    

}
