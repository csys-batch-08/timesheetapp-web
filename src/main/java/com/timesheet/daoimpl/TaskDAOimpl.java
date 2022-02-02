package com.timesheet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.timesheet.dao.TaskDAO;
import com.timesheet.model.Task;
import com.timesheet.util.Connectionutil;

public class TaskDAOimpl implements TaskDAO {
	public boolean insertTask(Task task) {
		boolean flag = false;
		String insertquery = "insert into task_details(user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to,total_hours)values(?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(insertquery);
			preparestatement.setInt(1, task.getUserid());
			preparestatement.setString(2, task.getTask());
			preparestatement.setDate(3, java.sql.Date.valueOf(task.getDateassigned()));
			preparestatement.setDate(4, java.sql.Date.valueOf(task.getEnddate()));
			preparestatement.setString(5, task.getTaskpriority());
			preparestatement.setString(6, task.getAssignedto());
			preparestatement.setLong(7, task.getTotalhrs());
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

	public boolean updateTask(Task task) {
		boolean flag = false;
		String updatequery = "update task_details set user_id=?,assigned_to_date=?,end_date=?,task_priority=?,assigned_to=?,total_hours=? where task_name=?";
		Connection con = null;
		PreparedStatement preparestatement = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(updatequery);
			preparestatement.setInt(1, task.getUserid());
			preparestatement.setDate(2, java.sql.Date.valueOf(task.getDateassigned()));
			preparestatement.setDate(3, java.sql.Date.valueOf(task.getEnddate()));
			preparestatement.setString(4, task.getTaskpriority());
			preparestatement.setString(5, task.getAssignedto());
			preparestatement.setString(7, task.getTask());
			preparestatement.setLong(6, task.getTotalhrs());
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

	public List<Task> showallTask() {
		List<Task> tasklist = new ArrayList<>();
		String selectquery = "select user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to,total_hours from task_details order by assigned_to_date desc";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				Task task = new Task(resultset.getInt(1), resultset.getString(2), resultset.getDate(3).toLocalDate(),
						resultset.getDate(4).toLocalDate(), resultset.getString(5), resultset.getString(6),
						resultset.getLong(7));
				tasklist.add(task);
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
		return tasklist;
	}

	public List<Task> showTask(String username) {
		List<Task> tasklist = new ArrayList<>();
		String selectquery = "select user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to,total_hours from task_details where assigned_to='"
				+ username + "' and total_hours>0";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				Task task = new Task(resultset.getInt(1), resultset.getString(2), resultset.getDate(3).toLocalDate(),
						resultset.getDate(4).toLocalDate(), resultset.getString(5), resultset.getString(6),
						resultset.getLong(7));
				tasklist.add(task);
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
		return tasklist;
	}

	public List<Task> searchTask(String taskname) {
		List<Task> tasklist = new ArrayList<>();
		String selectquery = "select user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to,total_hours from task_details where task_name=? and total_hours>0";
		Connection con = null;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(selectquery);
			preparestatement.setString(1, taskname);
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				Task task = new Task(resultset.getInt(1), resultset.getString(2), resultset.getDate(3).toLocalDate(),
						resultset.getDate(4).toLocalDate(), resultset.getString(5), resultset.getString(6),
						resultset.getLong(7));
				tasklist.add(task);
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
		return tasklist;
	}

	public int findtaskId(String task) {
		String findtask = "select task_id from task_details where task_name= '" + task + "'";
		Connection con = null;
		Statement statement = null;
		ResultSet resultset = null;
		int taskId = 0;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultset = statement.executeQuery(findtask);
			if (resultset.next()) {
				taskId = resultset.getInt(1);
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
		return taskId;
	}

	public boolean validateTask(String taskname, String username) {
		String query = "select user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to,total_hours from task_details where Assigned_to='"
				+ username + "' and task_name='" + taskname + "'";
		Connection con = null;
		boolean flag = true;
		ResultSet resultset = null;
		Statement statement = null;
		try {
			con = Connectionutil.getDbConnection();
			statement = con.createStatement();
			resultset = statement.executeQuery(query);
			if (resultset.next()) {
				Task task = new Task(resultset.getInt(1), resultset.getString(2), resultset.getDate(3).toLocalDate(),
						resultset.getDate(4).toLocalDate(), resultset.getString(5), resultset.getString(6),
						resultset.getLong(7));
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

	public int getTotalhrs(int userid, String taskname) {
		Connection con = null;
		String query = "select total_hours from task_details where task_name=? and user_id=?";
		int result = 0;
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(query);
			preparestatement.setString(1, taskname);
			preparestatement.setInt(2, userid);
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

	public int updatehrs(int spendhrs, int userid, int taskId) {
		Connection con = null;
		String query = "update task_details set total_hours =total_hours-? where task_id=? and user_id=?";
		PreparedStatement preparestatement = null;
		int result = 0;
		try {
			con = Connectionutil.getDbConnection();
			preparestatement = con.prepareStatement(query);
			preparestatement.setInt(1, spendhrs);
			preparestatement.setInt(2, taskId);
			preparestatement.setInt(3, userid);
			result = preparestatement.executeUpdate();
			preparestatement.executeUpdate("commit");
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
		return result;
	}

//	public boolean removeTask(String task)
//	{
//		boolean flag=false;
//		String removequery="delete from task_details where task_name=?";
//		Connection con=Connectionutil.getDbConnection();
//		PreparedStatement pstmt=null;
//		try
//		{
//			pstmt=con.prepareStatement(removequery);
//			pstmt.setString(1,task);
//			if(pstmt.executeUpdate()>0)
//			{
//				flag=true;
//			}
//			int i=pstmt.executeUpdate();
//			System.out.println(i+" Task Remove successfully");
//			
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//			System.out.println("Task not Removed");
//		}
//		return flag;
//	}
}
