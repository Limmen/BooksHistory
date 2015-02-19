package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class NewFrame2 extends JFrame
{
	private GUI gui;
	private MainFrame main;
	private JTextField title = new JTextField(30);
	private JLabel titlelabel = new JLabel("Title");
	private JTextField author = new JTextField(30);
	private JLabel authorlabel = new JLabel("Author");
	private JTextField comment = new JTextField(40);
	private JLabel commentlabel = new JLabel("Comment");
	private JTextField year = new JTextField(30);
	private JLabel yearlabel = new JLabel("Year");
        private JLabel gradelabel = new JLabel("Grade");
        private JButton save = new JButton("Save");
        JLabel text = new JLabel("Enter information about the book");
        String[] grades = {"None","Bad","Ok", "Good", "Very good", "Excellent"};
        JComboBox combo = new JComboBox(grades);
     
	public NewFrame2(MainFrame main, GUI gui) 
	{
	super("New book");
        try 
        {
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
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
        JPanel panel = new JPanel(new GridLayout(0, 1));
    
        text.setFont(new Font("Serif", Font.ITALIC, 16));
        Font f = text.getFont();
        text.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        
        titlelabel.setFont(new Font("Serif", Font.ITALIC, 12));
        Font f2 = titlelabel.getFont();
        authorlabel.setFont(f2);
        yearlabel.setFont(f2);
        commentlabel.setFont(f2);
        gradelabel.setFont(f2);
        combo.setFont(f2);
        save.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        
        panel.add(text);
        panel.add(titlelabel);
        panel.add(title);
        panel.add(authorlabel);
        panel.add(author);
        panel.add(yearlabel);
        panel.add(year);
        panel.add(commentlabel);
        panel.add(comment);
        panel.add(gradelabel);
        panel.add(combo);
        panel.add(save);
    
        add(panel);
    
        save.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) 
            {
                   String grade = combo.getSelectedItem().toString(); 
            	   addBook(title.getText(), author.getText(), year.getText(), comment.getText(), grade);
         	   refreshData();
         	   dispose();    
            }
        });
        pack();
        setLocationRelativeTo(null);    // centers on screen
        setVisible(true);
	}
	   public void addBook(String title, String author, String year, String comment, String grade)
	   {
		   gui.newBook(title, author, year, comment, grade);
	   }
	   public void refreshData()
	   {
		   this.gui.refreshData();
	   }
	
}
