package com.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.project.base.exception.UsernameIsTakenException;
import com.project.dao.CustomerDAOMock;
import com.project.mapper.Mapper;
import com.project.model.dao.CustomerDAO;
import com.project.model.dto.CustomerDTO;
import com.project.repository.CustomerRepository;
import java.security.Principal;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private Mapper mapper;
    @Mock
    private Principal principal;

    private CustomerDAOMock customerDAOMock;
    private CustomerDTO customerDTO;

    @BeforeEach
    void setup() {
        customerDAOMock = new CustomerDAOMock();
        customerDTO = createCustomerDTO();
    }

    @Test
    void updateCustomerIfUsernameAlreadyExistsNegative() {
        // given
        when(customerRepository.existsCustomerDAOByUserName(anyString())).thenReturn(true);

        // when & then
        assertThrows(UsernameIsTakenException.class, () -> {
            customerService.updateCustomer(principal, customerDTO);
        });
    }

    @Test
    void updateCustomerPositive() {
        // given
        CustomerDAO expected = customerDAOMock.getCustomerDAO();
        when(principal.getName()).thenReturn(CustomerDAOMock.userName);
        when(customerRepository.existsCustomerDAOByUserName(anyString())).thenReturn(false);
        when(customerRepository.findCustomerDAOByUserName(anyString()))
            .thenReturn(Optional.of(expected));
        when(mapper.convertDtoToDao(any(), eq(CustomerDAOMock.id))).thenReturn(expected);
        when(customerRepository.save(any())).thenReturn(expected);

        // when
        CustomerDAO actual = customerService.updateCustomer(principal, customerDTO);

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
