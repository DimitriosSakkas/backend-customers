package com.project.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomUsernameNotFoundException extends RuntimeException {

    public CustomUsernameNotFoundException() {
        super("The credentials are invalid!");
    }

}