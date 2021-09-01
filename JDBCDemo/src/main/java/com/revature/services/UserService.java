package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;
import com.revature.repositories.IUserDao;
import com.revature.repositories.UserDao;


public class UserService implements IUserService{
	
	private static Logger log = Logger.getLogger(UserService.class);
	
	@Override
	public User register(User u) {
		//takes in user object
		log.info("registering new user...");
		
		if(u.getId() != 0) {
			//something is wrong
			throw new RegisterUserFailedException("recieved user object did not have id of 0");
		}
		//if the user id is 0
		int generatedId = udao.insert(u);
		
		if(generatedId != -1 && generatedId != u.getId()) {
			
			u.setId(generatedId);
		} else {
			throw new RegisterUserFailedException("failed to insert the user");
		}
		
		log.info("registration of user with id " + u.getId() + " was successful.");
		return u;
	}
	
	public User login(String username, String password) {
		//call some dao methods
		//array of all and iterate through each one to check if that username is present
		return null;
	}
	
	public void printAllUsers() {
		List<User> users = udao.findAll();
		
		users.forEach(u -> System.out.println(u));
		//you could also use an enhanced for loop
	}

}
