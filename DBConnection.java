package mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection { 
	
	private static final String URL = "jdbc:mysql://localhost:3306/java";
	private static final String USER = "your username";
	private static final String PASS = "your password";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
}
}

