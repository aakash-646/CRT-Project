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


public class NewEmployee extends JFrame implements ActionListener {

	JTextField tfname, tfid, tfemail, tfno;
	JComboBox tfdep;
	JButton add, back;
	
	
	NewEmployee(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	
		setTitle("HCL Library Management System - Add New Employee in Libarary ");
        ImageIcon favicon = new ImageIcon(ClassLoader.getSystemResource("icons/Hcl.jpg"));
        setIconImage(favicon.getImage());
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
    	JLabel image = new JLabel(i3);
    	image.setBounds(0, 0, 900, 700);
    	add(image);
		
		JLabel heading = new JLabel("ADD NEW EMPLOYEE DETAILS");
		heading.setBounds(200, 30, 500, 50);
		heading.setFont(new Font("ALGERIAN", Font.BOLD, 30));
		heading.setForeground(Color.WHITE);
		image.add(heading);
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(200, 150, 150, 30);
		labelname.setFont(new Font("serif", Font.BOLD, 20));
		labelname.setForeground(Color.WHITE);
		image.add(labelname);
		
		tfname = new JTextField();
		tfname.setBounds(400, 150, 250, 30);
		add(tfname);
		
		JLabel labelid = new JLabel("SAP ID");
		labelid.setBounds(200, 200, 150, 30);
		labelid.setFont(new Font("serif", Font.BOLD, 20));
		labelid.setForeground(Color.WHITE);
		image.add(labelid);
		
		tfid = new JTextField();
		tfid.setBounds(400, 200, 250, 30);
		add(tfid); 
		
		JLabel labelemail = new JLabel("Email Address");
		labelemail.setBounds(200, 250, 150, 30);
		labelemail.setFont(new Font("serif", Font.BOLD, 20));
		labelemail.setForeground(Color.WHITE);
		image.add(labelemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(400, 250, 250, 30);
		add(tfemail);
		
		JLabel labelno = new JLabel("Phone Number");
		labelno.setBounds(200, 300, 150, 30);
		labelno.setFont(new Font("serif", Font.BOLD, 20));
		labelno.setForeground(Color.WHITE);
		image.add(labelno);
		
		tfno = new JTextField();
		tfno.setBounds(400, 300, 250, 30);
		add(tfno); 
		
		JLabel labeldep = new JLabel("Department");
		labeldep.setBounds(200, 350, 150, 30);
		labeldep.setFont(new Font("serif", Font.BOLD, 20));
		labeldep.setForeground(Color.WHITE);
		image.add(labeldep);
		
		String department[] = {" ","ERS", "INFRA", "APPS", "SD"};
		tfdep = new JComboBox(department);
		tfdep.setBackground(Color.WHITE);
	//	tfdep.setForeground(Color.WHITE);
		tfdep.setBounds(400, 350, 250, 30);
		image.add(tfdep);
		
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
		new NewEmployee();

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			String name = tfname.getText();
			String id = tfid.getText();
			String email = tfemail.getText();
			String no = tfno.getText();
			String dep = (String) tfdep.getSelectedItem();
			
			try {
				Conn conn = new Conn();
				String query = "insert into newemployee values('"+name+"', '"+id+"', '"+email+"', '"+no+"', '"+dep+"')";
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