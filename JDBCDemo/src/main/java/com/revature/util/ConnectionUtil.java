package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.revature.repositories.UserDao;

/*
 * Singleton design pattern
 * 
 * singleton design pattern instantiates an object once
 * 
 * -private constructor
 * -static fielf of instance of class to be returned
 * -leverage a public static
 * 
 */
public class ConnectionUtil {
	
	private static Logger log = Logger.getLogger(UserDao.class);

	private static Connection conn = null;

	// we want a private constructor
	private ConnectionUtil() {
		super();
	}

	//in a singleton, you want a static getInstance() method
	public static Connection getConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				log.info("returned connection");
				return conn;
			}
		} catch (SQLException e) {
			log.error("failed to reuse a connection");
			return null;
		}
		
		Properties prop = new Properties();
		
		String url = "";
		String username = "";
		String password = "";
		
		try {
			prop.load(new FileReader("C:\\Users\\zodia\\Documents\\GitHub\\Revature-notes-and-code\\JDBCDemo\\src\\main\\resources\\new.properties"));
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, username, password);
			
			log.info("db connection established");
//		} catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
		} catch (IOException e) {
			log.error("cannot locate application.properties file");
			e.printStackTrace();
		} catch (SQLException e) {
			log.error("cannot establish database connection");
			return null;
		}
		return conn;
	}

}
