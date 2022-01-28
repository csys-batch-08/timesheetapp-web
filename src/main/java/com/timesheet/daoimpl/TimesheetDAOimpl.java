package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.dao.TimesheetDAO;
import com.timesheet.model.Timesheet;
import com.timesheet.util.Connectionutil;

public class TimesheetDAOimpl implements TimesheetDAO 
{
	public boolean insertTimesheet(Timesheet timesheet)
	{
		boolean flag=false;
		String insertquery="insert into timesheets(user_id,task_id,spend_time_hrs,comments,timesheet_for_date)values(?,?,?,?,?)";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(insertquery);
			pstmt.setInt(1, timesheet.getUserid());
			pstmt.setInt(2, timesheet.getTaskid());
			pstmt.setInt(3, timesheet.getSpendtime());
			pstmt.setString(4,timesheet.getComments());
			pstmt.setDate(5,java.sql.Date.valueOf(timesheet.getTimesheetfordate()));
			if(pstmt.executeUpdate()>0)
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateTimesheet(Timesheet timesheet)
	{
		boolean flag=false;
		String updatequery="update timesheets set user_id=?,spend_time_hrs=?,comments=? where timesheet_for_date=?";

		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(updatequery);
			pstmt.setInt(1, timesheet.getUserid());
			pstmt.setInt(2, timesheet.getSpendtime());
			pstmt.setString(3,timesheet.getComments());
			pstmt.setDate(4,java.sql.Date.valueOf(timesheet.getTimesheetfordate()));
			if(pstmt.executeUpdate()>0)
			{
				flag=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public boolean checkDate(int userid,LocalDate timesheetdate)
	{
		String query="select user_id,task_id,spend_time_hrs,comments,timesheet_for_date from timesheets where user_id='"+userid+"' and to_char(Timesheet_for_date,'yyyy-MM-dd')='"+timesheetdate+"'";
		Connection con=Connectionutil.getDbConnection();
		boolean flag=true;
		Statement st;
		try
		{
			st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				Timesheet timesheet=new Timesheet(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDate(5).toLocalDate());
			}
			else
			{
				flag=false; 
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public List<Timesheet> showTimesheet(int userid)
	{
		List<Timesheet> timesheetlist=new ArrayList<Timesheet>();
		String selectquery="select user_id,task_id,spend_time_hrs,comments,timesheet_for_date from timesheets where user_id='"+userid+"'";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			pstmt=con.prepareStatement(selectquery);	
			rs=pstmt.executeQuery();
		while(rs.next())
		{
			Timesheet timesheet=new Timesheet(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDate(5).toLocalDate());
			timesheetlist.add(timesheet);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return timesheetlist;
	}
	public int getSpendhrs(LocalDate timesheetdate)
	{
	 Connection con=Connectionutil.getDbConnection();	
	 String query="select spend_time_hrs from timesheets where timesheet_for_date=?";
	 int result=0;
	 PreparedStatement pstmt;
	 try {
		pstmt=con.prepareStatement(query);
		pstmt.setDate(1,java.sql.Date.valueOf(timesheetdate));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			result= rs.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return result;
		
	}
	
//	public boolean removeTimesheet(String timesheetfordate)
//	{
//	     boolean flag=false;
//		String removequery="delete from timesheets where timesheet_for_date=?";
//		Connection con=Connectionutil.getDbConnection();
//		PreparedStatement pstmt=null;
//		try
//		{
//			pstmt=con.prepareStatement(removequery);
//		    pstmt.setString(1,timesheetfordate);
//	    if(pstmt.executeUpdate()>0)
//	     {
//		  flag=true;
//	      }
//		    int i=pstmt.executeUpdate();
//            System.out.println(i+" Timesheet Remove ");
//			
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//			System.out.println("something went wrong");
//		}
//	    return flag;
//		}
	public List<Timesheet> searchTimesheet(LocalDate timesheetdate,int userid)
	{
		List<Timesheet> timesheets=new ArrayList<Timesheet>();
		String selectquery="select user_id,task_id,spend_time_hrs,comments,timesheet_for_date from timesheets where timesheet_for_date=? and user_id=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			pstmt=con.prepareStatement(selectquery);
			pstmt.setDate(1,java.sql.Date.valueOf(timesheetdate));
			pstmt.setInt(2, userid);
			rs=pstmt.executeQuery();
		while(rs.next())
		{
			Timesheet timesheet=new Timesheet(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDate(5).toLocalDate());
			timesheets.add(timesheet);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return timesheets;
	}
	
	public  int findTimesheetId(LocalDate timesheetfordate,int userid)
	{
		String findUser="select timesheet_id from timesheets where to_char(timesheet_for_date,'yyyy-MM-dd')='"+timesheetfordate+"' and user_id='"+userid+"'";
		Connection con=Connectionutil.getDbConnection();
		Statement stmt;
		int timesheetId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUser);
			if(rs.next())
			{
			timesheetId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return timesheetId;
		
	}
	public String getDate()
	{
		String query="select to_char(sysdate,'yyyy-MM-dd') from dual";
		 Connection con=Connectionutil.getDbConnection();
		 String date=null;
		 try {
			 Statement st=con.createStatement();
			 ResultSet rs=st.executeQuery(query);
			 if(rs.next())
				   {
					 date=rs.getString(1);  
				   }
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace(); 
		 }
		return date;
		
	}
	}
	
	
	
