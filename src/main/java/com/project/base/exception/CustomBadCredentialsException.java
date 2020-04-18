package com.project.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class CustomBadCredentialsException extends RuntimeException {

    public CustomBadCredentialsException() {
        super(" Bad credential");
    }

}
