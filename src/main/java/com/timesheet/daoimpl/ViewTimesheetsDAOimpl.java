package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.dao.ViewTimesheetsDAO;
import com.timesheet.model.ViewTimesheets;
import com.timesheet.util.Connectionutil;

public class ViewTimesheetsDAOimpl implements ViewTimesheetsDAO {
	public List<ViewTimesheets> showAllTimesheet()
	{
		List<ViewTimesheets> timesheetlist=new ArrayList<ViewTimesheets>();
		String selectquery="select distinct ud.user_name,ts.comments,ts.spend_time_hrs,ts.timesheet_for_date,ts.task_id,ts.timesheet_id,NVL(s.status,'Not Yet Approved')as status from status s right join timesheets ts on s.timesheet_id=ts.timesheet_id inner join user_details ud on ud.user_id=ts.user_id	";
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
			ViewTimesheets timesheet=new ViewTimesheets(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDate(4).toLocalDate(),rs.getInt(5),rs.getInt(6),rs.getString(7));
			timesheetlist.add(timesheet);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
//			System.out.println("somthing went wrong");
		}
		
		return timesheetlist;
	}
	public List<ViewTimesheets> showTimesheet(String username,String startdate,String enddate)
	{
		System.out.println(username+" "+startdate+" "+enddate);
	List<ViewTimesheets> timesheetlist=new ArrayList<ViewTimesheets>();
	String selectquery="select ud.user_name,ts.timesheet_for_date,ts.spend_time_hrs,NVL(s.status,'Not Approved')as status from (status s right join timesheets ts on s.timesheet_id=ts.timesheet_id inner join user_details ud on ud.user_id=ts.user_id) where user_name='"+username+"' and to_char(timesheet_for_date,'yyyy-MM-dd') between'"+startdate+"' and '"+enddate+"'";
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
		ViewTimesheets timesheet=new ViewTimesheets(rs.getString(1),null,rs.getInt(3),rs.getDate(2).toLocalDate(),0,0,rs.getString(4));
		timesheetlist.add(timesheet);
	}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
//		System.out.println("somthing went wrong");
	}
	
	return timesheetlist;
	}
	
}
