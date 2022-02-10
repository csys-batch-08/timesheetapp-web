package com.timesheet.model;

import java.time.LocalDate;
import java.util.Objects;

public class Timesheet {
	private int userId;
	private int taskId;
	private int spendTime;
	private String comments;
	private LocalDate timesheetForDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(int spendTime) {
		this.spendTime = spendTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getTimesheetForDate() {
		return timesheetForDate;
	}

	public void setTimesheetForDate(LocalDate timesheetForDate) {
		this.timesheetForDate = timesheetForDate;
	}

	public Timesheet() {
		super();
	}

	public Timesheet(int userId, int taskId, int spendTime, String comments, LocalDate timesheetForDate) {
		super();
		this.userId = userId;
		this.taskId = taskId;
		this.spendTime = spendTime;
		this.comments = comments;
		this.timesheetForDate = timesheetForDate;
	}

	@Override
	public String toString() {
		return "User Id : " + userId + "\nTask Id : " + taskId + "\nSpend Time in Hrs : " + spendTime + "\nComments : "
				+ comments + "\nTimesheet for date : " + timesheetForDate + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(comments, spendTime, taskId, timesheetForDate, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timesheet other = (Timesheet) obj;
		return Objects.equals(comments, other.comments) && spendTime == other.spendTime && taskId == other.taskId
				&& Objects.equals(timesheetForDate, other.timesheetForDate) && userId == other.userId;
	}

}
