package com.timesheet.dao;

import java.util.List;

import com.timesheet.model.User;

public interface UserDAO {
	public boolean insertUser(User user);

	public User validateUser(String userName, String userPassword);

	public boolean updateUser(User user);

	public List<User> showuser(String userName);

	public int findUserId(String userName);
}
