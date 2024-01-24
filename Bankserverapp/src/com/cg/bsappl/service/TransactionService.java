package com.cg.bsappl.service;

import java.util.Date;

import com.cg.bsappl.beans.Transaction;

public interface TransactionService {
	
	public void addTransaction(Transaction transaction);

	public Transaction[] getTransactionsByAccountId(int accId);
	
	public Transaction[] getTransactionByDate(Date startdate,Date enddate);
	
}
