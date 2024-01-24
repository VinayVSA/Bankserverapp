package com.cg.bsappl.dao;

import com.cg.bsappl.beans.Customer;
import com.cg.bsappl.util.ArrayUtil;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Customer getCustomerdetailsById(int id) {
		
		return ArrayUtil.getCustomerdetailsById(id);
	}

	@Override
	public void addCustomer(Customer customer) {
		ArrayUtil.addCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(int id) {
		ArrayUtil.deleteCustomerById(id);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		ArrayUtil.updateCustomer(customer);
		
	}

}
