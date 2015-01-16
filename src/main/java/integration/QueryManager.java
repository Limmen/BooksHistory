package integration;

import java.sql.*;

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
		//insert("", "", "", "", "");
		String query = "SELECT * FROM Books";
		PreparedStatement statement = setupStatement(query);
		return db.sendQuery(statement);
	}
	public void insert(String title, String author, String year, String comment, String grade)
	{
		String query = "INSERT INTO books(Title,Author,ReadYear,Comment,Grade) "
				+ "VALUES ('"+ title +"', '"+ author +"'," + year + ", '" + comment +"', '" + grade +"')";
		
		PreparedStatement statement = setupStatement(query);
		db.insertQuery(statement);
		
		try
		{
			db.getConnection().commit();
		}
		catch (SQLException e)
		{
			System.out.println("Could'nt commit changes to database");
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
