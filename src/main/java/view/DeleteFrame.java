package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Util.booksDTO;

public class DeleteFrame extends JFrame
{
	private GUI gui;
	private JMenuBar jmenu;
	private MainFrame main;
	private ArrayList<booksDTO> books;
	private ButtonGroup buttongroup;
	private JPanel buttonpanel;
	private JLabel text;
	private JButton delbutton;
	final JRadioButton None = new JRadioButton("None", true);
	
	
	public DeleteFrame(MainFrame main, GUI gui, ArrayList<booksDTO> books)
	{
		super("Delete");
		this.gui = gui;
		this.main = main;
		this.books = books;
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        text = new JLabel("Select the book you want to delete");
        add(text, constraints);
        
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.insets = new Insets(1, 1, 1, 1);
        buttongroup = new ButtonGroup();
        buttonpanel = new JPanel(new GridBagLayout());
        
        buttongroup.add(None);
        buttonpanel.add(None,constraints);
        //buttonpanel.add(None);
   
        JRadioButton temp;
        int x = 0;
        int y= 4;
        for(int i = 0; i<books.size(); i++)
        {
        	String title = books.get(i).getTitle();
        	temp = new JRadioButton(title, true);
        	temp.setActionCommand(title);
        	buttongroup.add(temp);
        	if(x == 4)
        	{
        		x = 0;
        		y = y+1;
        	}
        	constraints.gridx = x;
            constraints.gridy = y;
        	buttonpanel.add(temp, constraints);;
        	x = x +1;
        }
        
        add(buttonpanel, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = constraints.gridy+1;
        constraints.insets = new Insets(10, 10, 10, 10);
        delbutton = new JButton("Delete");
        add(delbutton, constraints);
        delbutton.addActionListener(new ActionListener() 
        {
        	
            public void actionPerformed(ActionEvent arg0) 
            {
            	if(!None.isSelected())
            	{
            	delBook(buttongroup.getSelection().getActionCommand());
          	    refreshData();
          	    dispose();
            	}
            }
        });
		
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);    // centers on screen
        setVisible(true);
	}
	
	public void delBook(String title)
	{
		gui.delBook(title);
	}
	
	   public void refreshData()
	   {
		   this.gui.refreshData();
	   }
	
	
}
