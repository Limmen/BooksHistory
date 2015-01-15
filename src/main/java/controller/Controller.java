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
}
