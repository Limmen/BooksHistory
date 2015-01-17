package integration;

import java.sql.*;

public class DBhandler 
{
    	// DB connection variable
	    static protected Connection con;
	    // DB access variables
	    private String URL = "jdbc:odbc:bookhistory";
	    private String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	    private String userID = "";
	    private String password = "";
	    

	    public DBhandler()
	    {
	    	
	    }
	    // method for establishing a DB connection
	    public void connect()
	    {
	        try
	        {
	            
	            // register the driver with DriverManager
	            Class.forName(driver);
	            //create a connection to the database
	            con = DriverManager.getConnection(URL);
	            // Set the auto commit of the connection to false.
	            // An explicit commit will be required in order to accept
	            // any changes done to the DB through this connection.
	            con.setAutoCommit(false);
	            
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }

	    public boolean isConnected() throws Exception
		{
			
				return con.isValid(5);
		
		}

		public ResultSet sendQuery(String query)
		{
			ResultSet returnValue = null;
			Statement statement = null;
			try
			{
				statement = con.createStatement();
			} catch (SQLException e)
			{
				System.out.println("Failed to create statement.");
				System.out.println("A connection must be initialized before a query can be sent");
			}
			try
			{
				returnValue = statement.executeQuery(query);
			} catch (SQLException e)
			{
				System.out.println("Failed to execute query. Please ensure that the query adhered to SQL syntax.");
			}

			return returnValue;
		}
		
		public ResultSet sendQuery(PreparedStatement statement) 
		{
			ResultSet returnValue = null;

			try
			{
				returnValue = statement.executeQuery();
				//statement.executeUpdate();			
			} catch (SQLException e)
			{
				System.out.println(e.getMessage());
				System.out.println("Failed to execute query. Please ensure that the query adhered to SQL syntax.");
			}

			return returnValue;
		}
		public void updateQuery(PreparedStatement statement)
		{

			try
			{
			  statement.executeUpdate();			
			} catch (SQLException e)
			{
				System.out.println(e.getMessage());
				System.out.println("Failed to execute query. Please ensure that the query adhered to SQL syntax.");
			}

		}
		
		public Connection getConnection() 
		{
			return con;
		}

	    public void CommitAndClose() throws Exception
	    {
	        // Commit the changes made to the database through this connection.
	        con.commit();
	        // Close the connection.
	        con.close();
	    	
	    }
	

}
