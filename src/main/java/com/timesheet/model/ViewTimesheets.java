package com.timesheet.model;

import java.time.LocalDate;

public class ViewTimesheets {
 private String username;
 private String comments;
 private int spendtimehrs;
 private LocalDate timesheetdate;
 private int taskid;
 private int timesheetid;
 private String status;
 
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getTimesheetid() {
	return timesheetid;
}
public void setTimesheetid(int timesheetid) {
	this.timesheetid = timesheetid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public int getSpendtimehrs() {
	return spendtimehrs;
}
public void setSpendtimehrs(int spendtimehrs) {
	this.spendtimehrs = spendtimehrs;
}
public LocalDate getTimesheetdate() {
	return timesheetdate;
}
public void setTimesheetdate(LocalDate timesheetdate) {
	this.timesheetdate = timesheetdate;
}
public int getTaskid() {
	return taskid;
}
public void setTaskid(int taskid) {
	this.taskid = taskid;
}

public ViewTimesheets(String username, String comments, int spendtimehrs, LocalDate timesheetdate, int taskid,
		int timesheetid,String status) {
	super();
	this.username = username;
	this.comments = comments;
	this.spendtimehrs = spendtimehrs;
	this.timesheetdate = timesheetdate;
	this.taskid = taskid;
	this.timesheetid = timesheetid;
	this.status=status;
}
public ViewTimesheets() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ViewTimesheets [username=" + username + ", comments=" + comments + ", spendtimehrs=" + spendtimehrs
			+ ", timesheetdate=" + timesheetdate + ", taskid=" + taskid + ", timesheetid=" + timesheetid + ", status="
			+ status + "]";
}



}
