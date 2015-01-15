package view;

import java.sql.ResultSet;

import controller.Controller;

public class View 
{
	private GUI gui;
	private Controller contr;

	public View(Controller contr)
	{
	this.contr = contr;
	this.gui = new GUI();
	}
	
	public void getData() throws Exception
	{
		ResultSet rs = contr.getData();
		printResult(rs);
		
	}
	public void printResult(ResultSet rs) throws Exception
	{
        while (rs.next())
        {
            System.out.print(rs.getString("Title"));
            System.out.println();
        }
	}
}
