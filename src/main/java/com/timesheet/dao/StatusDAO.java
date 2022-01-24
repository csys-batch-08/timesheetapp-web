package com.timesheet.dao;

import java.util.List;

import com.timesheet.model.Status;

public interface StatusDAO {
	public boolean insertStatus(Status status);
	public boolean updateStatus(Status status);
	 public List<Status> showStatus(int timesheetid);
	 public List<Status> showallStatus();
//	 public boolean removeStatus(int timesheetid);

}
