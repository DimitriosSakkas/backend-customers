package com.project.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class UsernameIsTakenException extends RuntimeException {

    public UsernameIsTakenException() {
        super("this username is already in use!");
    }

}
