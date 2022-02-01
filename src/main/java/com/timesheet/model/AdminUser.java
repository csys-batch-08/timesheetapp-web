package com.timesheet.model;

public class AdminUser {
	private String firstName;
	private String lastName;
	private String userName;
	private String role;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	public AdminUser(String firstname, String lastname, String username, String role) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.userName = username;
		this.role = role;
	}
	public AdminUser() {
		super();
	
	}
	@Override
	public String toString() {
		return "AdminUser [firstname=" + firstName + ", lastname=" + lastName + ", username=" + userName + ", role="
				+ role + "]";
	}
}
