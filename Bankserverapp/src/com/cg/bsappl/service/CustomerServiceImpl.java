package com.cg.bsappl.service;

import com.cg.bsappl.beans.Customer;
import com.cg.bsappl.dao.CustomerDAO;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerdao;
	
	public CustomerServiceImpl(CustomerDAO customerdao)
	{
		this.customerdao=customerdao;
	}
	@Override
	public Customer getCustomerdetailsById(int id) {

		return customerdao.getCustomerdetailsById(id);
	}

	@Override
	public void addCustomer(Customer customer) {

		customerdao.addCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) {

		customerdao.deleteCustomer(id);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerdao.updateCustomer(customer);
		
	}

}
