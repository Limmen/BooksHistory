package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
    private PrintStream standardOut;
    private JMenuBar jmenu;
    EditFrame edit; 
    public MainFrame() {
        super("bookshistory");
        //EditFrame edit = new EditFrame(this);
       Menu menu = new Menu();
       // Add the menubar to the frame
       setJMenuBar(menu.getMenu());
       menu.getNewAction().addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               //System.out.println("You have clicked on the new action");
        	   showEdit();
        	   //hidex();
               
           }
       });
       
       Table table = new Table();
       add(table.getTable(), BorderLayout.CENTER);
       
         
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);    // centers on screen
        setVisible(true);
    }
    
   public void hidex()
   {
	   this.setVisible(false);
   }
   
   public void showx()
   {
	   this.setVisible(true); 
   }
   public void showEdit()
   {
	   //edit.showx();
	   EditFrame edit = new EditFrame(this);
   }

 
}

