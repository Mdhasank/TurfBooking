package com.turf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.turf.enities.Customer;
import com.turf.repository.CustomerRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customer = customerRepository.findByEmail(username);
								
		if (customer == null) {
			throw new UsernameNotFoundException("User Not Found");
		}else {
			return new CustomUser(customer);
		}
		
        }
		
	

}
