package com.timesheet.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.dao.AdminDAO;
import com.timesheet.model.AdminUser;
import com.timesheet.model.User;
import com.timesheet.util.Connectionutil;

public class AdminDAOimpl implements AdminDAO
{
	public User validateAdmin(String username,String password)
	{
		String checkquery="select first_name,last_name,user_name,password from user_details where role='ADMIN'and user_name='"+username+"'and password='"+password+"'";
		Connection con=null;
		 User user=null;
		 Statement statement=null;
		 ResultSet resultset=null;
		try {
			con=Connectionutil.getDbConnection();
			 statement=con.createStatement();
			resultset=statement.executeQuery(checkquery);
			if(resultset.next())
			{
				user=new User(resultset.getString(1),resultset.getString(2), username,password);
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
	public List<AdminUser> showalluser()
	{
		List<AdminUser> userlist=new ArrayList<>();
		String selectquery="select first_name,last_name,user_name,role from user_details where role not in('ADMIN')";
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
			AdminUser user=new AdminUser(resultset.getString(1),resultset.getString(2),resultset.getString(3),resultset.getString(4));
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
	public List<AdminUser> showusers()
	{
		List<AdminUser> userlist=new ArrayList<>();
		String selectquery="select first_name,last_name,user_name,role from user_details where role not in('ADMIN','IN ACTIVE')";
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
			AdminUser user=new AdminUser(resultset.getString(1),resultset.getString(2),resultset.getString(3),resultset.getString(4));
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
	public boolean removeUser(String username,String role)
	{
		boolean flag=false;
		String removequery="update user_details set role=? where user_name=?";
		Connection con=null;
		PreparedStatement preparestatement=null;
		try
		{
			con=Connectionutil.getDbConnection();
			preparestatement=con.prepareStatement(removequery);
			preparestatement.setString(1,role);
			preparestatement.setString(2,username);
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
	}
	
