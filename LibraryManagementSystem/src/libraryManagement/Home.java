package libraryManagement;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener{
	
	JButton employee, add, ViewEmp, issue, Return, Remove, ViewBook;
	
	Home() {
		
		setLayout(null);
		setTitle("HCL Library Management System - Home");
        ImageIcon favicon = new ImageIcon(ClassLoader.getSystemResource("icons/Hcl.jpg"));
        setIconImage(favicon.getImage());
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Homee.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
    	JLabel image = new JLabel(i3);
    	image.setBounds(0, 0, 1120, 630);
    	add(image);
    	
    	JLabel heading = new JLabel("LIBRARY MANAGEMENT SYSTEM");
    	heading.setBounds(520, 20, 550, 40);
    	heading.setFont(new Font("ALGERIAN", Font.BOLD, 35));
    	image.add(heading);
		
    	employee = new JButton("New Employee");
    	employee.setBounds(650, 80, 150, 40);
    	employee.addActionListener(this);
    	image.add(employee);
    	
    	ViewEmp = new JButton("View Employee");
    	ViewEmp.setBounds(820, 80, 150, 40);
    	ViewEmp.addActionListener(this);
    	image.add(ViewEmp);
    	
    	add = new JButton("Add Book");
    	add.setBounds(650, 140, 150, 40);
    	add.addActionListener(this);
    	image.add(add);
    	
    	ViewBook = new JButton("View Book");
    	ViewBook.setBounds(820, 140, 150, 40);
    	ViewBook.addActionListener(this);
    	image.add(ViewBook);
    	
    	issue = new JButton("Issue Book");
    	issue.setBounds(650, 200, 150, 40);
    	issue.addActionListener(this);
    	image.add(issue);
    	
    	Return = new JButton("Return Book");
    	Return.setBounds(820, 200, 150, 40);
    	Return.addActionListener(this);
    	image.add(Return);
    	
    	Remove = new JButton("Remove Book");
    	Remove.setBounds(740, 260, 150, 40);
    	Remove.addActionListener(this);
    	image.add(Remove);
    	
		setSize(1120, 630);
		setLocation(250, 100);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Home();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == employee) {
			setVisible(false);
			new NewEmployee();
		}else if (ae.getSource() == ViewEmp) {
			setVisible(false);
			new ViewEmployee();
		}else if (ae.getSource() == add) {
			setVisible(false);
			new AddBook();
		}else if (ae.getSource() == ViewBook) {
				setVisible(false);
				new ViewBook();
		}else if (ae.getSource() == issue) {
			setVisible(false);
			new IssueBook();
		}else if (ae.getSource() == Return) {
			setVisible(false);
			new ReturnBook();
		}else {
			setVisible(false);
			new RemoveBook();
		}
		
	}
}
