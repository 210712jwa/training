package com.revature.service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.model.User;

@Service
public class AuthenticationService {

	@Autowired
	private UserDao userDao;
	
	public User login(String username, String password) throws LoginException {
		User user = userDao.getUserByUsernameAndPassword(username, password);
		
		if (user == null) {
			throw new LoginException("Incorrect credentials provided");
		}
		
		return user;
	}
	
}
