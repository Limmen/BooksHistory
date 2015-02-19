package controller;

import Util.booksDTO;
import integration.QueryManager;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Controller 
{
	private QueryManager qm;
	
	public Controller()
	{
		qm = new QueryManager();
	}
	
	public ResultSet getData() throws Exception
	{
		return qm.getData();
	}
    public void newBook(String title, String author, String year, String comment, String grade)
    {
    	qm.insert(title, author, year, comment, grade);
    }
    public void edit(ArrayList<booksDTO> editedbooks, ArrayList<booksDTO> books)
    {
        qm.edit(editedbooks,books);
    }
        public void delete(ArrayList<booksDTO> deletedbooks)
    {
        qm.delete(deletedbooks);
    }
}
