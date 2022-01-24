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
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(insertquery);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			if(pstmt.executeUpdate()>0)
			{
				flag=true;
			}
//			System.out.println("value insert successfully");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		return flag;
	}
	
	public User validateUser(String username,String password)
	{
		String validatequery="select first_name,last_name,user_name,password from user_details where role='TEAM MEMBER'and user_name='"+username+"'and password='"+password+"'";
		Connection con=Connectionutil.getDbConnection();
		User user=null;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(validatequery);
			if(rs.next())
			{
				user=new User(rs.getString(1),rs.getString(2), username,password );
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			System.out.println("Statement error");
		}
		return user;
		
	}
	public boolean updateUser(User user)
	{
		boolean flag=false;
		String updatequery="update user_details set first_name=?,last_name=?,password=? where user_name=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(updatequery);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getUsername());
			if(pstmt.executeUpdate()>0)
			{
				flag=true;
			}
//			int i=pstmt.executeUpdate();
//			System.out.println(i+" user profile updated");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("something went wrong");
		}
		return flag;
	}
	

	
	public List<User> showuser(String username)
	{
		List<User> userlist=new ArrayList<User>();
		String selectquery="select first_name,last_name,user_name,password from user_details where user_name='"+username+"'";
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
			User user=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
	
	public int findUserId(String username)
	{
		String findUser="select user_id from user_details where user_name= '"+username+"'";
		Connection con=Connectionutil.getDbConnection();
		Statement stmt;
		int userId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUser);
			if(rs.next())
			{
			userId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
		
	}
}
