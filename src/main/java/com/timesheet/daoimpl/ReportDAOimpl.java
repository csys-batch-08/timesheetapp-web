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

	public List<Report> findreport(LocalDate timesheetdate, String username) {
		List<Report> reportlist = new ArrayList<>();
		String reportQuery = "select u.user_name,u.role,td.task_name,ts.timesheet_id,ts.spend_time_hrs,trunc(ts.timesheet_for_date),s.status,s.approved_by,trunc(s.status_update_date) from (user_details u inner join task_details td on u.user_id=td.user_id inner join timesheets ts on td.task_id=ts.task_id  inner join status s on ts.timesheet_id=s.timesheet_id) where ts.timesheet_for_date=? and u.user_name=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(reportQuery);
			preparestatement.setDate(1, java.sql.Date.valueOf(timesheetdate));
			preparestatement.setString(2, username);
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				Report report = new Report(resultset.getString("user_name"), resultset.getString("role"),
						resultset.getString("task_name"), resultset.getInt("timesheet_id"),
						resultset.getInt("spend_time_hrs"),
						resultset.getDate("trunc(ts.timesheet_for_date)").toLocalDate(), resultset.getString("status"),
						resultset.getString(8), resultset.getDate("trunc(s.status_update_date)").toLocalDate());
				reportlist.add(report);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return reportlist;

	}

}
