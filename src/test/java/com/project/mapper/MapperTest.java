package com.project.mapper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.project.dao.CustomerDAOMock;
import com.project.model.dao.CustomerDAO;
import com.project.model.dto.CustomerDTO;
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
    private CustomerDAOMock customerDAOMock;

    @BeforeEach
    void setup() {
        mapper = new Mapper(passwordEncoder);
        customerDAOMock = new CustomerDAOMock();
    }

    @Test
    void convertDtoToDaoPositive() {
        // given
        CustomerDTO dto = createCustomerDTO();
        CustomerDAO expected = customerDAOMock.getCustomerDAO();
        when(passwordEncoder.encode(any())).thenReturn(CustomerDAOMock.password);

        // when
        CustomerDAO actual = mapper.convertDtoToDao(dto, CustomerDAOMock.id);

        // then
        assertEquals(expected, actual);
    }

    private CustomerDTO createCustomerDTO() {
        CustomerDTO dto = new CustomerDTO();
        dto.setDateOfBirth(CustomerDAOMock.dateOfBirth);
        dto.setLastName(CustomerDAOMock.lastName);
        dto.setFirstName(CustomerDAOMock.firstName);
        dto.setPassword(CustomerDAOMock.password);
        dto.setUserName(CustomerDAOMock.userName);
        return dto;
    }
}
