package com.timesheet.dao;

import java.time.LocalDate;
import java.util.List;

import com.timesheet.model.Timesheet;

public interface TimesheetDAO {
	public boolean insertTimesheet(Timesheet timesheet);
	public boolean updateTimesheet(Timesheet timesheet);
	public List<Timesheet> showTimesheet(int userid);
	public boolean checkDate(int userid,LocalDate timesheetdate);
	public int getSpendhrs(LocalDate timesheetdate);
//	public boolean removeTimesheet(String timesheetfordate);
	public  int findTimesheetId(LocalDate timesheetfordate);
}
