package com.project.mapper;

import com.project.model.dao.CustomerDAO;
import com.project.model.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements Mapper {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MapperImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public CustomerDAO convertDtoToDao(CustomerDTO customerDTO, int id) {
        CustomerDAO dao = new CustomerDAO();
        dao.setId(id);
        dao.setUserName(customerDTO.getUserName());
        dao.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        dao.setFirstName(customerDTO.getFirstName());
        dao.setLastName(customerDTO.getLastName());
        dao.setDateOfBirth(customerDTO.getDateOfBirth());
        return dao;
    }
}
