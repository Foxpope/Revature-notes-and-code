package com.revature.models;

import java.io.Serializable;
import java.util.List;

//this is a java bean
public class User implements Serializable{

	private static final long serialVersionUID = -4553508689874995351L;
	private int id; //be represented in database by a primary key (and serial)
	private String username;
	private String password;
	private Role role;
	private List<Account> accounts;
	
	//the no args constructor allows you to create objeects that you can then set data on later
	//using the getters/setters (that's why you need one in a BEAN; they synergize well)
	public User() {
		super();
	}

	//constructors with and without ids
	public User(int id, String username, String password, Role role, List<Account> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}

	//this allow me to create a user from within my "business layer"
	//a.k.a. JAva application
	//a user will have an id generated once it uses the database
	public User(String username, String password, Role role, List<Account> accounts) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
