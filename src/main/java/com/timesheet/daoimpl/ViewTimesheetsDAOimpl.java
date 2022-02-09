package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.timesheet.dao.ViewTimesheetsDAO;
import com.timesheet.logger.Logger;
import com.timesheet.model.ViewTimesheets;
import com.timesheet.util.Connectionutil;

public class ViewTimesheetsDAOimpl implements ViewTimesheetsDAO {
	public List<ViewTimesheets> showAllTimesheet() {
		List<ViewTimesheets> timesheetlist = new ArrayList<>();
		String selectQuery = "select distinct ud.user_name,ts.comments,ts.spend_time_hrs,ts.timesheet_for_date,ts.task_id,ts.timesheet_id,NVL(s.status,'Not Yet Approved')as status from status s right join timesheets ts on s.timesheet_id=ts.timesheet_id inner join user_details ud on ud.user_id=ts.user_id where ts.timesheet_status='Active'";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectQuery);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				ViewTimesheets timesheet = new ViewTimesheets(resultset.getString("user_name"), resultset.getString("comments"),
						resultset.getInt("spend_time_hrs"), resultset.getDate("timesheet_for_date").toLocalDate(), resultset.getInt("task_id"),
						resultset.getInt("timesheet_id"), resultset.getString(7));
				timesheetlist.add(timesheet);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return timesheetlist;
	}

	public List<ViewTimesheets> showTimesheet(String username, String startdate, String enddate) {
		List<ViewTimesheets> timesheetlist = new ArrayList<>();
		String selectquery = "select ud.user_name,ts.timesheet_for_date,ts.spend_time_hrs,NVL(s.status,'Not Approved')as status from (status s right join timesheets ts on s.timesheet_id=ts.timesheet_id inner join user_details ud on ud.user_id=ts.user_id) where ts.timesheet_status='Active' and user_name=? and to_char(timesheet_for_date,'yyyy-MM-dd') between ? and ?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			preparestatement.setString(1, username);
			preparestatement.setString(2, startdate);
			preparestatement.setString(3, enddate);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				ViewTimesheets timesheet = new ViewTimesheets(resultset.getString("user_name"), null, resultset.getInt("spend_time_hrs"),
						resultset.getDate("timesheet_for_date").toLocalDate(), 0, 0, resultset.getString(4));
				timesheetlist.add(timesheet);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return timesheetlist;
	}
}
