package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public boolean updateTimesheet(Timesheet timesheet) {
		boolean flag = false;
		String updatequery = "update timesheets set user_id=?,spend_time_hrs=?,comments=? where timesheet_for_date=?";

		Connection con = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(updatequery);
			preparestatement.setInt(1, timesheet.getUserid());
			preparestatement.setInt(2, timesheet.getSpendtime());
			preparestatement.setString(3, timesheet.getComments());
			preparestatement.setDate(4, java.sql.Date.valueOf(timesheet.getTimesheetfordate()));
			if (preparestatement.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	public boolean checkDate(int userid, LocalDate timesheetdate) {
		String query = "select user_id,task_id,spend_time_hrs,comments,timesheet_for_date from timesheets where user_id='"
				+ userid + "' and to_char(Timesheet_for_date,'yyyy-MM-dd')='" + timesheetdate + "'";
		Connection con = null;
		boolean flag = true;
		Statement statement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultset = statement.executeQuery(query);
			if (resultset.next()) {
				Timesheet timesheet = new Timesheet(resultset.getInt(1), resultset.getInt(2), resultset.getInt(3),
						resultset.getString(4), resultset.getDate(5).toLocalDate());
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
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

	public List<Timesheet> showTimesheet(int userid) {
		List<Timesheet> timesheetlist = new ArrayList<>();
		String selectquery = "select user_id,task_id,spend_time_hrs,comments,timesheet_for_date from timesheets where user_id='"
				+ userid + "'";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				Timesheet timesheet = new Timesheet(resultset.getInt(1), resultset.getInt(2), resultset.getInt(3),
						resultset.getString(4), resultset.getDate(5).toLocalDate());
				timesheetlist.add(timesheet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	public int getSpendhrs(LocalDate timesheetdate) {
		Connection con = null;
		String query = "select spend_time_hrs from timesheets where timesheet_for_date=?";
		int result = 0;
		ResultSet resultset = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(query);
			preparestatement.setDate(1, java.sql.Date.valueOf(timesheetdate));
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				result = resultset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return result;
	}

//	public boolean removeTimesheet(String timesheetfordate)
//	{
//	     boolean flag=false;
//		String removequery="delete from timesheets where timesheet_for_date=?";
//		Connection con=Connectionutil.getDbConnection();
//		PreparedStatement pstmt=null;
//		try
//		{
//			pstmt=con.prepareStatement(removequery);
//		    pstmt.setString(1,timesheetfordate);
//	    if(pstmt.executeUpdate()>0)
//	     {
//		  flag=true;
//	      }
//		    int i=pstmt.executeUpdate();
//            System.out.println(i+" Timesheet Remove ");
//			
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//			System.out.println("something went wrong");
//		}
//	    return flag;
//		}
	public List<Timesheet> searchTimesheet(LocalDate timesheetdate, int userid) {
		List<Timesheet> timesheets = new ArrayList<>();
		String selectquery = "select user_id,task_id,spend_time_hrs,comments,timesheet_for_date from timesheets where timesheet_for_date=? and user_id=?";
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
				Timesheet timesheet = new Timesheet(resultset.getInt(1), resultset.getInt(2), resultset.getInt(3),
						resultset.getString(4), resultset.getDate(5).toLocalDate());
				timesheets.add(timesheet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return timesheets;
	}

	public int findTimesheetId(LocalDate timesheetfordate, int userid) {
		String findUser = "select timesheet_id from timesheets where to_char(timesheet_for_date,'yyyy-MM-dd')='"
				+ timesheetfordate + "' and user_id='" + userid + "'";
		Connection con = null;
		Statement statement = null;
		ResultSet resultset = null;
		int timesheetId = 0;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultset = statement.executeQuery(findUser);
			if (resultset.next()) {
				timesheetId = resultset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
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
		return timesheetId;
	}

	public String getDate() {
		String query = "select to_char(sysdate,'yyyy-MM-dd') from dual";
		Connection con = null;
		Statement statement = null;
		ResultSet resultset = null;
		String date = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultset = statement.executeQuery(query);
			if (resultset.next()) {
				date = resultset.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
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
		return date;

	}
}
