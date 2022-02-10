package com.timesheet.dao;

import java.time.LocalDate;
import java.util.List;

import com.timesheet.model.Timesheet;

public interface TimesheetDAO {
	public boolean insertTimesheet(Timesheet timesheet);

	public boolean updateTimesheet(Timesheet timesheet);

	public List<Timesheet> showTimesheet(int userId);

	public boolean checkDate(int userId, LocalDate timesheetDate);

	public int getSpendhrs(LocalDate timesheetDate);

    public boolean removeTimesheet(String timesheetForDate,String timesheetStatus);
	
	public List<Timesheet> searchTimesheet(LocalDate timesheetDate, int userId);

	public int findTimesheetId(LocalDate timesheetForDate, int userId);

	public String getDate();
}
