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

public class DeleteFrame extends JFrame
{
	private GUI gui;
	private MainFrame main;
        private DeleteTable table;
        private ArrayList<booksDTO> books;
        private ArrayList<booksDTO> deletedbooks;
        private JButton save;
	public DeleteFrame(MainFrame main, GUI gui, ArrayList<booksDTO> books)
	{
		super("Delete");
                try 
        {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
        {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
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
         
        save = new JButton("Delete");
        save.setFont(new Font("Serif", Font.ITALIC, 16));
        Font f = save.getFont();
        save.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        add(save, BorderLayout.NORTH);
     
	table = new DeleteTable(books);
        add(table.getTable(), BorderLayout.CENTER);

        save.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent arg0) 
                   {   
                       deleteBooks();
                       dispose();
	           }
	       });
        
        
        pack();
        setLocationRelativeTo(null);    // centers on screen
        setVisible(true);
	}

             public void deleteBooks()
	   {
               deletedbooks = new ArrayList();
               deletedbooks = table.deleted();
               this.gui.delete(deletedbooks);
               refreshData();

	   }
	   public void refreshData()
	   {
		   this.gui.refreshData();
	   }
	
}
