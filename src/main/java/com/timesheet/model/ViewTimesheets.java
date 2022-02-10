package com.timesheet.model;

import java.time.LocalDate;

public class ViewTimesheets {
	private String userName;
	private String comments;
	private int spendtimeHrs;
	private LocalDate timesheetDate;
	private int taskId;
	private int timesheetId;
	private String status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getSpendtimeHrs() {
		return spendtimeHrs;
	}

	public void setSpendtimeHrs(int spendtimeHrs) {
		this.spendtimeHrs = spendtimeHrs;
	}

	public LocalDate getTimesheetDate() {
		return timesheetDate;
	}

	public void setTimesheetDate(LocalDate timesheetDate) {
		this.timesheetDate = timesheetDate;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ViewTimesheets(String userName, String comments, int spendtimeHrs, LocalDate timesheetDate, int taskId,
			int timesheetId, String status) {
		super();
		this.userName = userName;
		this.comments = comments;
		this.spendtimeHrs = spendtimeHrs;
		this.timesheetDate = timesheetDate;
		this.taskId = taskId;
		this.timesheetId = timesheetId;
		this.status = status;
	}

	public ViewTimesheets() {
		super();
	}

	@Override
	public String toString() {
		return "ViewTimesheets [username=" + userName + ", comments=" + comments + ", spendtimehrs=" + spendtimeHrs
				+ ", timesheetdate=" + timesheetDate + ", taskid=" + taskId + ", timesheetid=" + timesheetId
				+ ", status=" + status + "]";
	}

}
