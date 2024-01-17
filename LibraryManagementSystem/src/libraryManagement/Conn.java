package libraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

	Connection c; 
	Statement s;
	
	
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///library_m_system", "root", "AAkAsh#2004");
			s = c.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
