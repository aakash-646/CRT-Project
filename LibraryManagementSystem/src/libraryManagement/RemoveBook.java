package libraryManagement;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveBook extends JFrame implements ActionListener {
    
    Choice cbookid;
    JButton delete, back;
    
    RemoveBook() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
     
        setTitle("HCL Library Management System - Remove Book");
        ImageIcon favicon = new ImageIcon(ClassLoader.getSystemResource("icons/Hcl.jpg"));
        setIconImage(favicon.getImage());
        
        JLabel labelBookID = new JLabel("Book Id");
        labelBookID.setBounds(50, 50, 100, 30);
        add(labelBookID);
        
        cbookid = new Choice();
        cbookid.setBounds(200, 50, 150, 30);
        add(cbookid);
        
        try {
            Conn c = new Conn();
            String query = "select * from addbook";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cbookid.add(rs.getString("BookID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelBookName = new JLabel("Book Name");
        labelBookName.setBounds(50, 100, 100, 30);
        add(labelBookName);
        
        JLabel lblBookName = new JLabel();
        lblBookName.setBounds(200, 100, 100, 30);
        add(lblBookName);
        
        JLabel labelAuthor = new JLabel("Author");
        labelAuthor.setBounds(50, 150, 100, 30);
        add(labelAuthor);
        
        JLabel lblAuthor = new JLabel();
        lblAuthor.setBounds(200, 150, 100, 30);
        add(lblAuthor);
        
        try {
            Conn c = new Conn();
            String query = "select * from addbook where BookID = '"+cbookid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblBookName.setText(rs.getString("BookName"));
                lblAuthor.setText(rs.getString("Author"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cbookid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from addbook where BookID = '"+cbookid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblBookName.setText(rs.getString("BookName"));
                        lblAuthor.setText(rs.getString("Author"));
                        
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from addbook where BookID = '"+cbookid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Book Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveBook();
    }
}