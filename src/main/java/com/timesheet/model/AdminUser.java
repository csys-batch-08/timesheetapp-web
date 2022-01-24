package com.timesheet.model;

public class AdminUser {
	private String firstname;
	private String lastname;
	private String username;
	private String role;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
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
	public AdminUser(String firstname, String lastname, String username, String role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.role = role;
	}
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminUser [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", role="
				+ role + "]";
	}
}
