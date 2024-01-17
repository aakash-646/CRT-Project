package libraryManagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{

	JTable table;
	Choice cid;
	JButton search, back;
	
	ViewEmployee(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("HCL Library Management System - View Employee");
        ImageIcon favicon = new ImageIcon(ClassLoader.getSystemResource("icons/Hcl.jpg"));
        setIconImage(favicon.getImage());
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Background.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
    	JLabel image = new JLabel(i3);
    	image.setBounds(0, 0, 900, 700);
    	add(image);
		
		JLabel searchlbl = new JLabel("Search by SAP ID");
		searchlbl.setBounds(20, 20, 150, 20);
		searchlbl.setForeground(Color.WHITE);
		image.add(searchlbl);
		
		cid = new Choice();
		cid.setBounds(180, 20, 150, 20);
		image.add(cid);
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from newemployee");
			while(rs.next()) {
				cid.add(rs.getString("id"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from newemployee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 100, 900, 600);
		image.add(jsp);
		
		
		search = new JButton("Search");
		search.setBounds(100, 70, 80, 20);
		search.addActionListener(this);
		image.add(search);
		
		
		back = new JButton("Back");
		back.setBounds(200, 70, 80, 20);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 700);
		setLocation(300, 100);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new ViewEmployee();
		

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == search) {
			String query = "Select * from newemployee where id = '"+cid.getSelectedItem()+"'";
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new Home();
		}
		
	}

}