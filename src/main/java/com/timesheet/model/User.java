package com.timesheet.model;

import java.util.Objects;

public class User {
	private String userFirstName;
	private String userLastName;
	private String userUserName;
	private String password;

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserUserName() {
		return userUserName;
	}

	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

	public User(String userFirstName, String userLastName, String userUserName, String password) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userUserName = userUserName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User firstname: " + userFirstName + "\n lastname: " + userLastName + "\n username: " + userUserName
				+ "\n password: " + password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userFirstName, userLastName, password, userUserName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userFirstName, other.userFirstName) && Objects.equals(userLastName, other.userLastName)
				&& Objects.equals(password, other.password) && Objects.equals(userUserName, other.userUserName);
	}

}
