package libraryManagement;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Splash extends JFrame implements ActionListener{
    
    Splash() {
    	
    	getContentPane().setBackground(Color.WHITE);
    	setLayout(null);
    	setTitle("HCL Library Management System - Welcome");
        ImageIcon favicon = new ImageIcon(ClassLoader.getSystemResource("icons/Hcl.jpg"));
        setIconImage(favicon.getImage());
    	
    	JLabel heading = new JLabel("LIBRARY MANAGEMENT SYSTEM");
    	heading.setBounds(100, 30, 1200, 60);
    	heading.setFont(new Font("ALGERIAN", Font.BOLD, 60));
    	heading.setForeground(Color.BLACK);
    	add(heading);
    	
    	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Library.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
    	JLabel image = new JLabel(i3);
    	image.setBounds(0, 0, 1120, 630);
    	add(image);
    	

    	JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
    	clickhere.setBounds(400, 500, 300, 70);
    	clickhere.setBackground(Color.BLACK);
    	clickhere.setForeground(Color.WHITE);
    	clickhere.addActionListener(this);
    	image.add(clickhere);
    	image.add(clickhere);
    	
    	
    	setSize(1120, 630);
		setLocation(250, 100);
        setVisible(true);
        
        while(true) {
        	heading.setVisible(false);
        	try {
        		Thread.sleep(500);
        	}
        	catch(Exception e) {
        		
        	}
        	heading.setVisible(true);
        	try {
        		Thread.sleep(500);
        	}
        	catch(Exception e) {
        		
        	}
        }
        
    }
    public static void main(String args[]){
        new Splash();
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
    	new Login();
		
	}
}