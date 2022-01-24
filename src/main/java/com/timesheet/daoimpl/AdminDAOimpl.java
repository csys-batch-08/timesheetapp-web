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
//		System.out.println(checkquery);
		Connection con=Connectionutil.getDbConnection();
		 User user=null;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(checkquery);
			if(rs.next())
			{
				user=new User(rs.getString(1),rs.getString(2), username,password);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			System.out.println("Statement error");
		}
		
	return user;
		
	}
	public List<AdminUser> showalluser()
	{
		List<AdminUser> userlist=new ArrayList<AdminUser>();
		String selectquery="select first_name,last_name,user_name,role from user_details where role not in('ADMIN')";
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			pstmt=con.prepareStatement(selectquery);	
			rs=pstmt.executeQuery();
		while(rs.next())
		{
			AdminUser user=new AdminUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			userlist.add(user);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		
		return userlist;
		
	}
	public List<AdminUser> showusers()
	{
		List<AdminUser> userlist=new ArrayList<AdminUser>();
		String selectquery="select first_name,last_name,user_name,role from user_details where role not in('ADMIN','IN ACTIVE')";
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			pstmt=con.prepareStatement(selectquery);	
			rs=pstmt.executeQuery();
		while(rs.next())
		{
			AdminUser user=new AdminUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			userlist.add(user);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		
		return userlist;
		
	}
	public boolean removeUser(String username,String role)
	{
		boolean flag=false;
		String removequery="update user_details set role=? where user_name=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(removequery);
			pstmt.setString(1,role);
			pstmt.setString(2,username);
			if(pstmt.executeUpdate()>0)
			{
				flag=true;
			}
//			int i=pstmt.executeUpdate();
//			System.out.println(i+" User details Remove ");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("something went wrong");
		}
		return flag;
	}
	}
	
