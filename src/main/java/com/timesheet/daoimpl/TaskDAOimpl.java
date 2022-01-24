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
public class TaskDAOimpl implements TaskDAO
{
	public boolean insertTask(Task task)
	{
		boolean flag=false;
		String insertquery="insert into task_details(user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to,total_hours)values(?,?,?,?,?,?,?)";
		Connectionutil conutil=new Connectionutil();
		Connection con=conutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(insertquery);
			pstmt.setInt(1,task.getUserid());
			pstmt.setString(2,task.getTask());
			pstmt.setDate(3,java.sql.Date.valueOf(task.getDateassigned()));
			pstmt.setDate(4,java.sql.Date.valueOf(task.getEnddate()));
			pstmt.setString(5,task.getTaskpriority());
			pstmt.setString(6,task.getAssignedto());
			pstmt.setLong(7,task.getTotalhrs());
			if(pstmt.executeUpdate()>0)
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
//			System.out.println("Task not added");
		}
		return flag;
	}
	public boolean updateTask(Task task)
	{
		boolean flag=false;
		String updatequery="update task_details set user_id=?,assigned_to_date=?,end_date=?,task_priority=?,assigned_to=?,total_hours=? where task_name=?";
		Connection con=Connectionutil.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(updatequery);
			pstmt.setInt(1, task.getUserid());
			pstmt.setDate(2,java.sql.Date.valueOf(task.getDateassigned()));
			pstmt.setDate(3,java.sql.Date.valueOf(task.getEnddate()));
			pstmt.setString(4,task.getTaskpriority());
			pstmt.setString(5,task.getAssignedto());
			pstmt.setString(7, task.getTask());
			pstmt.setLong(6,task.getTotalhrs());
			if(pstmt.executeUpdate()>0)
			{
				flag=true;
			}
//			int i=pstmt.executeUpdate();
//			System.out.println(i+" Task updated");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("something went wrong");
		}
		return flag;
	}
	public List<Task> showallTask()
	{
		List<Task> tasklist=new ArrayList<Task>();
		String selectquery="select user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to,total_hours from task_details order by assigned_to_date desc";
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
			Task task=new Task(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getDate(4).toLocalDate(),rs.getString(5),rs.getString(6),rs.getLong(7));
			tasklist.add(task);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		
		return tasklist;
		
	}
	public List<Task> showTask(String username)
	{
		List<Task> tasklist=new ArrayList<Task>();
		String selectquery="select user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to,total_hours from task_details where assigned_to='"+username+"' and total_hours>0";
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
			Task task=new Task(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getDate(4).toLocalDate(),rs.getString(5),rs.getString(6),rs.getLong(7));
			tasklist.add(task);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("somthing went wrong");
		}
		
		return tasklist;
		
	}
	public  int findtaskId(String task)
	{
		String findtask="select task_id from task_details where task_name= '"+task+"'";
		Connection con=Connectionutil.getDbConnection();
		Statement stmt;
		int taskId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findtask);
			if(rs.next())
			{
			taskId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskId;
		
	}
	public boolean validateTask(String taskname,String username)
	{
		String query="select user_id,task_name,assigned_to_date,end_date,task_priority,assigned_to,total_hours from task_details where Assigned_to='"+username+"' and task_name='"+taskname+"'";
		Connection con=Connectionutil.getDbConnection();
		boolean flag=true;
		Statement st;
		try
		{
			st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
			Task task=new Task(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getDate(4).toLocalDate(),rs.getString(5),rs.getString(6),rs.getLong(7));	
			}
			else
			{
				flag=false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
		
	}
	public int getTotalhrs(int userid,String taskname)
	{
	 Connection con=Connectionutil.getDbConnection();	
	 String query="select total_hours from task_details where task_name=? and user_id=?";
	 int result=0;
	 PreparedStatement pstmt;
	 try {
		pstmt=con.prepareStatement(query);
		pstmt.setString(1,taskname);
		pstmt.setInt(2,userid);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			result= rs.getInt(1);
			System.out.println("totalhour "+result);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return result;
		
	}
	
	public int updatehrs(int spendhrs,int userid,int taskId)
	{
//		System.out.println("s"+spendhrs+"id "+userid+"taskname "+taskId);
		Connection con=Connectionutil.getDbConnection();
		String query="update task_details set total_hours =total_hours-? where task_id=? and user_id=?";
		PreparedStatement pstmt;
		int result=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, spendhrs);
			pstmt.setInt(2, taskId);
			pstmt.setInt(3, userid);
			result=pstmt.executeUpdate();
			System.out.println("update"+result);
			pstmt.executeUpdate("commit");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
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
