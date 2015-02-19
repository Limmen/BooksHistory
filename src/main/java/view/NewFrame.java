package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class NewFrame extends JFrame
{
	private GUI gui;
	private JMenuBar jmenu;
	private MainFrame main;
	private JButton addBook;
	private JTextField title;
	private JLabel titlelabel;
	private JTextField author;
	private JLabel authorlabel;
	private JTextArea comment;
	private JLabel commentlabel;
	private JTextField year;
	private JLabel yearlabel;
	private ButtonGroup gradegroup;
	private JLabel gradelabel;
	
	final JRadioButton None = new JRadioButton("None", true);
	final JRadioButton A = new JRadioButton("1");
        final JRadioButton B = new JRadioButton("2");
        final JRadioButton C = new JRadioButton("3");
        final JRadioButton D = new JRadioButton("4");
        final JRadioButton E = new JRadioButton("5");
     
        JPanel gradePanel;
        JLabel text;
     
	public NewFrame(MainFrame main, GUI gui) 
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
	setLayout(new GridBagLayout());
	GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(15, 15, 15, 15);
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.weightx = 2.0;
        constraints.weighty = 2.0;
        
        text = new JLabel("Enter information about the book");
        text.setFont(new Font("Serif", Font.ITALIC, 16));
        Font f = text.getFont();
        // bold
        Map attributes = f.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        text.setFont(f.deriveFont(attributes));
        text.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        
        add(text, constraints);
        
		titlelabel = new JLabel("Title:");
                titlelabel.setFont(new Font("Serif", Font.ITALIC, 12));
                f = titlelabel.getFont();
                titlelabel.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(titlelabel, constraints);
        title=new JTextField(30);
        constraints.gridx= 2;
        constraints.gridy = 1;
        add(title, constraints);
        
		authorlabel = new JLabel("Author:");
                authorlabel.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		constraints.gridy = 2;
		constraints.gridx = 0;
		add(authorlabel, constraints);
        author=new JTextField(30);
        constraints.gridx= 2;
        add(author, constraints);
        
		yearlabel = new JLabel("Year:");
                yearlabel.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		constraints.gridy = 3;
		constraints.gridx = 0;
		add(yearlabel, constraints);
        year=new JTextField(30);
        constraints.gridx= 2;
        add(year, constraints);
        
		commentlabel = new JLabel("Comment:");
                commentlabel.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		constraints.gridy = 4;
		constraints.gridx = 0;
		add(commentlabel, constraints);
		comment = new JTextArea("", 6, 30);  
		comment.setFont(new Font("Serif", Font.ITALIC, 16));
		comment.setLineWrap(true);
		comment.setWrapStyleWord(true);
        constraints.gridx= 2;
        //constraints.gridy = 2;
        add(comment, constraints);
		
        gradePanel = new JPanel();
        gradePanel.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        //gradePanel.setLayout(new GridBagLayout());
		gradelabel = new JLabel("Grade:");
                gradelabel.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		constraints.gridy = 5;
		constraints.gridx = 0;
		add(gradelabel, constraints);
		gradegroup = new ButtonGroup();	
                None.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
                A.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
                B.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
                C.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
                D.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
                E.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		gradegroup.add(None);
		gradegroup.add(A);
		gradegroup.add(B);
		gradegroup.add(C);
		gradegroup.add(D);
		gradegroup.add(E);
		
		gradePanel.add(None);
        gradePanel.add(A);
        gradePanel.add(B);
        gradePanel.add(C);
        gradePanel.add(D);
        gradePanel.add(E);
        constraints.gridx= 2;
        add(gradePanel, constraints);
        
        constraints.gridy = 6;
		constraints.gridx = 0;
        addBook = new JButton("Add");
        Font b = addBook.getFont();
        // bold
        addBook.setFont(b.deriveFont(b.getStyle() | Font.BOLD));
        add(addBook, constraints);
        addBook.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) 
            {
            
               String grade = null;
               if(None.isSelected())
            	   grade = None.getText();
               if(A.isSelected())
            	   grade = A.getText();
               if(B.isSelected())
            	   grade = B.getText();
               if(C.isSelected())
            	   grade = C.getText();
               if(D.isSelected())
            	   grade = D.getText();
               if(E.isSelected())
            	   grade = E.getText();
               
         	   addBook(title.getText(), author.getText(), year.getText(), comment.getText(), grade);
         	   refreshData();
         	   dispose();
                
            }
        });
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(600, 600);
       
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
