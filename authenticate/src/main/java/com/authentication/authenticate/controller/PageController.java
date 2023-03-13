package com.authentication.authenticate.controller;

import com.authentication.authenticate.model.Customer;
import com.authentication.authenticate.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private CustomerRepository repository;
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("customer" , new Customer());

        return "registrationForm";
    }
    @PostMapping("/process_signup")
    public String processSignup(Customer customer){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode(customer.getPassword());
        customer.setPassword(encoded);

        repository.save(customer);
        return "signupSuccess";
    }
    @GetMapping("/customers")
    public String showData(Model model){
        List<Customer> customerList = repository.findAll();
        model.addAttribute("customerList" , customerList);
        return "customers";
    }
    @GetMapping("/users")
    public String userPage(){
        return "users";
    }
}
