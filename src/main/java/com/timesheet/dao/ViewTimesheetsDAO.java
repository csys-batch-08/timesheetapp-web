package com.timesheet.dao;

import java.util.List;

import com.timesheet.model.ViewTimesheets;

public interface ViewTimesheetsDAO {
	public List<ViewTimesheets> showAllTimesheet();

	public List<ViewTimesheets> showTimesheet(String userName, String startDate, String endDate);

}
