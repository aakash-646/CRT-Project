package libraryManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddBook extends JFrame implements ActionListener {

	JTextField tfBookID, tfBookName, tfAuthor ;
	JComboBox  tfPublishyear, tfAvailable;
	JButton add, back;
	
	
	AddBook(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("HCL Library Management System - Add Book");
        ImageIcon favicon = new ImageIcon(ClassLoader.getSystemResource("icons/Hcl.jpg"));
        setIconImage(favicon.getImage());
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
    	JLabel image = new JLabel(i3);
    	image.setBounds(0, 0, 900, 700);
    	add(image);
		
		JLabel heading = new JLabel("ADD NEW BOOK DETAILS");
		heading.setBounds(250, 30, 500, 50);
		heading.setFont(new Font("ALGERIAN", Font.BOLD, 30));
		heading.setForeground(Color.WHITE);
		image.add(heading);
		
		JLabel labelBookID = new JLabel("Book ID");
		labelBookID.setBounds(200, 150, 150, 30);
		labelBookID.setFont(new Font("serif", Font.BOLD, 20));
		labelBookID.setForeground(Color.WHITE);
		image.add(labelBookID);
		
		tfBookID = new JTextField();
		tfBookID.setBounds(400, 150, 250, 30);
		add(tfBookID);
		
		JLabel labelBookName = new JLabel("Book Name");
		labelBookName.setBounds(200, 200, 150, 30);
		labelBookName.setFont(new Font("serif", Font.BOLD, 20));
		labelBookName.setForeground(Color.WHITE);
		image.add(labelBookName);
		
		tfBookName = new JTextField();
		tfBookName.setBounds(400, 200, 250, 30);
		add(tfBookName);
		
		JLabel labelAvailable = new JLabel("Available In");
		labelAvailable.setBounds(200, 250, 150, 30);
		labelAvailable.setFont(new Font("serif", Font.BOLD, 20));
		labelAvailable.setForeground(Color.WHITE);
		image.add(labelAvailable);
		
		String lan[] = {" ","English","Hindi","Tamil","French","German"};
		tfAvailable = new JComboBox(lan);
		tfAvailable.setBounds(400, 250, 250, 30);
		image.add(tfAvailable);
		
		JLabel labelAuthor = new JLabel("Author");
		labelAuthor.setBounds(200, 300, 150, 30);
		labelAuthor.setFont(new Font("serif", Font.BOLD, 20));
		labelAuthor.setForeground(Color.WHITE);
		image.add(labelAuthor);
		
		tfAuthor = new JTextField();
		tfAuthor.setBounds(400, 300, 250, 30);
		add(tfAuthor); 
		
		JLabel labelPublishyear = new JLabel("Publish Year");
		labelPublishyear.setBounds(200, 350, 150, 30);
		labelPublishyear.setFont(new Font("serif", Font.BOLD, 20));
		labelPublishyear.setForeground(Color.WHITE);
		image.add(labelPublishyear);
		
		String year[] = {" ","2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008","2009","2010","2011",
				"2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
		tfPublishyear = new JComboBox(year);
		tfPublishyear.setBounds(400, 350, 250, 30);
		image.add(tfPublishyear);
		
		add = new JButton("Add Details");
    	add.setBounds(200, 480, 150, 40);
    	add.addActionListener(this);
    	add.setBackground(Color.BLACK);
    	add.setForeground(Color.WHITE);
    	image.add(add);
    	
    	back = new JButton("Back");
    	back.setBounds(500, 480, 150, 40);
    	back.addActionListener(this);
    	back.setBackground(Color.BLACK);
    	back.setForeground(Color.WHITE);
    	image.add(back);
		
		setSize(900, 700);
		setLocation(300, 50);
		setVisible(true);
	}
	public static void main(String[] args) {
		new AddBook();

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			String BookID = tfBookID.getText();
			String BookName = tfBookName.getText();
			String Available = (String) tfAvailable.getSelectedItem();
			String Author = tfAuthor.getText();
			String Publishyear = (String) tfPublishyear.getSelectedItem();
			
			
			try {
				Conn conn = new Conn();
				String query = "insert into addbook values('"+BookID+"', '"+BookName+"','"+Available+"', '"+Author+"', '"+Publishyear+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details added successfully");
				setVisible(false);
				new Home();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new Home();
		}		
	}
}