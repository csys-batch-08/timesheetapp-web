package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.timesheet.dao.TimesheetDAO;
import com.timesheet.model.Timesheet;
import com.timesheet.util.Connectionutil;

public class TimesheetDAOimpl implements TimesheetDAO {
	public boolean insertTimesheet(Timesheet timesheet) {
		boolean flag = false;
		String insertquery = "insert into timesheets(user_id,task_id,spend_time_hrs,comments,timesheet_for_date)values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(insertquery);
			preparestatement.setInt(1, timesheet.getUserid());
			preparestatement.setInt(2, timesheet.getTaskid());
			preparestatement.setInt(3, timesheet.getSpendtime());
			preparestatement.setString(4, timesheet.getComments());
			preparestatement.setDate(5, java.sql.Date.valueOf(timesheet.getTimesheetfordate()));
			if (preparestatement.executeUpdate() > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closePreparedstatement(con, preparestatement);
		}
		return flag;
	}

	public boolean updateTimesheet(Timesheet timeheets) {
		boolean flag = false;
		String updatequery = "update timesheets set user_id=?,spend_time_hrs=?,comments=? where timesheet_status='Active' and timesheet_for_date=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(updatequery);
			preparestatement.setInt(1, timeheets.getUserid());
			preparestatement.setInt(2, timeheets.getSpendtime());
			preparestatement.setString(3, timeheets.getComments());
			preparestatement.setDate(4, java.sql.Date.valueOf(timeheets.getTimesheetfordate()));
			if (preparestatement.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closePreparedstatement(con, preparestatement);
		}
		return flag;
	}

	public boolean checkDate(int userid, LocalDate timesheetdate) {
		String checkDateQuery = "select user_id,task_id,spend_time_hrs,comments,timesheet_for_date from timesheets where timesheet_status='Active' and user_id=? and Timesheet_for_date=?";
		Connection con = null;
		boolean flag = true;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(checkDateQuery);
			preparestatement.setInt(1, userid);
			preparestatement.setDate(2, java.sql.Date.valueOf(timesheetdate));
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				Timesheet timesheet = new Timesheet(resultset.getInt("user_id"), resultset.getInt("task_id"),
						resultset.getInt("spend_time_hrs"), resultset.getString("comments"),
						resultset.getDate("timesheet_for_date").toLocalDate());
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return flag;
	}

	public List<Timesheet> showTimesheet(int userid) {
		List<Timesheet> timesheetlist = new ArrayList<>();
		String selectquery = "select user_id,task_id,spend_time_hrs,comments,timesheet_for_date from timesheets where timesheet_status='Active' and user_id=? order by timesheet_for_date desc";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			preparestatement.setInt(1, userid);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				Timesheet timesheet = new Timesheet(resultset.getInt("user_id"), resultset.getInt("task_id"),
						resultset.getInt("spend_time_hrs"), resultset.getString("comments"),
						resultset.getDate("timesheet_for_date").toLocalDate());
				timesheetlist.add(timesheet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return timesheetlist;
	}

	public int getSpendhrs(LocalDate timesheetdate) {
		Connection con = null;
		String getHrsQuery = "select spend_time_hrs from timesheets where timesheet_status='Active' and timesheet_for_date=?";
		int result = 0;
		ResultSet resultset = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(getHrsQuery);
			preparestatement.setDate(1, java.sql.Date.valueOf(timesheetdate));
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				result = resultset.getInt("spend_time_hrs");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return result;
	}

	public boolean removeTimesheet(String timesheetfordate, String timesheetStatus) {
		boolean flag = false;
		String removequery = "update timesheets set timesheet_status=? where to_char(timesheet_for_date,'yyyy-MM-dd')=?";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement preparestatement = null;
		try {
			preparestatement = con.prepareStatement(removequery);
			preparestatement.setString(1, timesheetStatus);
			preparestatement.setString(2, timesheetfordate);
			if (preparestatement.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connectionutil.closePreparedstatement(con, preparestatement);
		}
		return flag;
	}

	public List<Timesheet> searchTimesheet(LocalDate timesheetdate, int userid) {
		List<Timesheet> timesheets = new ArrayList<>();
		String selectquery = "select user_id,task_id,spend_time_hrs,comments,timesheet_for_date from timesheets where timesheet_status='Active' and timesheet_for_date=? and user_id=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			preparestatement.setDate(1, java.sql.Date.valueOf(timesheetdate));
			preparestatement.setInt(2, userid);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				Timesheet timesheet = new Timesheet(resultset.getInt("user_id"), resultset.getInt("task_id"),
						resultset.getInt("spend_time_hrs"), resultset.getString("comments"),
						resultset.getDate("timesheet_for_date").toLocalDate());
				timesheets.add(timesheet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return timesheets;
	}

	public int findTimesheetId(LocalDate timesheetfordate, int userid) {
		String findUser = "select timesheet_id from timesheets where timesheet_status='Active' and timesheet_for_date=? and user_id=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		int timesheetId = 0;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(findUser);
			preparestatement.setDate(1, java.sql.Date.valueOf(timesheetfordate));
			preparestatement.setInt(2, userid);
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				timesheetId = resultset.getInt("timesheet_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return timesheetId;
	}

	public String getDate() {
		String getDateQuery = "select to_char(sysdate,'yyyy-MM-dd') from dual";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		String date = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(getDateQuery);
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				date = resultset.getString("to_char(sysdate,'yyyy-MM-dd')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectionutil.closeResultSet(resultset, con, preparestatement);
		}
		return date;

	}
}
