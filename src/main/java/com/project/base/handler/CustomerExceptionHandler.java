package com.project.base.handler;

import com.project.base.definition.ApiError;
import com.project.base.definition.ApiErrorDefinitions;
import com.project.base.exception.CustomUsernameNotFoundException;
import com.project.base.exception.CustomerNotFoundException;
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

    @Autowired
    private ApiErrorDefinitions apiErrorDefinitions;
    private final HttpHeaders headers;

    public CustomerExceptionHandler() {
        this.headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "problem+json"));
    }

    @ResponseBody
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiError> handleCustomerNotFound(CustomerNotFoundException ex) {
        log.error(ex.getMessage());
        ApiError error = new ApiError();
        apiErrorDefinitions.customerNotFoundApiErrorObject();
        return new ResponseEntity<>(error, headers, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(CustomUsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNameNotFound(CustomUsernameNotFoundException ex) {
        log.error(ex.getMessage());
        ApiError error = new ApiError();
        apiErrorDefinitions.customUserNameNotFoundApiErrorObject();
        return new ResponseEntity<>(error, headers, HttpStatus.NOT_FOUND);
    }

}
