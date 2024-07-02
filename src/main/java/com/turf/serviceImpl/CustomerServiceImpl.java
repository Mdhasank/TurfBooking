package com.turf.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.turf.enities.Customer;
import com.turf.repository.CustomerRepository;
import com.turf.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Customer saveCustomer(Customer customer) {

		String password = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(password);
		customer.setRole("ROLE_USER");
		return customerRepository.save(customer);
	}

	@Override
	public boolean existsByEmail(String email) {

		return customerRepository.existsByEmail(email);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// Get the currently logged-in user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// Check if the principal is an instance of UserDetails and retrieve the
		// username
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		// Check if the logged-in user is an admin
		if (username != null && username.equals("admin")) {
			// If the user is an admin, fetch all customers
			return customerRepository.findAll();
		} else {
			// If the user is not an admin, fetch only customers with ROLE_USER
			return customerRepository.findByRole("ROLE_USER");
		}
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");

	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		return customer;
	}

}
