package com.project.controller;

import com.project.base.exception.CustomBadCredentialsException;
import com.project.model.dao.CustomerDAO;
import com.project.model.dto.CredentialsDTO;
import com.project.model.dto.CustomerDTO;
import com.project.model.dto.JwtAuthenticationResponse;
import com.project.service.CustomerDetailsService;
import com.project.service.CustomerService;
import com.project.util.AuthorizationUtilImpl;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController {

    private final CustomerService customerService;
    private final AuthorizationUtilImpl authorizationUtil;
    private final CustomerDetailsService customerDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerController(CustomerService customerService,
        AuthorizationUtilImpl authorizationUtil,
        CustomerDetailsService customerDetailsService,
        PasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.authorizationUtil = authorizationUtil;
        this.customerDetailsService = customerDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtAuthenticationResponse> authenticateCustomer(
        @Valid @RequestBody CredentialsDTO dto) {
        final UserDetails userDetails = customerDetailsService
            .loadUserByUsername(dto.getUserName());
        if (passwordEncoder.matches(dto.getPassword(), userDetails.getPassword())) {
            final String jwtToken = authorizationUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwtToken, "Bearer"));
        } else {
            throw new CustomBadCredentialsException();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDAO> updateCustomer(
        @Valid @RequestBody CustomerDTO dto, Principal principal) {
        CustomerDAO dao = customerService.updateCustomer(principal, dto);
        log.info("customer's data have been updated");
        return ResponseEntity.ok(dao);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDAO>> retrieveCustomerList() {
        return ResponseEntity.ok(customerService.retrieveCustomerList());
    }

}
