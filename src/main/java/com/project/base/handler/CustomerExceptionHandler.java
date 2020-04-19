package com.project.base.handler;

import com.project.base.definition.ApiError;
import com.project.base.definition.ApiErrorDefinitions;
import com.project.base.exception.CustomBadCredentialsException;
import com.project.base.exception.CustomUsernameNotFoundException;
import com.project.base.exception.CustomerNotFoundException;
import com.project.base.exception.UsernameIsTakenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class CustomerExceptionHandler {

    private final ApiErrorDefinitions apiErrorDefinitions;
    private final HttpHeaders headers;

    @Autowired
    public CustomerExceptionHandler(ApiErrorDefinitions apiErrorDefinitions) {
        this.headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "problem+json"));
        this.apiErrorDefinitions = apiErrorDefinitions;
    }

    @ResponseBody
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiError> handleCustomerNotFound(CustomerNotFoundException ex) {
        log.error(ex.getMessage());
        ApiError error = apiErrorDefinitions.customerNotFoundApiErrorObject(ex);
        return new ResponseEntity<>(error, headers, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(CustomUsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleCustomBadCredentialsException(
        CustomBadCredentialsException ex) {
        log.error(ex.getMessage());
        ApiError error = apiErrorDefinitions.customUserNameNotFoundApiErrorObject(ex);
        return new ResponseEntity<>(error, headers, HttpStatus.FORBIDDEN);
    }

    @ResponseBody
    @ExceptionHandler(CustomBadCredentialsException.class)
    public ResponseEntity<ApiError> handleUserNameNotFound(CustomBadCredentialsException ex) {
        log.error(ex.getMessage());
        ApiError error = apiErrorDefinitions.customUserNameNotFoundApiErrorObject(ex);
        return new ResponseEntity<>(error, headers, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(UsernameIsTakenException.class)
    public ResponseEntity<ApiError> handleUserNameNotFound(UsernameIsTakenException ex) {
        log.error(ex.getMessage());
        ApiError error = apiErrorDefinitions.usernameIsTakenExceptionApiErrorObject(ex);
        return new ResponseEntity<>(error, headers, HttpStatus.NOT_FOUND);
    }
}
