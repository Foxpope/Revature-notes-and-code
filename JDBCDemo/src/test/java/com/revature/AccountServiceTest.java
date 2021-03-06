package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.services.AccountService;

public class AccountServiceTest {

	private AccountService aserv;
	
	private AccountDao mockdao;
	
	@Before
	public void setup() {
		
		aserv = new AccountService();
		
		mockdao = mock(AccountDao.class);
		
		aserv.adao = mockdao;
	}
	
	@After
	public void teardown() {
		
		aserv = null;
		mockdao = null;
	}
	
	@Test
	public void testFindByOwnerId_returnAccountList() {
		List<Account> bobsAccounts = new ArrayList<Account>();
		
		Account a = new Account(1, 500);
		Account b = new Account(2, 600);
		bobsAccounts.add(a);
		bobsAccounts.add(b);
		
		User bob = new User(4, "bob", "sssss", Role.Customer, bobsAccounts);
		
		int bobsId = bob.getId();
		
		
		when(mockdao.findByOwner(bobsId)).thenReturn(bobsAccounts);
		
		
		List<Account> returnedAccounts = aserv.findByOwner(bobsId);
		
		assertEquals(bobsAccounts, returnedAccounts);
		}
}









