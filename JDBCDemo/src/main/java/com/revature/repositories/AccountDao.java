package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDao implements IAccountDao {

	private static Logger log = Logger.getLogger(AccountDao.class);

	@Override
	public List<Account> findAll() { // make a query
		// start with empty arraylist of accounts
		List<Account> accounts = new ArrayList<Account>();

		// obtain a connection (try with resources)
		try (Connection conn = ConnectionUtil.getConnection()) {
			// create statement + a sql string to pass through on DB
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM accounts";
			// send statement to DB
			ResultSet rs = stmt.executeQuery(sql);
			// iterate through response while(rs.next())
			while (rs.next()) {
				// for each row, grab the object data
				int id = rs.getInt("id"); // you can specify column number OR NAME
				double balance = rs.getDouble("balance");
				// construct the account object
				Account a = new Account(id, balance);
				// add the account object to list
				accounts.add(a);
			}

		} catch (SQLException e) {
			// catch sql error
			log.error("failed to query all accounts");
			e.printStackTrace();
		}
		// return account list
		return accounts;
	}

	@Override
	public int insert(Account a) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO rashidt.accounts (balance, acc_owner) VALUES (?, ?) RETURNING rashidt.accounts.id";
			
			//prepare statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, a.getBalance());
			stmt.setInt(2, a.getOwnerId());
			
			ResultSet rs;
			
			if((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id =rs.getInt(1);
				return id;
			}
		} catch (SQLException e) {
			log.warn("unable to insert account");
			e.printStackTrace();
			//-1 returns when there is an issue
			return -1;
		}
		return -1;
	}

	@Override
	public List<Account> findByOwner(int userId) {

		List<Account> ownedAccounts = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT rashidt.accounts.id, rashidt.accounts.balance\r\n"
					+ "	FROM rashidt.accounts\r\n"
					+ "	INNER JOIN rashidt.users_account_jt\r\n"
					+ "	ON rashidt.accounts.id = rashidt.users_account_jt.account\r\n"
					+ " WHERE rashidt.accounts.id = ?;"; // joins statement

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, userId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				Account a = new Account(id, balance);

				// in the case that there are duplicates, DON'T add them to the arraylist
				if (!ownedAccounts.contains(a)) {
					ownedAccounts.add(a);
				}
			}
		} catch (SQLException e) {
			log.warn("failed to retrieve all accounts with user: " + userId);
			e.printStackTrace();
		}

		return ownedAccounts;
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
