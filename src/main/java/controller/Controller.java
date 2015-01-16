package controller;

import integration.QueryManager;

import java.sql.ResultSet;

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
    	//qm = new QueryManager();
    	qm.insert(title, author, year, comment, grade);
    	//qm.getData();
    }
}
