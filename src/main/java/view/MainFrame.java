package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Util.booksDTO;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class MainFrame extends JFrame {
    private PrintStream standardOut;
    private JMenuBar jmenu;
    private EditFrame edit;
    private NewFrame newbook;
    private DeleteFrame delbook;
    private GUI gui;
    private JLabel text;
    private JPanel tablepanel;
    private ArrayList<booksDTO> books;
    private Table table;
    private NewFrame2 newbook2;
    
    public MainFrame(GUI gui, ArrayList<booksDTO> books) {
        super("bookshistory");
        try 
        {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
        {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                //UIManager.put("Panel.background", Color.cyan);
                break;
            }
        }
        } 
        catch (Exception e) 
        {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        this.gui = gui;
        this.books = books;
   
       Menu menu = new Menu();
       setJMenuBar(menu.getMenu());
       menu.getNewAction().addActionListener(new ActionListener() 
       {
           public void actionPerformed(ActionEvent arg0) 
           {
        	   showNew();
               
           }
       });
       
       menu.getEditAction().addActionListener(new ActionListener() 
       {
           public void actionPerformed(ActionEvent arg0) 
           {
        	   showEdit();
               
           }
       });
       
       menu.getDeleteAction().addActionListener(new ActionListener() 
       {
           public void actionPerformed(ActionEvent arg0) 
           {
        	   showDelete();
               
           }
       });
      
        table = new Table(books);
        JScrollPane t = table.getTable();
        add(t, BorderLayout.CENTER); 
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(800, 600);
        setBackground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);    // centers on screen
        setVisible(true);
    }
    
   public void showEdit()
   {
	   edit = new EditFrame(this, gui, books);
   }
   public void showNew()
   {
	    //newbook = new NewFrame(this, gui);
       newbook2 = new NewFrame2(this, gui);
   }
   public void showDelete()
   {
	   delbook = new DeleteFrame(this, gui, books);
   }
   public void updateData(ArrayList<booksDTO> data)
   {
	   table.updateData(data);
	   this.books = data;
	   //add(table.getTable(), BorderLayout.CENTER); 
   }

 
}

