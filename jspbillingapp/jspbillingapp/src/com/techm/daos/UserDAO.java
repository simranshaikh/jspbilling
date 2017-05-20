package com.techm.daos;

import java.sql.Connection;
import java.util.List;
import com.techm.models.User;

public interface UserDAO {
	public Connection getConnection();
	public void closeConnection();
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean removeUser(String userName);
	public User getUser(String userName);
	public List<User> getAllUsers();
	public boolean validateUser(User user);
	public void getAllUsersForDBTraverse();
	public void getDBInfo();
	
}
