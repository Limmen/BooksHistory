package startup;

import view.View;
import controller.Controller;

public class Startup {

	public static void main(String[] args) throws Exception
	{
		Controller contr = new Controller();
		View view = new View(contr);
		view.getData();
		
	}

}
