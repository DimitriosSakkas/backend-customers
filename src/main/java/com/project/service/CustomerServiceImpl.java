package com.project.service;

import com.project.mapper.Mapper;
import com.project.model.dao.CustomerDAO;
import com.project.model.dto.CustomerDTO;
import com.project.repository.CustomerRepository;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final Mapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, Mapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public CustomerDAO updateCustomer(Principal principal, CustomerDTO customerDTO) {
        log.info("find the customer to update his data");
        Optional<CustomerDAO> customerDAO = customerRepository
            .findCustomerDAOByUserName(principal.getName());
        customerRepository.deleteCustomerDAOByUserName(principal.getName());
        return customerRepository
            .save(mapper.convertDtoToDao(customerDTO, customerDAO.get().getId()));
    }


    @Override
    public List<CustomerDAO> retrieveCustomerList() {
        log.info("start retrieving 3 customers data");
        Pageable paging = PageRequest.of(0, 3, Sort.by("dateOfBirth").descending());
        Page<CustomerDAO> pagedResult = customerRepository.findAll(paging);
        log.info("all customers: {}", customerRepository.findAll());
        return pagedResult.getContent();
    }
}
