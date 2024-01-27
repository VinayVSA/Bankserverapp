package com.cg.bsappl.dao;

import com.cg.bsappl.beans.Account;
import com.cg.bsappl.exception.AccountException;
import com.cg.bsappl.util.ArrayUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account getAccountById(int Id) {

		return ArrayUtil.getAccountdetailsById(Id);
	}

	@Override
	public void createAccount(Account account) {
		ArrayUtil.CreateAccount(account);
		
	}

	@Override
	public int getNumberofAccounts() {
		
		return ArrayUtil.getNumberofAccount();
	}

	@Override
	public void updateAccount(Account updateAccount) {
		ArrayUtil.updateAccount(updateAccount);
		
	}

	@Override
	public void deleteAccount(int id) throws AccountException {
		
		ArrayUtil.deleteAccountById(id);
		
	}

	

}
