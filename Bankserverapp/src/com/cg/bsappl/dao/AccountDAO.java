package com.cg.bsappl.dao;

import com.cg.bsappl.beans.Account;
import com.cg.bsappl.beans.Customer;

public interface AccountDAO {

	public Account getAccountById(int Id);
	
	public void createAccount(Account account);
	
	public void deleteAccount(int id);
	
	public void updateAccount(Account updateAccount);
	
	public int getNumberofAccounts();
}
