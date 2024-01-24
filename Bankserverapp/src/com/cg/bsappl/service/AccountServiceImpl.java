package com.cg.bsappl.service;

import com.cg.bsappl.beans.Account;
import com.cg.bsappl.exception.AccountException;
import com.cg.bsappl.dao.*;
import com.cg.bsappl.beans.Transaction;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountdao;
	private TransactionService transactionService;
	
	public AccountServiceImpl(AccountDAO accountdao,TransactionService transactionService)
	{
		this.accountdao=accountdao;
		this.transactionService=transactionService;
	}
	
	@Override
	public void deposit(int accNum, double dAmount) throws AccountException {
		Account account =accountdao.getAccountById(accNum);
        if (account == null) {
            System.out.println("Account not found for account number: " + accNum);
        }
        else 
        {
        account.setBalance(account.getBalance() + dAmount);
        Transaction depositTransaction = new Transaction(accNum, dAmount, "deposit");
        transactionService.addTransaction(depositTransaction);
        System.out.println("The amount"+dAmount+"is deposited into the accountno: "+account.getAccountNum());
        }
	}

	@Override
	public void withdraw(int accNum, double wAmount) throws AccountException {
		Account account =accountdao.getAccountById(accNum);
		if (account == null) {
			System.out.println("Account not found for account number: " + accNum);
        }
		else if (account.getBalance() < wAmount) 
        {
        	System.out.println("Insufficient balance for withdrawal from account number: " + accNum);
        }
        else 
        {
        account.setBalance(account.getBalance() - wAmount);
        Transaction withdrawTransaction = new Transaction(accNum, wAmount, "withdraw");
        transactionService.addTransaction(withdrawTransaction);
        System.out.println("The amount "+wAmount+" is withdrawn from accountNo "+account.getAccountNum());
        }
	}

	@Override
	public void transfer(int fromaccNum, int toaccNum, double transAmount) throws AccountException {
		Account account1=accountdao.getAccountById(fromaccNum);
		Account account2=accountdao.getAccountById(toaccNum);
		if(account1.getBalance()>=transAmount)
		{
			System.out.println("The current balance of account number "+account1.getAccountNum()+" is:"+account1.getBalance());
			System.out.println("The current balance of account number "+account2.getAccountNum()+" is:"+account2.getBalance());
			account1.setBalance(account1.getBalance()-transAmount);
			Transaction transferOutTransaction = new Transaction(fromaccNum, transAmount, "transfer_out");
			transactionService.addTransaction(transferOutTransaction);
			System.out.println("Balance of account "+account1.getAccountNum() +"After transfer of amount="+transAmount+"from account number:"+account1.getAccountNum()+" is:"+account1.getBalance());
			account2.setBalance(account2.getBalance()+transAmount);
			Transaction transferInTransaction = new Transaction(toaccNum,transAmount, "transfer_in");
			transactionService.addTransaction(transferInTransaction);
			System.out.println("Balance of account "+account2.getAccountNum() +"After transfer of amount="+transAmount+"to account number:"+account2.getAccountNum()+" is:"+account2.getBalance());
		}
		else
		{
			System.out.println("Not sufficient amount to tranfer from account number"+account1.getAccountNum()+"to account number"+account2.getAccountNum());
		}
		
		
	}

	@Override
	public Account getAccountById(int accNum) {
		 return accountdao.getAccountById(accNum);
	}

	@Override
	public void createAccount(Account account) {
		accountdao.createAccount(account);
		
	}

	@Override
	public int getNumberofAccount() {
		
		return accountdao.getNumberofAccounts();
	}

	@Override
	public void updateAccount(Account updateAccount) {
		accountdao.updateAccount(updateAccount);
		
	}

	@Override
	public void deleteAccount(int id) {
		accountdao.deleteAccount(id);
		
	}

	 

}
