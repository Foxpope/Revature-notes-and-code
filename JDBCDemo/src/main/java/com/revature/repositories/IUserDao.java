package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

/*
 * dao is a data access object
 * seperates business logic from persistence logic
 */
public interface IUserDao { //all CRUD methods
	
	int insert(User u); //to return the primary key from the DB
	User findByUsername(String username); //read
	List<User> findAll();
	boolean update(User u); //takes in a user and update's its records in the database
	boolean delete(int id);
	
	//all other methods
	
}
