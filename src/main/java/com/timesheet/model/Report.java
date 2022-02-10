package com.timesheet.model;

import java.time.LocalDate;

public class Report {
	private String userName;
	private String role;
	private String task;
	private int timesheetId;
	private int spendHrs;
	private LocalDate timesheetDate;
	private String status;
	private String approvedBy;
	private LocalDate approvedOn;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}

	public int getSpendHrs() {
		return spendHrs;
	}

	public void setSpendHrs(int spendHrs) {
		this.spendHrs = spendHrs;
	}

	public LocalDate getTimesheetDate() {
		return timesheetDate;
	}

	public void setTimesheetDate(LocalDate timesheetDate) {
		this.timesheetDate = timesheetDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public LocalDate getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(LocalDate approvedOn) {
		this.approvedOn = approvedOn;
	}

	public Report(String userName, String role, String task, int timesheetId, int spendHrs, LocalDate timesheetDate,
			String status, String approvedBy, LocalDate approvedOn) {
		super();
		this.userName = userName;
		this.role = role;
		this.task = task;
		this.timesheetId = timesheetId;
		this.spendHrs = spendHrs;
		this.timesheetDate = timesheetDate;
		this.status = status;
		this.approvedBy = approvedBy;
		this.approvedOn = approvedOn;
	}

	public Report() {
		super();
	}

	@Override
	public String toString() {
		return " User Name : " + userName + "\n Role : " + role + "\n Task Name : " + task + "\nTimesheet Id : "
				+ timesheetId + "\n Spend HRS : " + spendHrs + "\n Timesheet Date : " + timesheetDate + "\n Status : "
				+ status + "\n Approved by : " + approvedBy + "\n Approved On : " + approvedOn + "\n";
	}

}
