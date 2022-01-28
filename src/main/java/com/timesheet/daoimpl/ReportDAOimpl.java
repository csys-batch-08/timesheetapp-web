package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.timesheet.dao.ReportDAO;
import com.timesheet.model.Report;
import com.timesheet.util.Connectionutil;

public class ReportDAOimpl implements ReportDAO {
	
	public List<Report> findreport(LocalDate timesheetdate,String username)
	{
		List<Report> reportlist=new ArrayList<>();
		String query="select u.user_name,u.role,td.task_name,ts.timesheet_id,ts.spend_time_hrs,trunc(ts.timesheet_for_date),s.status,s.approved_by,trunc(s.status_update_date) from (user_details u inner join task_details td on u.user_id=td.user_id inner join timesheets ts on td.task_id=ts.task_id  inner join status s on ts.timesheet_id=s.timesheet_id) where to_char(ts.timesheet_for_date,'yyyy-MM-dd')='"+timesheetdate+"' and u.user_name='"+username+"'";
		Connection con=null;
		PreparedStatement preparestatement=null;
		ResultSet resultset=null;
		try
		{
			con=Connectionutil.getDbConnection();
			preparestatement=con.prepareStatement(query);	
			resultset=preparestatement.executeQuery();
		while(resultset.next())
		{
		Report report=new Report(resultset.getString(1),resultset.getString(2),resultset.getString(3),
				 resultset.getInt(4),resultset.getInt(5),resultset.getDate(6).toLocalDate(),resultset.getString(7),resultset.getString(8),resultset.getDate(9).toLocalDate());
		 reportlist.add(report);
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
		return reportlist;
		
	}

}
