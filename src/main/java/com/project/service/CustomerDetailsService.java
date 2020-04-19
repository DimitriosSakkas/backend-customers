package com.project.service;

import com.project.base.exception.CustomerNotFoundException;
import com.project.model.dao.CustomerDAO;
import com.project.repository.CustomerRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final CustomerDAO customerDAO = customerRepository
            .findCustomerDAOByUserName(username).orElseThrow(CustomerNotFoundException::new);

        return new User(customerDAO.getUserName(), customerDAO.getPassword(), new ArrayList<>());
    }

}
