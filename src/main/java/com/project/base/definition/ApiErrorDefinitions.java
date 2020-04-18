package com.project.base.definition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApiErrorDefinitions {

    private static final String NOT_FOUND = "NOT_FOUND";

    public ApiError customerNotFoundApiErrorObject() {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTitle(NOT_FOUND);
        error.setDetail("No such customer exists!");
        return error;
    }

    public ApiError customUserNameNotFoundApiErrorObject() {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTitle(NOT_FOUND);
        error.setDetail("No such username exists!");
        return error;
    }
}
