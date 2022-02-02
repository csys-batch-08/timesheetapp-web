package com.timesheet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connectionutil {
	private Connectionutil() {
		super();
	}

	public static Connection getDbConnection() {
		Connection con = null;
		try {
			EncryptAndDecrypt decryptpassword = new EncryptAndDecrypt();
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "system";
			String password = decryptpassword.decryt();
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return con;
	}

	public static void closeResultSet(ResultSet resultset, Connection con, PreparedStatement preparestatement) {
		try {
			if (resultset != null) {
				resultset.close();
			}
			if (preparestatement != null) {
				preparestatement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closePreparedstatement(Connection con, PreparedStatement preparestatement) {
		try {
			if (preparestatement != null) {
				preparestatement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
