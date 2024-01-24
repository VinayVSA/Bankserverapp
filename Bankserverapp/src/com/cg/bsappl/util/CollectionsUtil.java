package com.cg.bsappl.util;

import java.util.*;
import com.cg.bsappl.beans.*;
public class CollectionsUtil {
	
	private static List<Account> accounts=new ArrayList<>();
	private static List<Customer> customers=new ArrayList<>();
	private static List<Transaction> transactions=new ArrayList<>();
	
	static {
		customers.add(new Customer(1,"Leo","Das","leo@gmail.com"));
		customers.add(new Customer(2,"harold","Das","harold@gmail.com"));
		customers.add(new Customer(3,"Antony","Das","Antony@gmail.com"));
		customers.add(new Customer(4,"Ranvijay","singh","vijay@gmail.com"));
		customers.add(new Customer(5,"pushpa","raj","raj@gmail.com"));
	
		 accounts.add(new Account(1, 10000.0, customers.get(0)));
	     accounts.add(new Account(2, 9500.0, customers.get(1)));
	     accounts.add(new Account(3, 8500.0, customers.get(2)));
	     accounts.add(new Account(4, 7500.0, customers.get(3)));
	     accounts.add(new Account(5, 20000.0, customers.get(4)));
	        
	}

	public static void createAccount(Account acc1) {
        accounts.add(acc1);
    }

    public static void deleteAccountById(int id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNum() == id) {
                accounts.remove(i);
                break;
            }
        }
    }

    public static void updateAccount(Account updateAccount) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNum() == updateAccount.getAccountNum()) {
                accounts.set(i, updateAccount);
                break;
            }
        }
    }

    public static Account getAccountdetailsById(int accNum) {
        for (Account account : accounts) {
            if (account.getAccountNum() == accNum) {
                return account;
            }
        }
        return null;
    }

}
