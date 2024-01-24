package com.cg.bsappl.service;


import com.cg.bsappl.beans.Account;
import com.cg.bsappl.exception.AccountException;

public interface AccountService {

	public void deposit(int accNum,double dAmount)throws AccountException;
	
	public void withdraw(int accNum,double wAmount )throws AccountException;
	
	public void transfer(int fromaccNum,int toaccNum,double transAmount )throws AccountException;

	public Account getAccountById(int accNum);
	
	public void createAccount(Account account);
	
	public void deleteAccount(int id);
	
	public  void updateAccount(Account updateAccount);
	
	public int getNumberofAccount();
	
}
