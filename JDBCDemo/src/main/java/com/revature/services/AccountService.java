package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.repositories.IAccountDao;

public class AccountService {
	
	//inject dependency that account service needs to persist data
	public IAccountDao adao = new AccountDao();
	
	//create an open account method that will include a scanner and call insert method
	private static Scanner scan = new Scanner(System.in);
	
	public Account openAccount(User u) {
		//when called, method promts user to enter initial deposit
		System.out.println("Enter initial deposit: $");
		double deposit = scan.nextDouble();
		
		//reads bacl amount entered
		System.out.println("amount entered was: $" + deposit);
		
		//create's new account with user's id as the account ownerid
		//you could create a separate constructor to make this look neater
		Account a = new Account(0, deposit, u.getId());
		
		//calls adao.insert method to persist the account to the db
		//grab generated pk from insert
		int id = adao.insert(a);
		a.setId(id);
		
		//return full account object with generated pk as id
		return a;
	}
	
	public void viewAllAccountsByOwner(int ownerId) {
		for (Account a : adao.findByOwner(ownerId)) {
			System.out.println(a.toString());
		}
	}

	public List<Account> findByOwner(int id) {
		return adao.findByOwner(id);
	}
}
