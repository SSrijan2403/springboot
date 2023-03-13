package com.authentication.authenticate.repository;

import com.authentication.authenticate.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Integer> {
     Customer findByUserName(String userName);
}
