package view;

import java.awt.Font;
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
        optionsMenu.setFont(new Font("Serif", Font.ITALIC, 16));
        Font f = optionsMenu.getFont();
        // bold
        optionsMenu.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        menuBar.add(optionsMenu);
        
        // Create and add simple menu item to one of the drop down menu
        newAction = new JMenuItem("New book");
        newAction.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        editAction = new JMenuItem("Edit");
        editAction.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        deleteAction = new JMenuItem("Delete");
        deleteAction.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        
       
        optionsMenu.add(newAction);
        optionsMenu.add(editAction);
        optionsMenu.add(deleteAction);


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
