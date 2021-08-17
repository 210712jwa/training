package com.revature.service;

import com.revature.dao.UserDAO;
import com.revature.dto.LoginDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.InvalidLoginException;
import com.revature.model.User;

public class LoginService {

	private UserDAO userDao;
	
	public LoginService() {
		this.userDao = new UserDAO();
	}
	
	public User login(LoginDTO loginDTO) throws BadParameterException, InvalidLoginException {
		if (loginDTO.getUsername().trim().equals("") && loginDTO.getPassword().trim().equals("")) {
			throw new BadParameterException("Username and password cannot be blank");
		}
		
		if (loginDTO.getUsername().trim().equals("")) {
			throw new BadParameterException("Username cannot be blank");
		}
		
		if (loginDTO.getPassword().trim().equals("")) {
			throw new BadParameterException("Password cannot be blank");
		}
		
		User user = userDao.getUserByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
		
		if (user == null) {
			throw new InvalidLoginException("You provided incorrect credentials when attempting to log in");
		}
		
		return user;
	}
	
}
