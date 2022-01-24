package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.dao.RejecttimesheetDAO;
import com.timesheet.model.Rejecttimesheet;
import com.timesheet.util.Connectionutil;
public class RejecttimesheetDAOimpl implements RejecttimesheetDAO 
{
	public List<Rejecttimesheet> showRejecttimesheet(String username)
	 {
		List<Rejecttimesheet> statuslist =new ArrayList<Rejecttimesheet>();
		String selectquery="select td.task_name,s.timesheet_id,ts.timesheet_for_date,ts.spend_time_hrs,ts.comments,s.status,s.approved_by from (status s inner join timesheets ts on s.timesheet_id=ts.timesheet_id inner join task_details td on td.task_id=ts.task_id) where status='Rejected' and td.assigned_to='"+username+"'";
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
			Rejecttimesheet rejectTimesheet=new Rejecttimesheet(rs.getString(1),rs.getInt(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getString(7),rs.getString(6));
			statuslist.add(rejectTimesheet);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		return statuslist; 
	 }

}
