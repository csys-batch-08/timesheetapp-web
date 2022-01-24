package com.timesheet.model;

import java.time.LocalDate;

public class Report {
	private String username;
	private String role;
	private String task;
	private int timesheetid;
	private int spendhrs;
	private LocalDate timesheetdate;
	private String status;
	private String approvedby;
	private LocalDate approvedon;
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getTimesheetid() {
		return timesheetid;
	}

	public void setTimesheetid(int timesheetid) {
		this.timesheetid = timesheetid;
	}

	public int getSpendhrs() {
		return spendhrs;
	}

	public void setSpendhrs(int spendhrs) {
		this.spendhrs = spendhrs;
	}

	public LocalDate getTimesheetdate() {
		return timesheetdate;
	}

	public void setTimesheetdate(LocalDate timesheetdate) {
		this.timesheetdate = timesheetdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}

	public LocalDate getApprovedon() {
		return approvedon;
	}

	public void setApprovedon(LocalDate approvedon) {
		this.approvedon = approvedon;
	}

	
	public Report(String username, String role, String task, int timesheetid, int spendhrs, LocalDate timesheetdate,
			String status, String approvedby, LocalDate approvedon) {
		super();
		this.username = username;
		this.role = role;
		this.task = task;
		this.timesheetid = timesheetid;
		this.spendhrs = spendhrs;
		this.timesheetdate = timesheetdate;
		this.status = status;
		this.approvedby = approvedby;
		this.approvedon = approvedon;
	}
	

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return " User Name : " + username + "\n Role : " + role + "\n Task Name : " + task + "\nTimesheet Id : " + timesheetid
				+ "\n Spend HRS : " + spendhrs + "\n Timesheet Date : " + timesheetdate + "\n Status : " + status + "\n Approved by : "
				+ approvedby + "\n Approved On : " + approvedon + "\n";
	}
	
}
