package com.project.base.definition;

import com.project.base.exception.CustomBadCredentialsException;
import com.project.base.exception.CustomUsernameNotFoundException;
import com.project.base.exception.CustomerNotFoundException;
import com.project.base.exception.UsernameIsTakenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApiErrorDefinitions {

    private static final String NOT_FOUND = "NOT_FOUND";
    private static final String FORBIDDEN = "FORBIDDEN";

    public ApiError customerNotFoundApiErrorObject(CustomerNotFoundException ex) {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTitle(NOT_FOUND);
        error.setDetail(ex.getMessage());
        return error;
    }

    public ApiError customUserNameNotFoundApiErrorObject(CustomBadCredentialsException ex) {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTitle(NOT_FOUND);
        error.setDetail(ex.getMessage());
        return error;
    }

    public ApiError customBadCredentialsApiErrorObject(CustomUsernameNotFoundException ex) {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.FORBIDDEN.value());
        error.setTitle(FORBIDDEN);
        error.setDetail(ex.getMessage());
        return error;
    }

    public ApiError usernameIsTakenExceptionApiErrorObject(UsernameIsTakenException ex) {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.FORBIDDEN.value());
        error.setTitle(FORBIDDEN);
        error.setDetail(ex.getMessage());
        return error;
    }
}
