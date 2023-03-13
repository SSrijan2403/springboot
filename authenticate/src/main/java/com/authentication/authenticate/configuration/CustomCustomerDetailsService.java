package com.authentication.authenticate.configuration;

import com.authentication.authenticate.model.Customer;
import com.authentication.authenticate.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomCustomerDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = repository.findByUserName(username);
        if (customer == null){
            throw new UsernameNotFoundException("Customer not found");
        }
        return new CustomCustomerDetails(customer);
    }
}
