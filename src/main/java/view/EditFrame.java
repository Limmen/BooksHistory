package view;

import Util.booksDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.UIManager;

public class EditFrame extends JFrame
{
	private GUI gui;
	private MainFrame main;
        private EditTable table;
        private ArrayList<booksDTO> books;
        private JButton save;
	public EditFrame(MainFrame main, GUI gui, ArrayList<booksDTO> books)
	{
		super("Edit");
                try 
        {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
        {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                UIManager.getLookAndFeelDefaults().put("control", Color.RED);
                break;
            }
        }
        } 
        catch (Exception e) 
        {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
                
		this.gui = gui;
		this.main = main;
                this.books = books;
	
        setLayout(new GridBagLayout());
               
	GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.insets = new Insets(15, 15, 15, 15);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;       
         
        save = new JButton("Save");
        Font f = save.getFont();
        // bold
        save.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        add(save, constraints);
        constraints.gridy = 1;
                       
	table = new EditTable(books);
        add(table.getTable(), constraints);

        save.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent arg0) {
	               //System.out.println("You have clicked on the new action");
                       
	               
	           }
	       });
        
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(800, 600);
        pack();
        setLocationRelativeTo(null);    // centers on screen
        setVisible(true);
	}
	
	
}
