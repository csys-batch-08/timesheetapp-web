package com.timesheet.dao;

import java.util.List;

import com.timesheet.model.AdminUser;
import com.timesheet.model.User;

public interface AdminDAO {
	public User validateAdmin(String username,String password);
	public List<AdminUser> showalluser();
	public List<AdminUser> showusers();
	public boolean removeUser(String username,String role);
}
