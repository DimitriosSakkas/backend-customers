package com.project.service;

import com.project.model.dao.CustomerDAO;
import com.project.model.dto.CustomerDTO;
import java.security.Principal;
import java.util.List;

public interface CustomerService {

    CustomerDAO updateCustomer(Principal principal, CustomerDTO customerDTO);

    List<CustomerDAO> retrieveCustomerList();
}
