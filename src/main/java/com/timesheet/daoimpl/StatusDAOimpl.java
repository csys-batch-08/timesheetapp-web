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
			Connection con=null;
			PreparedStatement preparestatement=null;
			try
			{
				con=Connectionutil.getDbConnection();
				preparestatement=con.prepareStatement(insertquery);
				preparestatement.setInt(1,status.getUserid());
				preparestatement.setInt(2,status.getTimesheetid());
				preparestatement.setString(3,status.getStatus());
				preparestatement.setString(4,status.getApprovedby());
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
	 public boolean updateStatus(Status status)
	 {
		 boolean flag=false;
		 String updatequery="update status set status=? where timesheet_id=?";
		 Connection con=null;
			PreparedStatement preparestatement=null;
			try
			{
				con=Connectionutil.getDbConnection();
				preparestatement=con.prepareStatement(updatequery);
				preparestatement.setString(1,status.getStatus());
				preparestatement.setInt(2,status.getTimesheetid());
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
	 public List<Status> showStatus(int timesheetid)
	 {
		List<Status> statuslist =new ArrayList<>();
		String selectquery="select user_id,timesheet_id,status,approved_by from status where timesheet_id=?";
		Connection con=null;
		PreparedStatement preparestatement=null;
		ResultSet resultset=null;
		try
		{
			con=Connectionutil.getDbConnection();
			preparestatement=con.prepareStatement(selectquery);	
			preparestatement.setInt(1,timesheetid);
			resultset=preparestatement.executeQuery();
		while(resultset.next())
		{
			Status status=new Status(resultset.getInt(1),resultset.getInt(2),resultset.getString(3),resultset.getString(4));
			statuslist.add(status);
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
		return statuslist; 
	 }
	 public List<Status> showallStatus()
	 {
		List<Status> statuslist =new ArrayList<>();
		String selectquery="select user_id,timesheet_id,status,approved_by from status";
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
			Status status=new Status(resultset.getInt(1),resultset.getInt(2),resultset.getString(3),resultset.getString(4));
			statuslist.add(status);
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
		return statuslist; 
	 }

}
