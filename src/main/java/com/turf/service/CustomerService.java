package com.turf.service;

import java.util.List;
import com.turf.enities.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);

	public boolean existsByEmail(String email);

	public List<Customer> getAllCustomers();

	public boolean deleteCustomer(int id);
	
	public void removeSessionMessage();
		
	
	public Customer getCustomerById(int id);

}
