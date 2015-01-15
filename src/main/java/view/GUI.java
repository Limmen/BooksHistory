package view;

import java.sql.ResultSet;

import controller.Controller;

public class GUI 
{
	private Controller contr;
	public GUI(Controller contr)
	{
		this.contr = contr;
	}

	
	public void getData() throws Exception
	{
		System.out.println("test: GUI");
		ResultSet rs = contr.getData();
		printResult(rs);
		
	}
	public void printResult(ResultSet rs) throws Exception
	{
		System.out.println("supposed to print");
        while (rs.next())
        {
            System.out.print(rs.getString("Title"));
            System.out.println();
        }
	}
}
