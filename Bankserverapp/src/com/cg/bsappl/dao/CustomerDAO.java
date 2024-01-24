package com.cg.bsappl.dao;

import com.cg.bsappl.beans.Customer;

public interface CustomerDAO {
	
	public Customer getCustomerdetailsById(int id);

	public void addCustomer(Customer customer);

	public void deleteCustomer(int id);

	public void updateCustomer(Customer customer);

}
