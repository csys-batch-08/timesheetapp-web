package com.timesheet.model;

import java.util.Objects;

public class Status {
	private int userId;
	private int timesheetId;
	private String timesheetStatus;
	private String approvedBy;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}

	public String getTimesheetStatus() {
		return timesheetStatus;
	}

	public void setTimesheetStatus(String timesheetStatus) {
		this.timesheetStatus = timesheetStatus;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Status() {
		super();
	}

	public Status(int userId, int timesheetId, String timesheetStatus, String approvedBy) {
		super();
		this.userId = userId;
		this.timesheetId = timesheetId;
		this.timesheetStatus = timesheetStatus;
		this.approvedBy = approvedBy;
	}

	@Override
	public String toString() {
		return "User Id : " + userId + "\nTimesheet Id : " + timesheetId + "\nStatus : " + timesheetStatus
				+ "\nApproved By : " + approvedBy + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(approvedBy, timesheetStatus, timesheetId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		return Objects.equals(approvedBy, other.approvedBy) && Objects.equals(timesheetStatus, other.timesheetStatus)
				&& timesheetId == other.timesheetId && userId == other.userId;
	}

}
