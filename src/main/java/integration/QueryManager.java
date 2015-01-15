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

		String query = "SELECT * FROM Books";
		PreparedStatement statement = setupStatement(query);		
		return db.sendQuery(statement);
	}

	    public void parameterizedselect() throws Exception
	    {
	        // Local variables
	        String query;
	        ResultSet rs;
	        PreparedStatement stmt;
	        String markeparam;

	        // Create a Scanner in order to allow the user to provide input.
	        java.util.Scanner in = new java.util.Scanner(System.in);

	        // This is the old way (Java 1.4 or earlier) for reading user input:
	        // Create a BufferedReader in order to allow the user to provide input.
	        // java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

	        // Ask the user to specify a value for Märke.
	        System.out.print("Ange en stad för att hämta alla biografer i den staden: ");
	        // Retrieve the value and place it in the variable markeparam.
	        markeparam = in.nextLine();

	        // Set the SQL statement into the query variable
	        query = "SELECT * FROM Biograf WHERE stad = ?";
	//= ?
	        // Create a statement associated to the connection and the query.
	        // The new statement is placed in the variable stmt.
	        stmt = con.prepareStatement(query);

	        // Provide the value for the first ? in the SQL statement.
	        // The value of the variable markeparam will be sent to the database manager
	        // through the variables stmt and con.
	        stmt.setString(1, markeparam);

	        // Execute the SQL statement that is prepared in the variable stmt
	        // and store the result in the variable rs.
	        rs = stmt.executeQuery();

	        System.out.println("Resultatet (Bilar som ägs av personer från " + markeparam + "):");

	        // Loop through the result set and print the results.
	        // The method next() returns false when there are no more rows.
	        while (rs.next())
	        {
	            System.out.println(rs.getString("regnr") + " " + rs.getString("marke") + " " + rs.getString("farg"));
	        }

	        // Close the variable stmt and release all resources bound to it
	        // Any ResultSet associated to the Statement will be automatically closed too.
	        stmt.close();
	    }

	    public void insert() throws Exception
	    {
	        // Local variables
	        String query;
	        PreparedStatement stmt;
	        String regnumr;
	        String fargen;
	        String stadparam;

	        // Create a Scanner in order to allow the user to provide input.
	        java.util.Scanner in = new java.util.Scanner(System.in);

	        // Ask the user to specify a value for förnamn.
	        System.out.print("Ange regnumret på den bil du vill måla om");
	        // Retrieve the value and place it in the variable fnamnparam.
	        regnumr = in.nextLine();
	        // Ask the user to specify a value for efternamn.
	        System.out.print("Ange färgen du vill måla om bilen med");
	        // Retrieve the value and place it in the variable enamnparam.
	        fargen = in.nextLine();
	        // Ask the user to specify a value for stad.
	        //System.out.print("Ange staden: ");
	        // Retrieve the value and place it in the variable stadparam.
	        //stadparam = in.nextLine();

	        // Set the SQL statement into the query variable
	        query = "UPDATE bil SET farg = ? WHERE regnr = ?";

	        // Create a statement associated to the connection and the query.
	        // The new statement is placed in the variable stmt.
	        stmt = con.prepareStatement(query);

	        // Provide the values for the ?'s in the SQL statement.
	        // The value of the variable fnamnparam is the first,
	        // enamnparam is second and stadparam is third.
	        stmt.setString(1, fargen);
	        stmt.setString(2, regnumr);
	        
	        //stmt.setString(3, stadparam);

	        // Execute the SQL statement that is prepared in the variable stmt
	        stmt.executeUpdate();

	        // Close the variable stmt and release all resources bound to it
	        stmt.close();
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
}
