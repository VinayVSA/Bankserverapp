package com.cg.bsappl.service;


import com.cg.bsappl.beans.Customer;



public interface CustomerService {

public Customer getCustomerdetailsById(int id);

public void addCustomer(Customer customer);

public void deleteCustomer(int id);

public void updateCustomer(Customer customer);
	
}
