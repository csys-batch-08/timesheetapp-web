package com.timesheet.model;

import java.time.LocalDate;

public class Task {
	private int userId;
	private String taskName;
	private LocalDate dateAssigned;
	private LocalDate endDate;
	private String taskPriority;
	private String assignedTo;
	private long totalHrs;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public LocalDate getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(LocalDate dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public long getTotalHrs() {
		return totalHrs;
	}

	public void setTotalHrs(long totalHrs) {
		this.totalHrs = totalHrs;
	}

	public Task() {
		super();
	}

	public Task(int userId, String taskName, LocalDate dateAssigned, LocalDate endDate, String taskPriority,
			String assignedTo, long totalHrs) {
		super();
		this.userId = userId;
		this.taskName = taskName;
		this.dateAssigned = dateAssigned;
		this.endDate = endDate;
		this.taskPriority = taskPriority;
		this.assignedTo = assignedTo;
		this.totalHrs = totalHrs;
	}

	@Override
	public String toString() {
		return "Task [userid=" + userId + ", task=" + taskName + ", dateassigned=" + dateAssigned + ", enddate=" + endDate
				+ ", taskpriority=" + taskPriority + ", assignedto=" + assignedTo + ", totalhrs=" + totalHrs + "]";
	}
}