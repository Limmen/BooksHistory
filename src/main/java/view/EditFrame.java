package view;

import Util.booksDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class EditFrame extends JFrame
{
	private GUI gui;
	private MainFrame main;
        private EditTable table;
        private ArrayList<booksDTO> books;
        private ArrayList<booksDTO> oldbooks;
        private ArrayList<booksDTO> editedbooks;
        private ArrayList<booksDTO> ebooks;
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
        save = new JButton("Save");
        save.setFont(new Font("Serif", Font.ITALIC, 16));
        Font f = save.getFont();
        save.setFont(f.deriveFont(f.getStyle() | Font.BOLD));;
        add(save, BorderLayout.NORTH);
        
	table = new EditTable(books);
        add(table.getTable(), BorderLayout.CENTER);

        save.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent arg0) 
                   {   
                       editBooks();
                       dispose();
	           }
	       });
       
        pack();
        setMinimumSize(new Dimension(100, 100));
        setLocationRelativeTo(null);    // centers on screen
        setVisible(true);
	}

           public void editBooks()
	   {
               editedbooks = new ArrayList();
               oldbooks = new ArrayList();
               boolean edited = false;
               ebooks = table.edited();
               for (int i = 0; i< books.size(); i++)
               {
                   int res = books.get(i).compareTo(ebooks.get(i));
                   if(res != 0)
                   {
                       editedbooks.add(ebooks.get(i));
                       oldbooks.add(books.get(i));
                       edited = true;
                   }
               }
               if(edited == true)
               {
                   this.gui.edit(editedbooks,oldbooks);
                   refreshData();
               }
	   }
	   public void refreshData()
	   {
		   this.gui.refreshData();
	   }
	
}
