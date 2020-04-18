package com.project.base.definition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApiErrorDefinitions {

    private static final String NOT_FOUND = "NOT_FOUND";
    private static final String FORBIDDEN = "FORBIDDEN";

    public ApiError customerNotFoundApiErrorObject() {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTitle(NOT_FOUND);
        error.setDetail("Username does not exist!");
        return error;
    }

    public ApiError customUserNameNotFoundApiErrorObject() {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTitle(NOT_FOUND);
        error.setDetail("No customer with this username!");
        return error;
    }

    public ApiError customBadCredentialsApiErrorObject() {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.FORBIDDEN.value());
        error.setTitle(FORBIDDEN);
        error.setDetail("The credentials are invalid!");
        return error;
    }
}
