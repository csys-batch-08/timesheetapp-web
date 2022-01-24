package com.timesheet.dao;

import java.time.LocalDate;
import java.util.List;

import com.timesheet.model.ViewTimesheets;

public interface ViewTimesheetsDAO {
	public List<ViewTimesheets> showAllTimesheet();
	public List<ViewTimesheets> showTimesheet(String username,String startdate,String enddate);

}
