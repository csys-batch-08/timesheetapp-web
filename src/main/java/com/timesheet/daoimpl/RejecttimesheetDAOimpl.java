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
		List<Rejecttimesheet> statuslist =new ArrayList<>();
		String selectquery="select td.task_name,s.timesheet_id,ts.timesheet_for_date,ts.spend_time_hrs,ts.comments,s.status,s.approved_by from (status s inner join timesheets ts on s.timesheet_id=ts.timesheet_id inner join task_details td on td.task_id=ts.task_id) where s.status='Rejected'and ts.timesheet_status='Active' and td.assigned_to=?";
		Connection con=null;
		PreparedStatement preparestatement=null;
		ResultSet resultset=null;
		try
		{
			con=Connectionutil.getDbConnection();
			preparestatement=con.prepareStatement(selectquery);	
			preparestatement.setString(1,username);
			resultset=preparestatement.executeQuery();
		while(resultset.next())
		{
			Rejecttimesheet rejectTimesheet=new Rejecttimesheet(resultset.getString(1),resultset.getInt(2),resultset.getDate(3),resultset.getInt(4),resultset.getString(5),resultset.getString(7),resultset.getString(6));
			statuslist.add(rejectTimesheet);
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
