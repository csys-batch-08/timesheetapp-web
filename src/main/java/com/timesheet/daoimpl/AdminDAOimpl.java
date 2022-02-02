package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.timesheet.dao.AdminDAO;
import com.timesheet.model.AdminUser;
import com.timesheet.model.User;
import com.timesheet.util.Connectionutil;

public class AdminDAOimpl implements AdminDAO {
	public User validateAdmin(String username, String password) {
		String checkquery = "select first_name,last_name,user_name,password from user_details where role='ADMIN'and user_name=? and password=?";
		Connection con = null;
		User user = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(checkquery);
			preparestatement.setString(1, username);
			preparestatement.setString(2, password);
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				user = new User(resultset.getString("First_name"), resultset.getString("Last_name"),
						resultset.getString("User_name"), resultset.getString("Password"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}

		return user;

	}

	public List<AdminUser> showalluser() {
		List<AdminUser> userslist = new ArrayList<>();
		String selectquery1 = "select first_name,last_name,user_name,role from user_details where role not in('ADMIN')";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery1);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				AdminUser users = new AdminUser(resultset.getString("First_Name"), resultset.getString("Last_Name"),
						resultset.getString("User_Name"), resultset.getString("Role"));
				userslist.add(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}

		return userslist;

	}

	public List<AdminUser> showusers() {
		List<AdminUser> userlist = new ArrayList<>();
		String selectquery = "select first_name,last_name,user_name,role from user_details where role not in('ADMIN','IN ACTIVE')";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				AdminUser user1 = new AdminUser(resultset.getString("first_name"), resultset.getString("last_name"),
						resultset.getString("user_name"), resultset.getString("role"));
				userlist.add(user1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return userlist;

	}

	public boolean removeUser(String username, String role) {
		boolean flag = false;
		String removequery = "update user_details set role=? where user_name=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(removequery);
			preparestatement.setString(1, role);
			preparestatement.setString(2, username);
			if (preparestatement.executeUpdate() > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closePreparedstatement(con, preparestatement);
		}

		return flag;
	}
}
