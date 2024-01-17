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

import com.toedter.calendar.JDateChooser;

public class IssueBook extends JFrame implements ActionListener {

	JTextField tfBookID, tfBookName, tfAuthor, tfSignature;
	JDateChooser dcIssuedate;
	JButton add, back;
	
	
	IssueBook(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("HCL Library Management System - Issue Book");
        ImageIcon favicon = new ImageIcon(ClassLoader.getSystemResource("icons/Hcl.jpg"));
        setIconImage(favicon.getImage());
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
    	JLabel image = new JLabel(i3);
    	image.setBounds(0, 0, 900, 700);
    	add(image);
		
		JLabel heading = new JLabel("ISSUE BOOK DETAILS");
		heading.setBounds(250, 30, 500, 50);
		heading.setFont(new Font("ALGERIAN", Font.BOLD, 35));
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
		
		JLabel labelAuthor = new JLabel("Author");
		labelAuthor.setBounds(200, 250, 150, 30);
		labelAuthor.setFont(new Font("serif", Font.BOLD, 20));
		labelAuthor.setForeground(Color.WHITE);
		image.add(labelAuthor);
		
		tfAuthor = new JTextField();
		tfAuthor.setBounds(400, 250, 250, 30);
		add(tfAuthor); 
		
		JLabel labelIssuedate = new JLabel("Issue Date");
		labelIssuedate.setBounds(200, 300, 150, 30);
		labelIssuedate.setFont(new Font("serif", Font.BOLD, 20));
		labelIssuedate.setForeground(Color.WHITE);
		image.add(labelIssuedate);
		
		dcIssuedate = new JDateChooser();
		dcIssuedate.setBounds(400, 300, 250, 30);
		image.add(dcIssuedate);
		
		JLabel labelSignature = new JLabel("Signature");
		labelSignature.setBounds(200, 350, 150, 30);
		labelSignature.setFont(new Font("serif", Font.BOLD, 20));
		labelSignature.setForeground(Color.WHITE);
		image.add(labelSignature);
		
		tfSignature = new JTextField();
		tfSignature.setBounds(400, 350, 250, 30);
		add(tfSignature);
		
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
		new IssueBook();

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			String BookID = tfBookID.getText();
			String BookName = tfBookName.getText();
			String Author = tfAuthor.getText();
			String Issuedate = ((JTextField) dcIssuedate.getDateEditor().getUiComponent()).getText();
			String Signature = tfSignature.getText();
			
			try {
				Conn conn = new Conn();
				String query = "insert into issuebook values('"+BookID+"', '"+BookName+"','"+Author+"', '"+Issuedate+"', '"+Signature+"')";
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