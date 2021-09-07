package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDao implements IUserDao{
	
	private static Logger log = Logger.getLogger(UserDao.class);

	@Override
	public int insert(User u) {
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			//start with sql string
			
			String sql = "INSERT INTO rashidt.users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING rashidt.users.id";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			
			//the enum is tough because we have to accommodate for a separate custom enum type
			stmt.setObject(3, u.getRole(), Types.OTHER);
			
			ResultSet rs; //our SQL statement will return a value; we need to iterate over it
			
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt(1);
				
				log.info("inserted user with id: " + id);
				return id; //if everything goes well this is where the method returns
			}
			
		} catch (SQLException e) {
			log.error("unable to insert user");
			e.printStackTrace();
		}
		
		return -1; //if this line is used, then there was an error
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// First start off with an empty array list
				List<User> allUsers = new ArrayList<User>();

				try (Connection conn = ConnectionUtil.getConnection()) {

					// We populate and fill the allUsers list
					Statement stmt = conn.createStatement();

					// String to represent the SQL Query
					String sql = "SELECT sophiag.users.id, sophiag.users.username, sophiag.users.pwd, sophiag.users.user_role,"
							+ " sophiag.accounts.id AS account_id, sophiag.accounts.balance FROM sophiag.users "
							+ "LEFT JOIN sophiag.users_accounts_jt ON sophiag.users.id = sophiag.users_accounts_jt.acc_owner "
							+ "LEFT JOIN sophiag.accounts ON sophiag.accounts.id = sophiag.users_accounts_jt.account";

					ResultSet rs = stmt.executeQuery(sql); // send the statement to the DB and produce an iterator

					// Iterate through the response, one row at a time
					while (rs.next()) {

						// for each row, grab the data from each column
						int id = rs.getInt("id");
						String username = rs.getString("username");
						String password = rs.getString("pwd");

						Role role = Role.valueOf(rs.getString("user_role"));

						int accountId = rs.getInt("account_id");
						double balance = rs.getDouble("balance");

						if (accountId == 0) {

							allUsers.add(new User(id, username, password, role, new ArrayList<>())); 
							// we can give the User an empty list of accounts because they don't have one...
							// 0 is default acc_id in DBeaver.

						} else {
							Account a = new Account(accountId, balance);

							// We will cover Streams later, you're welcome to research this in the time being
							// you don't need to use it unless you have queries that are as complex
							List<User> potentialOwners = allUsers.stream().filter((u) -> u.getId() == id) 
									.collect(Collectors.toList()); // We are trying to find all of the users that have the same id
							// (u) represents each element in the stream (think Collection, but different...why?)

							if (potentialOwners.isEmpty()) {
								List<Account> ownedAccounts = new ArrayList<>();
								ownedAccounts.add(a);
								User u = new User(id, username, password, role, ownedAccounts);
								allUsers.add(u);
							} else {
								// the owner of this account object already exists
								User u = potentialOwners.get(0);
								// u.addAccount(a); // we need to create an add Account method in User class
								// THIS IS UP TO YOU!!!!!!!!!!!!!
							}
						}
					}
				} catch (SQLException e) {
					log.error("We failed to retrieve all users!");
					return new ArrayList<>();
				}

				return allUsers;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
