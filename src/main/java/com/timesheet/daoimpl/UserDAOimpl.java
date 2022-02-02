package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.dao.UserDAO;
import com.timesheet.model.User;
import com.timesheet.util.Connectionutil;

public class UserDAOimpl implements UserDAO {
	public boolean insertUser(User user) {
		boolean flag = false;
		String insertquery = "insert into user_details(first_name,last_name,user_name,password)values(?,?,?,?)";

		Connection con = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(insertquery);
			preparestatement.setString(1, user.getFirstname());
			preparestatement.setString(2, user.getLastname());
			preparestatement.setString(3, user.getUsername());
			preparestatement.setString(4, user.getPassword());
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

	public User validateUser(String userName, String userPassword) {
		String validatequery = "select first_name,last_name,user_name,password from user_details where role='TEAM MEMBER'and user_name=? and password=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		User user = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(validatequery);
			preparestatement.setString(1, userName);
			preparestatement.setString(2, userPassword);
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				user = new User(resultset.getString("first_name"), resultset.getString("last_name"), resultset.getString("user_name"), resultset.getString("password"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return user;

	}

	public boolean updateUser(User user) {
		boolean flag = false;
		String updatequery = "update user_details set first_name=?,last_name=?,password=? where user_name=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(updatequery);
			preparestatement.setString(1, user.getFirstname());
			preparestatement.setString(2, user.getLastname());
			preparestatement.setString(3, user.getPassword());
			preparestatement.setString(4, user.getUsername());
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

	public List<User> showuser(String username) {
		List<User> userlist = new ArrayList<>();
		String selectquery = "select first_name,last_name,user_name,password from user_details where user_name=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			preparestatement.setString(1, username);
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				User user = new User(resultset.getString("first_name"), resultset.getString("last_name"), resultset.getString("user_name"),
						resultset.getString("password"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return userlist;

	}

	public int findUserId(String username) {
		String findUser = "select user_id from user_details where user_name=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		int userId = 0;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(findUser);
			preparestatement.setString(1, username);
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				userId = resultset.getInt("user_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return userId;
	}
}
