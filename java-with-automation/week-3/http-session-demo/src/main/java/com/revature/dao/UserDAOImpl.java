package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import com.revature.model.User;

public class UserDAOImpl implements UserDAO {

	List<User> usersInOurApp = Arrays.asList(new User("Bach", "Tran", "myusername123", "mypassword123"), 
			new User("Nick", "Hailey", "nick123", "password123"));
	// We're not actually connecting to a database, we'll just have a List of user objects here
	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		
		for (User u : usersInOurApp) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		
		return null;
	}

}
