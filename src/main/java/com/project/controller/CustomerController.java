package com.project.controller;

import com.project.model.dao.CustomerDAO;
import com.project.model.dto.CustomerDTO;
import com.project.model.dto.JwtAuthenticationResponse;
import com.project.service.CustomerDetailsService;
import com.project.service.CustomerService;
import com.project.util.AuthorizationUtilImpl;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CustomerService customerService;
    private AuthorizationUtilImpl authorizationUtil;
    private CustomerDetailsService customerDetailsService;
    private PasswordEncoder passwordEncoder;

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

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtAuthenticationResponse> authenticateCustomer(
        @Valid @RequestBody CustomerDTO customerDTO) {
        final UserDetails userDetails = customerDetailsService
            .loadUserByUsername(customerDTO.getUserName());
        if (passwordEncoder.matches(customerDTO.getPassword(), userDetails.getPassword())) {
            final String jwtToken = authorizationUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwtToken, "Bearer"));
        } else {
            throw new BadCredentialsException("Bad credentials");
        }

    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDAO> updateCustomer(
        @Valid @RequestBody CustomerDTO customerDTO, Principal principal) {
        return ResponseEntity.ok(customerService.updateCustomer(principal, customerDTO));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDAO>> retrieveCustomerList() {
        return ResponseEntity.ok(customerService.retrieveCustomerList());
    }

}
