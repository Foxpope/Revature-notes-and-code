package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.services.UserService;
import com.revature.exceptions.*;

public class UserServiceTest {
	
	//declare clas tp be tested
	private UserService userv;
	
	//declare deoendencies of the userservice
	//we will be using mockito to "mock" the dao layer
	private UserDao mockdao;
	
	private User dummy;
	
	@Before
	public void setup() {
		userv = new UserService();
		
		//mock the dependency that's provided to userservice
		mockdao = mock(UserDao.class);
		
		//every userservice has a dao that it relies on
		userv.udao = mockdao;
		
		//stub
		dummy = new User();
		dummy.setAccounts(new ArrayList<Account>());
		dummy.setId(0);
	}
	
	@After
	public void teardown() {
		userv = null;
		dummy = null;
		mockdao = null;
	}
	
	//when inserting a user, it returns a new primary key (PK)
	//if it were not returning the right key, we'd have issues
	@Test
	public void testRegisterUser_returnsPK() {
		dummy = new User(0, "spongebob", "pineapple", Role.Admin, new ArrayList<>());
		
		//generate a random primary number key to return to insert
		Random r = new Random();
		int fakePK = r.nextInt(100);
		
		//intercepting the userservice's call to the dao layer
		when(mockdao.insert(dummy)).thenReturn(fakePK);
		
		//does the register method call the dao layer
		User registeredUser = userv.register(dummy);
		
		//we are testing 
		assertEquals(registeredUser.getId(), fakePK);
		
	}
	
	@Test (expected = RegisterUserFailedException.class)
	public void testRegisterUser_idGreaterThanZero_throwsException() {
		List<Account> accounts = new ArrayList<Account>();
		Account a = new Account();
		a.setBalance(7000);
		
		accounts.add(a);
		
		dummy = new User(23, "bob", "pass", Role.Customer, accounts);
		
		userv.register(dummy); //this will throw exception
	}
}












