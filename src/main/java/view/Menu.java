package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Menu 
{
	private JMenuBar menuBar;
	private JMenuItem newAction;
	private JMenuItem editAction;
	private JMenuItem deleteAction;
	Menu()
	{
		// Creates a menubar for a JFrame
        menuBar = new JMenuBar();
        
      
        // Define and add two drop down menu to the menubar
        JMenu optionsMenu = new JMenu("Options");
        menuBar.add(optionsMenu);
        
        // Create and add simple menu item to one of the drop down menu
        newAction = new JMenuItem("New book");
        editAction = new JMenuItem("Edit");
        deleteAction = new JMenuItem("Delete");
        
        // Create and add CheckButton as a menu item to one of the drop down
        // menu
        //JCheckBoxMenuItem checkAction = new JCheckBoxMenuItem("Check Action");
        // Create and add Radio Buttons as simple menu items to one of the drop
        // down menu
       // JRadioButtonMenuItem radioAction1 = new JRadioButtonMenuItem(
                //"Radio Button1");
        //JRadioButtonMenuItem radioAction2 = new JRadioButtonMenuItem(
                //"Radio Button2");
        // Create a ButtonGroup and add both radio Button to it. Only one radio
        // button in a ButtonGroup can be selected at a time.
        //ButtonGroup bg = new ButtonGroup();
        //bg.add(radioAction1);
        //bg.add(radioAction2);
        optionsMenu.add(newAction);
        optionsMenu.add(editAction);
        optionsMenu.add(deleteAction);
       // optionsMenu.addSeparator();
        // Add a listener to the New menu item. actionPerformed() method will
        // invoked, if user triggred this menu item

    }
	
	public JMenuBar getMenu()
	{
		return this.menuBar;
	}
	public JMenuItem getNewAction()
	{
		return newAction;
	}
	public JMenuItem getEditAction()
	{
		return editAction;
	}
	public JMenuItem getDeleteAction()
	{
		return deleteAction;
	}
}
