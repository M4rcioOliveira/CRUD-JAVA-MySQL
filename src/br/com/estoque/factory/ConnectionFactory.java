package br.com.estoque.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	
	public static final String USERNAME = "root";
	public static final String PASSWORD = "7046";
	public static final String URL_DATABASE = "jdbc:mysql://localhost:3306/estoque";
	
	
	public static Connection createConnection() throws SQLException {
		
		Connection connection = DriverManager.getConnection(URL_DATABASE, USERNAME, PASSWORD);
		
		return connection;
		
	}
	
	
	
	public static void main (String[]args) throws SQLException {
		
		Connection conn = createConnection();
		
		
		if(conn!=null) {
			conn.close();
		}
		
	}
	

}
