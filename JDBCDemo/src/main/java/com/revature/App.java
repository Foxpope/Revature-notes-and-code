package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.repositories.IAccountDao;
import com.revature.repositories.UserDao;
import com.revature.util.ConnectionUtil;

public class App {

	public static void main(String[] args) {
		
		ConnectionUtil.getConnection();
		
		User u1 = new User("Batman", "pass", Role.Admin, new ArrayList<Account>());
		
		UserDao ud = new UserDao();
		
		//int correctExec = ud.insert(u1);
		
		//System.out.println(correctExec);
		
		IAccountDao adao = new AccountDao();
		
		List<Account> accounts = adao.findAll()
;
		System.out.println(accounts);
		
		System.out.println(adao.findByOwner(1));
		
		//System.out.print("print username: ");
		
		//call our service
	}

}
