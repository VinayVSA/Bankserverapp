package com.cg.bsappl.dao;

import com.cg.bsappl.beans.Transaction;
import com.cg.bsappl.util.ArrayUtil;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public void addTransaction(Transaction transaction) {
		
		ArrayUtil.addTransaction(transaction);
		
	}

	@Override
	public Transaction[] getTransactionsByAccountId(int accId) {
		
		return ArrayUtil.getTransactionsByAccountId(accId);
	}

}
