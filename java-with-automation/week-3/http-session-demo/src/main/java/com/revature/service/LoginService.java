package com.revature.service;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exception.InvalidLoginException;
import com.revature.model.User;

public class LoginService {

	private UserDAO userDao;
	
	public LoginService() {
		this.userDao = new UserDAOImpl();
	}
	
	public User login(String username, String password) throws InvalidLoginException {
		User user = userDao.getUserByUsernameAndPassword(username, password);
		
		if (user == null) {
			throw new InvalidLoginException("An invalid username and password were provided");
		}
		
		return user;
	}
	
}
