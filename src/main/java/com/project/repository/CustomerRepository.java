package com.project.repository;

import com.project.model.dao.CustomerDAO;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<CustomerDAO, Integer> {

    Optional<CustomerDAO> findCustomerDAOByUserName(String userName);

    void deleteCustomerDAOByUserName(String userName);
}
