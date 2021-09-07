package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.repositories.IAccountDao;
import com.revature.repositories.UserDao;
import com.revature.services.AccountService;
import com.revature.services.UserService;
import com.revature.util.ConnectionUtil;

public class App {

	public static void main(String[] args) {

		menu();
		
	}

	public static void menu() {
		UserService userv = new UserService();
		AccountService aserv = new AccountService();
		Scanner scan = new Scanner(System.in);

		System.out.println("Press 1 for customer; press 2 for login");

		// in your application, you need to check for bad inputs
		int input = scan.nextInt();

		if (input == 1) {
			// create new user
			System.out.println("enter username");
			String username = scan.next();

			System.out.println("enter password");
			String pwd = scan.next();

			// pretend that all users are customers
			User u = new User(0, username, pwd, Role.Customer, new ArrayList<Account>());

			// the instantiated user now has an id, so we'll reference that now
			u = userv.register(u);

			System.out.println("Would you like to open an account? Y/N");
			String yn = scan.next();

			if (yn.equalsIgnoreCase("y")) {
				//modified to ask for multiple accounts
				System.out.println("how many accounts? ");
				int accs = scan.nextInt();
				
				// what parameter does openaccount take
				for (int i = 0; i < accs; i++) {
					System.out.println("opening account #" + i);
					aserv.openAccount(u);
				}
				
				aserv.viewAllAccountsByOwner(u.getId());
			}

		} else {
			// call login method

		}
		scan.close();	}

}
