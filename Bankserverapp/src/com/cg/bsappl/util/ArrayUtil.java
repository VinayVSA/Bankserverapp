package com.cg.bsappl.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import com.cg.bsappl.beans.Account;
import com.cg.bsappl.beans.Customer;
import com.cg.bsappl.beans.Transaction;
import com.cg.bsappl.exception.AccountException;

public class ArrayUtil {
	
	static Account acc[]=new Account[10];
	static Customer cust[]=new Customer[10];
	static Transaction trans[]=new Transaction[10];
	static {
		cust[0]=new Customer(1,"vinay","achalla","vinay@gmail.com");
		cust[1]=new Customer(2,"ram","achalla","ram@gmail.com");
		cust[2]=new Customer(3,"ram","achalla","ram@gmail.com");
		cust[3]=new Customer(4,"ram","achalla","ram@gmail.com");
		cust[4]=new Customer(5,"ram","achalla","ram@gmail.com");
		cust[5]=new Customer(6,"ram","achalla","ram@gmail.com");
		cust[6]=new Customer(7,"ram","achalla","ram@gmail.com");
		cust[7]=new Customer(8,"ram","achalla","ram@gmail.com");
		cust[8]=new Customer(9,"ram","achalla","ram@gmail.com");
		cust[9]=new Customer(10,"ram","achalla","ram@gmail.com");
		
		acc[0]=new Account(1,10000.0,cust[0]);
		acc[1]=new Account(2,9500.0,cust[1]);
		acc[2]=new Account(3,19500.0,cust[1]);
		acc[3]=new Account(4,9501.0,cust[1]);
		acc[4]=new Account(5,7500.0,cust[1]);
		acc[5]=new Account(6,6500.0,cust[1]);
		acc[6]=new Account(7,7500.0,cust[1]);
		acc[7]=new Account(8,8500.0,cust[1]);
		acc[8]=new Account(9,9900.0,cust[1]);
		acc[9]=new Account(10,20500.0,cust[1]);
		
	
	}
	
//
    
	public static void CreateAccount(Account acc1)
	{
	acc=Arrays.copyOf(acc,acc.length+1);
	for(int i=0;i<acc.length;i++)
	{
		if(acc[i]==null)
		{
			acc[i]=acc1;
		}
	}
	
	}
	public static void deleteAccountById(int id)throws AccountException, NullPointerException
	{
    boolean da=false;
	for(int i=0;i<acc.length;i++)
	{
	 if(acc[i].getAccountNum()==id && acc[i]!=null)
	 {
		 acc[i]=null;
		da=true;
		 break;
	 }
	 
		
	}
	if(!da)
	{
		throw new NullPointerException("The account of account number "+id+"did not exist");
	}
	
	}
	public static void updateAccount(Account updateAccount)
	{
		
		for(int i=0;i<acc.length;i++)
		{
			if(acc[i].getAccountNum()==updateAccount.getAccountNum())
			{
				acc[i]=updateAccount;
				break;
				
			}
		}
		
	}
	public static Account getAccountdetailsById(int accNum) {	
     for (int i = 0; i < acc.length; i++)
     {
      if (acc[i] != null && acc[i].getAccountNum() == accNum)
      {
       return acc[i];
      }
     }
     return null;
     }
	public static int getNumberofAccount()
	{
		return acc.length;
	}
	
	public static void addCustomer(Customer customer) {
		cust = Arrays.copyOf(cust, cust.length + 1);
        for (int i = 0; i < cust.length; i++) {
            if (cust[i] == null) {
            	cust[i] = customer;
                break;
            }
        }
    }

    public static void deleteCustomerById(int customerId) {
        for (int i = 0; i < cust.length; i++) {
            if (cust[i] != null && cust[i].getCustomerId() == customerId) {
            	cust[i] = null;
                break;
            }
        }
    }
    
    public static void updateCustomer(Customer updateCustomer)
    {
    	for(int i=0;i<cust.length;i++)
    	{
    		if(cust[i].getCustomerId()==updateCustomer.getCustomerId())
    		{
    			cust[i]=updateCustomer;
    			break;
    		}
    	}
    }
    public static Customer getCustomerdetailsById(int id)
    {
    	for(int i=0;i<cust.length;i++)
    	{
    		if(cust[i].getCustomerId()==id && cust[i]!=null)
    		{
    			return cust[i];
    		}
    	}
    	return null;
    }
    
    public static void addTransaction(Transaction transaction)
    {
    	trans=Arrays.copyOf(trans,trans.length+1);
    	for(int i=0;i<trans.length;i++)
    	{
    		if(trans[i]==null)
    		{
    			trans[i]=transaction;
    			break;
    		}
    	}
    }
   
   
    public static Transaction[] getTransactionsByAccountId(int accId) {
        Transaction[] allTransactions = trans;
        int count = 0;

        
        for (Transaction transaction : allTransactions) {
            if (transaction != null && transaction.getAccountId() == accId) {
                count++;
            }
        }

        
        Transaction[] accountTransactions = new Transaction[count];
        int index = 0;

        
        for (Transaction transaction : allTransactions) {
            if (transaction != null && transaction.getAccountId() == accId) {
                accountTransactions[index++] = transaction;
            }
        }

        return accountTransactions;
    }
   
	
}
