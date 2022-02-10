package com.timesheet.dao;

import java.util.List;

import com.timesheet.model.Task;

public interface TaskDAO {
	public boolean insertTask(Task task);

	public boolean updateTask(Task task);

	public List<Task> showallTask();

	public List<Task> showTask(String userName);

	public int findtaskId(String task);

	public boolean validateTask(String taskName, String userName);

	public int getTotalhrs(int userId, String taskName);

	public int updatehrs(int spendHrs, int userId, int taskId);
	
	public boolean removeTask(String task,String taskStatus);

}
