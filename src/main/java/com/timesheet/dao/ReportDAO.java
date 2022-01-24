package com.timesheet.dao;

import java.time.LocalDate;
import java.util.List;

import com.timesheet.model.Report;

public interface ReportDAO {
	public List<Report> findreport(LocalDate timesheetdate,String username);

}
