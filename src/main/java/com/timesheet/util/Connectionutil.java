package com.timesheet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionutil {
	private Connectionutil()
	{
		super();
	}
	public static Connection getDbConnection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "system", "oracle");
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} 
		return con;
	}

}
