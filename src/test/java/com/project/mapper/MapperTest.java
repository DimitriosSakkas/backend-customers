package com.project.mapper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.project.model.dao.CustomerDAO;
import com.project.model.dto.CustomerDTO;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class MapperTest {

    private Mapper mapper;
    @Mock
    private PasswordEncoder passwordEncoder;

    private final static int id = 1;
    private final static String userName = "username";
    private final static String firstName = "firstname";
    private final static String lastName = "lastname";
    private final Date dateOfBirth = new Date();
    private final static String password = "password";

    @BeforeEach
    void setup() {
        mapper = new Mapper(passwordEncoder);
    }

    @Test
    void convertDtoToDaoPositive() {
        // given
        CustomerDTO dto = createCustomerDTO();
        CustomerDAO expected = createCustomerDAO();
        when(passwordEncoder.encode(any())).thenReturn(password);

        // when
        CustomerDAO actual = mapper.convertDtoToDao(dto, id);

        // then
        assertEquals(expected, actual);
    }

    private CustomerDTO createCustomerDTO() {
        CustomerDTO dto = new CustomerDTO();
        dto.setDateOfBirth(dateOfBirth);
        dto.setLastName(lastName);
        dto.setFirstName(firstName);
        dto.setPassword(password);
        dto.setUserName(userName);
        return dto;
    }

    private CustomerDAO createCustomerDAO() {
        CustomerDAO dao = new CustomerDAO();
        dao.setId(id);
        dao.setDateOfBirth(dateOfBirth);
        dao.setLastName(lastName);
        dao.setFirstName(firstName);
        dao.setPassword(password);
        dao.setUserName(userName);
        return dao;
    }

}
