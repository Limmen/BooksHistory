package integration;

import Util.booksDTO;
import java.sql.*;
import java.util.ArrayList;

public class QueryManager 
{
	private DBhandler db;
	private Connection con;
	
	public QueryManager()
	{
		this.db = new DBhandler();
		db.connect();
	}
	
	public ResultSet getData() throws Exception
	{
		String query = "SELECT * FROM BOOKS";
		PreparedStatement statement = setupStatement(query);
		return db.sendQuery(statement);
	}
	public void insert(String title, String author, String year, String comment, String grade)
	{
		String query = "INSERT INTO BOOKS(Title,Author,ReadYear,Comment,Grade) "
				+ "VALUES ('"+ title +"', '"+ author +"','" + year + "', '" + comment +"', '" + grade +"')";
		
		PreparedStatement statement = setupStatement(query);
		db.updateQuery(statement);
		
		try
		{
			db.getConnection().commit();
		}
		catch (SQLException e)
		{
			System.out.println("Could'nt commit changes to database");
		}
		
	}
        public void delete(ArrayList<booksDTO> books)
        {
                for(int i = 0; i < books.size(); i++)
                {
                    booksDTO b = books.get(i);
                    String query = "DELETE FROM books" +
                                    " WHERE Title='" +b.getTitle() + "'"
                                    + " AND Author='" + b.getAuthor() +"'" +  
                                    " AND ReadYear='" + b.getYear() + "'" +
                                    " AND Comment='" + b.getComment() + "'" +
                                    " AND Grade='" + b.getGrade() + "'";
                    
                    PreparedStatement statement = setupStatement(query);
                    db.updateQuery(statement);
		try
		{
			db.getConnection().commit();
		}
		catch (SQLException e)
		{
			System.out.println("Could'nt commit changes to database");
		}
                }
            }
        	public void edit(ArrayList<booksDTO> editedbooks, ArrayList<booksDTO> books)
	{
                for(int i = 0; i < books.size(); i++)
                {
                    booksDTO b = editedbooks.get(i);
                    booksDTO c = books.get(i);
                    String query = "UPDATE books"
                                    + " SET Title='" +b.getTitle() + "', Author='" + b.getAuthor() +  
                                    "', ReadYear='" + b.getYear() + "', Comment='" + b.getComment() +
                                    "', Grade='" + b.getGrade() + "'" +
                                    " WHERE Title='" +c.getTitle() + "'"
                                    + " AND Author='" + c.getAuthor() +"'" +  
                                    " AND ReadYear='" + c.getYear() + "'" +
                                    " AND Comment='" + c.getComment() + "'" +
                                    " AND Grade='" + c.getGrade() + "'";
                    
                    PreparedStatement statement = setupStatement(query);
                    db.updateQuery(statement);
		try
		{
			db.getConnection().commit();
		}
		catch (SQLException e)
		{
			System.out.println("Could'nt commit changes to database");
		}
                }
	}

	   
	    
		private PreparedStatement setupStatement(String sql)
		{
			System.out.println("Seting up statement: " + sql);
			con = db.getConnection();
			PreparedStatement statement = null;
			
			try 
			{
				statement = con.prepareStatement(sql);
				statement.closeOnCompletion();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
					
			return statement;
		}
		
		private Statement setupState(String sql)
		{
			System.out.println("Seting up statement: " + sql);
			con = db.getConnection();
			Statement statement = null;
			
			try 
			{
				statement = con.createStatement();
				statement.closeOnCompletion();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
					
			return statement;
		}
}
