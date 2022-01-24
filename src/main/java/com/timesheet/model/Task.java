package com.timesheet.model;
import java.time.LocalDate;
import java.util.Objects;
public class Task {
	private int userid;
	private String task;
	private LocalDate dateassigned;
	private LocalDate enddate;
	private String taskpriority;
	private String assignedto;
	private long totalhrs;
	
    
	public long getTotalhrs() {
		return totalhrs;
	}

	public void setTotalhrs(long totalhrs) {
		this.totalhrs = totalhrs;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getDateassigned() {
		return dateassigned;
	}

	public void setDateassigned(LocalDate dateassigned) {
		this.dateassigned = dateassigned;
	}
	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public String getTaskpriority() {
		return taskpriority;
	}

	public void setTaskpriority(String taskpriority) {
		this.taskpriority = taskpriority;
	}

	public String getAssignedto() {
		return assignedto;
	}

	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}
	public Task() {
		super();
	}
	
//	public Task(int userid, String task, LocalDate dateassigned, LocalDate enddate, String taskpriority,
//			String assignedto) {
//		super();
//		this.userid = userid;
//		this.task = task;
//		this.dateassigned = dateassigned;
//		this.enddate = enddate;
//		this.taskpriority = taskpriority;
//		this.assignedto = assignedto;
//	}

	public Task(int userid, String task, LocalDate dateassigned, LocalDate enddate, String taskpriority, String assignedto,long totalhrs) {
		super();
		this.userid = userid;
		this.task = task;
		this.dateassigned = dateassigned;
		this.enddate = enddate;
		this.taskpriority = taskpriority;
		this.assignedto = assignedto;
		this.totalhrs=totalhrs;
		
	}

	@Override
	public String toString() {
		return "Task [userid=" + userid + ", task=" + task + ", dateassigned=" + dateassigned + ", enddate=" + enddate
				+ ", taskpriority=" + taskpriority + ", assignedto=" + assignedto + ", totalhrs=" + totalhrs + "]";
	}
	}