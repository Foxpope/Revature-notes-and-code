package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

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
		// TODO Auto-generated method stub
		return null;
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
