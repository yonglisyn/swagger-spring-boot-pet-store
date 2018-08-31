package com.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class PetAuthenticationProvider implements AuthenticationProvider {

    private final Map<String,String> users;

    @Autowired
    public PetAuthenticationProvider() {
        this.users = new HashMap<>();
        this.users.put("yong1","pass1");
        this.users.put("yong2","pass2");
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if(users.get(username).equals(password)){
            return new UsernamePasswordAuthenticationToken(username,password, Collections.singletonList(new SimpleGrantedAuthority("Role_Role")));
        }
        throw new BadCredentialsException("Wrong credentials");
    }

    //tells the authentication manager that, this AuthenticationProvider supports the authentication provided by UsernamePasswordAuthenticationToken
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
