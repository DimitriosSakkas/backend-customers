package com.project.util;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthorizationUtil {

    String extractUsername(String token);

    boolean validateToken(String authToken);

    String generateToken(UserDetails userDetails);

}
