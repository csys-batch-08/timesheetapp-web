package com.timesheet.model;

import java.util.Date;

public class Rejecttimesheet {
	private String task;
	private int timesheetId;
	private Date timesheetDate;
	private int spendtimeHrs;
	private String comments;
	private String approvedBy;
	private String status;

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

	public Date getTimesheetDate() {
		return timesheetDate;
	}

	public void setTimesheetDate(Date timesheetDate) {
		this.timesheetDate = timesheetDate;
	}

	public int getSpendtimeHrs() {
		return spendtimeHrs;
	}

	public void setSpendtimeHrs(int spendtimeHrs) {
		this.spendtimeHrs = spendtimeHrs;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Rejecttimesheet() {
		super();
	}

	public Rejecttimesheet(String task, int timesheetId, Date timesheetDate, int spendtimeHrs, String comments,
			String approvedBy, String status) {
		super();
		this.task = task;
		this.timesheetId = timesheetId;
		this.timesheetDate = timesheetDate;
		this.spendtimeHrs = spendtimeHrs;
		this.comments = comments;
		this.approvedBy = approvedBy;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Rejected Timesheet \n task Name : " + task + "\n Timesheet Id : " + timesheetId + "\n Timesheet Date="
				+ timesheetDate + "\n spend Time HRS : " + spendtimeHrs + "\n Comments :" + comments
				+ "\n Approved by : " + approvedBy + "\n Status : " + status + "\n";
	}

}
