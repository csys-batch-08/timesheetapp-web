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

public class UserDAOimpl implements UserDAO 
{
	public boolean insertUser(User user)
	{
		boolean flag=false;
		String insertquery="insert into user_details(first_name,last_name,user_name,password)values(?,?,?,?)";
		
		Connection con=null;
		PreparedStatement preparestatement=null;
		try
		{
			con=Connectionutil.getDbConnection();
			preparestatement=con.prepareStatement(insertquery);
			preparestatement.setString(1, user.getFirstname());
			preparestatement.setString(2, user.getLastname());
			preparestatement.setString(3, user.getUsername());
			preparestatement.setString(4, user.getPassword());
			if(preparestatement.executeUpdate()>0)
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (preparestatement != null) {
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	public User validateUser(String username,String password)
	{
		String validatequery="select first_name,last_name,user_name,password from user_details where role='TEAM MEMBER'and user_name='"+username+"'and password='"+password+"'";
		Connection con=null;
		Statement statement=null;
		ResultSet resultset=null;
		User user=null;
		try {
			con=Connectionutil.getDbConnection();
			 statement=con.createStatement();
			 resultset=statement.executeQuery(validatequery);
			if(resultset.next())
			{
				user=new User(resultset.getString(1),resultset.getString(2), username,password );
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally
		{
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
		
	}
	public boolean updateUser(User user)
	{
		boolean flag=false;
		String updatequery="update user_details set first_name=?,last_name=?,password=? where user_name=?";
		Connection con=null;
		PreparedStatement preparestatement=null;
		try
		{
			con=Connectionutil.getDbConnection();
			preparestatement=con.prepareStatement(updatequery);
			preparestatement.setString(1, user.getFirstname());
			preparestatement.setString(2, user.getLastname());
			preparestatement.setString(3, user.getPassword());
			preparestatement.setString(4, user.getUsername());
			if(preparestatement.executeUpdate()>0)
			{
				flag=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (preparestatement != null) {
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	

	
	public List<User> showuser(String username)
	{
		List<User> userlist=new ArrayList<>();
		String selectquery="select first_name,last_name,user_name,password from user_details where user_name='"+username+"'";
		
		Connection con=null;
		PreparedStatement preparestatement=null;
		ResultSet resultset=null;
		try
		{
			con=Connectionutil.getDbConnection();
			preparestatement=con.prepareStatement(selectquery);	
			resultset=preparestatement.executeQuery();
		while(resultset.next())
		{
			User user=new User(resultset.getString(1),resultset.getString(2),resultset.getString(3),resultset.getString(4));
			userlist.add(user);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparestatement != null) {
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userlist;
		
	}
	
	public int findUserId(String username)
	{
		String findUser="select user_id from user_details where user_name= '"+username+"'";
		Connection con=null;
		Statement statement=null;
		ResultSet resultset=null;
		int userId=0;
		try {
			con=Connectionutil.getDbConnection();
			statement = con.createStatement();
			 resultset=statement.executeQuery(findUser);
			if(resultset.next())
			{
			userId=resultset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userId;
	}
}
