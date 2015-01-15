package startup;

import view.GUI;
import controller.Controller;

public class Startup {

	public static void main(String[] args) throws Exception
	{
		Controller contr = new Controller();
		GUI gui = new GUI(contr);
		gui.getData();
		

	}

}
