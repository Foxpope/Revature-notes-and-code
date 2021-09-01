package com.revature.repositories;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDao {

	List<Account> findAll(); //returns sll account objects
	int insert(Account a); //return primary key of inserted account
	List<Account> findByOwner(int userId);
	Account findById(int id);
	boolean update(Account a);
	boolean delete(int id);
	
}
