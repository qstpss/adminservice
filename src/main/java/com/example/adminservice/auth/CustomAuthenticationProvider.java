package com.example.adminservice.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if ("user_read".equals(username) && "pass".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password,
                    List.of(new SimpleGrantedAuthority("ADMIN_READ")));
        } else if ("user_write".equals(username) && "pass".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password,
                    List.of(new SimpleGrantedAuthority("ADMIN_READ"),
                            new SimpleGrantedAuthority("ADMIN_WRITE")));
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
