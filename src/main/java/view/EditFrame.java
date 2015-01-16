package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class EditFrame extends JFrame
{
	private GUI gui;
	private JMenuBar jmenu;
	private MainFrame main;
	public EditFrame(MainFrame main, GUI gui)
	{
		super("Edit");
		this.gui = gui;
		this.main = main;
		Menu menu = new Menu();
	       // Add the menubar to the frame
	       setJMenuBar(menu.getMenu());
	       menu.getNewAction().addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent arg0) {
	               //System.out.println("You have clicked on the new action");

	               
	           }
	       });
		
		
		
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);    // centers on screen
        setVisible(true);
	}
	
	
}
