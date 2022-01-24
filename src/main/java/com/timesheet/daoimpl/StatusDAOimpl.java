package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.dao.StatusDAO;
import com.timesheet.model.Status;
import com.timesheet.util.Connectionutil;
public class StatusDAOimpl implements StatusDAO
{
	 public boolean insertStatus(Status status)
	 {
		 boolean flag=false;
		 String insertquery="insert into status(user_id,timesheet_id,status,approved_by)values(?,?,?,?)";
		 Connectionutil conutil=new Connectionutil();
			Connection con=conutil.getDbConnection();
			PreparedStatement pstmt=null;
			try
			{
				pstmt=con.prepareStatement(insertquery);
				pstmt.setInt(1,status.getUserid());
				pstmt.setInt(2,status.getTimesheetid());
				pstmt.setString(3,status.getStatus());
				pstmt.setString(4,status.getApprovedby());
				if(pstmt.executeUpdate()>0)
				{
					flag=true;
				}
//				System.out.println("Status add successfully");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("somthing went wrong");
			}
			return flag;
	 }
	 public boolean updateStatus(Status status)
	 {
		 boolean flag=false;
		 String updatequery="update status set status=? where timesheet_id=?";
		 Connection con=Connectionutil.getDbConnection();
			PreparedStatement pstmt=null;
			try
			{
				pstmt=con.prepareStatement(updatequery);
				pstmt.setString(1,status.getStatus());
				pstmt.setInt(2,status.getTimesheetid());
				if(pstmt.executeUpdate()>0)
				{
					flag=true;
				}
//				System.out.println(i+" Status updated");
	          }
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("something went wrong");
			}
			return flag;
    }
	 public List<Status> showStatus(int timesheetid)
	 {
		List<Status> statuslist =new ArrayList<Status>();
		String selectquery="select user_id,timesheet_id,status,approved_by from status where timesheet_id='"+timesheetid+"'";
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
			Status status=new Status(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
			statuslist.add(status);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		return statuslist; 
	 }
	 public List<Status> showallStatus()
	 {
		List<Status> statuslist =new ArrayList<Status>();
		String selectquery="select user_id,timesheet_id,status,approved_by from status";
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
			Status status=new Status(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
			statuslist.add(status);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		return statuslist; 
	 }
//	public boolean removeStatus(int timesheetid)
//	{
//	    boolean flag=false;
//		String removequery="delete from status where timesheet_id=?";
//		Connection con=Connectionutil.getDbConnection();
//		PreparedStatement pstmt=null;
//		try
//		{
//			pstmt=con.prepareStatement(removequery);
//		    pstmt.setInt(1,timesheetid);
//		   if(pstmt.executeUpdate()>0)
//		{
//			flag=true;
//		}
//            System.out.println(i+" Status Remove ");
//			
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//			System.out.println("something went wrong");
//		}
//	 return flag;
//	}
}
