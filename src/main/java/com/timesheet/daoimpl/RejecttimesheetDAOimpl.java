package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.dao.RejecttimesheetDAO;
import com.timesheet.logger.Logger;
import com.timesheet.model.Rejecttimesheet;
import com.timesheet.util.Connectionutil;

public class RejecttimesheetDAOimpl implements RejecttimesheetDAO {
	public List<Rejecttimesheet> showRejecttimesheet(String userName) {
		List<Rejecttimesheet> statuslist = new ArrayList<>();
		String selectquery = "select td.task_name,s.timesheet_id,ts.timesheet_for_date,ts.spend_time_hrs,ts.comments,s.status,s.approved_by from (status s inner join timesheets ts on s.timesheet_id=ts.timesheet_id inner join task_details td on td.task_id=ts.task_id) where s.status='Rejected'and ts.timesheet_status='Active' and td.assigned_to=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			preparestatement.setString(1, userName);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				Rejecttimesheet rejectTimesheet = new Rejecttimesheet(resultset.getString("task_name"),
						resultset.getInt("timesheet_id"), resultset.getDate("timesheet_for_date"),
						resultset.getInt("spend_time_hrs"), resultset.getString("comments"),
						resultset.getString("approved_by"), resultset.getString("status"));
				statuslist.add(rejectTimesheet);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return statuslist;
	}

}
