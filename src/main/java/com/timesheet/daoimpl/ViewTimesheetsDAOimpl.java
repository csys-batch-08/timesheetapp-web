package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.timesheet.dao.ViewTimesheetsDAO;
import com.timesheet.model.ViewTimesheets;
import com.timesheet.util.Connectionutil;

public class ViewTimesheetsDAOimpl implements ViewTimesheetsDAO {
	public List<ViewTimesheets> showAllTimesheet()
	{
		List<ViewTimesheets> timesheetlist=new ArrayList<>();
		String selectquery="select distinct ud.user_name,ts.comments,ts.spend_time_hrs,ts.timesheet_for_date,ts.task_id,ts.timesheet_id,NVL(s.status,'Not Yet Approved')as status from status s right join timesheets ts on s.timesheet_id=ts.timesheet_id inner join user_details ud on ud.user_id=ts.user_id";
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
			ViewTimesheets timesheet=new ViewTimesheets(resultset.getString(1),resultset.getString(2),resultset.getInt(3),resultset.getDate(4).toLocalDate(),resultset.getInt(5),resultset.getInt(6),resultset.getString(7));
			timesheetlist.add(timesheet);
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
		return timesheetlist;
	}
	public List<ViewTimesheets> showTimesheet(String username,String startdate,String enddate)
	{
	List<ViewTimesheets> timesheetlist=new ArrayList<>();
	String selectquery="select ud.user_name,ts.timesheet_for_date,ts.spend_time_hrs,NVL(s.status,'Not Approved')as status from (status s right join timesheets ts on s.timesheet_id=ts.timesheet_id inner join user_details ud on ud.user_id=ts.user_id) where user_name='"+username+"' and to_char(timesheet_for_date,'yyyy-MM-dd') between'"+startdate+"' and '"+enddate+"'";
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
		ViewTimesheets timesheet=new ViewTimesheets(resultset.getString(1),null,resultset.getInt(3),resultset.getDate(2).toLocalDate(),0,0,resultset.getString(4));
		timesheetlist.add(timesheet);
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
	return timesheetlist;
	}
}
