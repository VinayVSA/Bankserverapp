package com.cg.bsappl.ui;

import com.cg.bsappl.beans.Account;
import com.cg.bsappl.beans.Customer;
import com.cg.bsappl.beans.Transaction;
import com.cg.bsappl.dao.AccountDAOImpl;
import com.cg.bsappl.dao.TransactionDAO;
import com.cg.bsappl.dao.TransactionDAOImpl;
import com.cg.bsappl.dao.CustomerDAOImpl;
import com.cg.bsappl.exception.AccountException;
import com.cg.bsappl.exception.CustomerException;
import com.cg.bsappl.exception.TransactionException;
import com.cg.bsappl.service.AccountService;
import com.cg.bsappl.service.AccountServiceImpl;
import com.cg.bsappl.service.TransactionServiceImpl;
import com.cg.bsappl.service.CustomerServiceImpl;
import com.cg.bsappl.service.CustomerService;

import java.util.*;
public class BankappUi {
	private static AccountService accountService=new AccountServiceImpl(new AccountDAOImpl(),new TransactionServiceImpl(new TransactionDAOImpl()));
	private static CustomerService customerService=new CustomerServiceImpl(new CustomerDAOImpl());
public static void main(String args[])
{
	
	Scanner s=new Scanner(System.in);
	
	System.out.println("========================Welcome to The bank of ABC========================");
	while(true)
	{
		System.out.println("1.Login as Admin");
		System.out.println("2.Login as Customer");
		System.out.println("0.Exit bank application");
		try {
		int log=s.nextInt();
		
		switch(log)
		{
			case 1:
				
				adminPage();
				
				
				break;
			case 2:
				
				customerPage();
				
				
				break;
			case 0:
				System.out.println("Leaving the bank application...");
				System.exit(0);
				break;
			default:
				System.out.println("Enter valid choice");
		}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter only valid integers");
			s.nextLine();
		}
	}
		
	
}

public static void adminPage() 
{
	
	Scanner s1=new Scanner(System.in);
	while(true)
	{
		System.out.println("1.Create customerAccount");
		System.out.println("2.Delete customerAccount");
		System.out.println("3.Update customerDetails");
		System.out.println("0.Back to main menu");
		System.out.println("Enter your choice");;
		int Choice=s1.nextInt();
		switch(Choice)
		{
			case 1:
				
				System.out.println("Enter First Name: ");
				String fn=s1.next();
				System.out.println("Enter Last Name");
				String ln=s1.next();
				System.out.println("Enter EmailId");
				String ei=s1.next();
				System.out.println("Enter amount");
				int am=s1.nextInt();
				Customer c=new Customer(accountService.getNumberofAccount()+1,fn,ln,ei);
				customerService.addCustomer(c);
				accountService.createAccount(new Account(accountService.getNumberofAccount()+1,am,c));
				System.out.println("the account is added with account Number:"+accountService.getNumberofAccount());
				
				break;
			case 2:
				System.out.println("Enter customer Account Number to delete");
				int de=s1.nextInt();
				try {
				accountService.deleteAccount(de);
				System.out.println("customer Account of account number :"+de+" is deleted");
				}
				catch(NullPointerException e)
				{
					System.out.println("The account with account number: "+de+" did not exist");
				}
				catch(AccountException e)
				{
					System.out.println("Deletion of Account is unsuccessful");
				}
				break;
			case 3:
				
				System.out.println("Enter the customer Account number to update");
				int up=s1.nextInt();
				try {
				
				System.out.println("Current Customer details of the account no: "+up+"are=");
				System.out.println(accountService.getAccountById(up));
				System.out.println("Enter First Name");
				String upfn=s1.next();
				System.out.println("Enter Last Name");
				String upln=s1.next();
				System.out.println("Enter EmailId");
				String upeid=s1.next();
				Customer c1=new Customer(up,upfn,upln,upeid);
				customerService.updateCustomer(c1);
				
				accountService.updateAccount(new Account(up,accountService.getAccountById(up).getBalance(),new Customer(accountService.getAccountById(up).getCustomer().getCustomerId(),upfn,upln,upeid)));
				}
				catch(NullPointerException e)
				{
					System.out.println("The account with account number: "+up+" did not exist");
				}
				break;
			
			case 0:
				return;
			default:
				System.out.println("Enter valid choice");
		}
	}
	
}
public static void customerPage()
{
	
	Scanner s2=new Scanner(System.in);
	while(true) {
		System.out.println("================================================================");
        System.out.println("1.Display the balance for the Customer");
		System.out.println("2.Withdraw/deposit");
		System.out.println("3.Transfer money");
		System.out.println("4.Display transactions");
		System.out.println("5.Account customerDetails");
		System.out.println("0-Back to Main Menu");
		System.out.println("================================================================");
		
		System.out.println("Enter your choice:");
		
		int choice=s2.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("================================================================");
			System.out.println("Enter your Customer Account Number");
			System.out.println("================================================================");
			int accNum=s2.nextInt();
			Account account = accountService.getAccountById(accNum);
            if (account != null) {
                System.out.println("Account Balance for Account Number " + accNum + ": " + account.getBalance());
                System.out.println("================================================================");
            } else {
                System.out.println("Account not found for Account Number " + accNum);
                System.out.println("================================================================");
            }
			break;
		case 2:
			System.out.println("Enter 'deposit' or 'withdraw'  ");
			String type=s2.next();
			if(type.equals("deposit"))
			{
				try {
				System.out.println("Enter your account number");
				int accNum2=s2.nextInt();
				System.out.println("Enter the deposit amount");
				double amount=s2.nextDouble();
				accountService.deposit(accNum2, amount);
				}
				catch(AccountException e)
				{
					System.out.println("Deposit is unsuccessful");
				}
			}
			if(type.equals("withdraw"))
			{
				try {
				System.out.println("Enter your account number");
				int accNum3=s2.nextInt();
				System.out.println("Enter the withdraw amount");
				double amount=s2.nextDouble();
				accountService.withdraw(accNum3, amount);
				}
				catch(AccountException e)
				{
					System.out.println("withdraw is unsuccessful");
				}
			}
			break;
		case 3:
			try {
			System.out.println("Enter the money to transfer:");
			double amount=s2.nextDouble();
			System.out.println("Enter the from account number:");
			int accNum4=s2.nextInt();
			System.out.println("Enter the to account number:");
			int accNum5=s2.nextInt();
			accountService.transfer(accNum4, accNum5, amount);
			}
			catch(AccountException e)
			{
				System.out.println("Transfer is unsuccessful");
			}
			break;
		case 4:
			 System.out.println("Enter your Customer Account Number");
			    int accNum6 = s2.nextInt();
			    
			TransactionServiceImpl transactionService = new TransactionServiceImpl(new TransactionDAOImpl());
			
			    Transaction[] transactions = transactionService.getTransactionsByAccountId(accNum6);
			    
			    if (transactions != null && transactions.length > 0) {
			        System.out.println("Last 10 Transactions for Account Number " + accNum6 + ":");
			        for (int i =0; i < transactions.length; i++) {
			            Transaction transaction = transactions[i];
			            System.out.println("===========================================");
			            System.out.println("Account id =" + transaction.getAccountId());
			            System.out.println("Amount= " + transaction.getAmount());
			            System.out.println("Type= " + transaction.getType());
			            System.out.println("Transaction Date= " + transaction.getTransactionDate());
			            System.out.println("===========================================");
			        }
			    } else {
			        System.out.println("No transactions found for Account Number " + accNum6);
			    }

			    System.out.println("================================================================");
			break;
		case 5:
			System.out.println("Enter the account number to get customer details");
			int accNum7=s2.nextInt();
			System.out.println("the customer details of account number: "+accNum7+"are=");
			System.out.println(customerService.getCustomerdetailsById(accNum7));
			//System.out.println(accountService.getAccountById(accNum7));
		case 0:
			return;
		default:
			System.out.println("Please enter valid choice");
			break;
		}
	}
	
}

}
