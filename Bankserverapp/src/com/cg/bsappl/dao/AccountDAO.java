package com.cg.bsappl.dao;

import com.cg.bsappl.beans.Account;
import com.cg.bsappl.beans.Customer;
import com.cg.bsappl.exception.AccountException;

public interface AccountDAO {

	public Account getAccountById(int Id);
	
	public void createAccount(Account account);
	
	public void deleteAccount(int id)throws AccountException;
	
	public void updateAccount(Account updateAccount);
	
	public int getNumberofAccounts();
}
