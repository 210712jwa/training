package com.revature.dao;

import com.revature.model.User;

public interface UserDAO {

	public User getUserByUsernameAndPassword(String username, String password);
	
}
