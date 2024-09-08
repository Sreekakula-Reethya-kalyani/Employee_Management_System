package com.connection.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class ConnectionCode {
	private static Connection con=null;
	private static final String URL = "jdbc:mysql://localhost:3306/srk";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "S@reethya0608";
	
	public static Connection myConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
}