package com.cg.bsappl.dao;

import com.cg.bsappl.beans.Transaction;

public interface TransactionDAO {
	
	
public void addTransaction(Transaction transaction);

public Transaction[] getTransactionsByAccountId(int accId);
	
	
}
