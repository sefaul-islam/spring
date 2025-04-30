package com.example.nobs.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Custom_UserRepo customUserRepo;

    public CustomUserDetailsService(Custom_UserRepo customUserRepo) {
        this.customUserRepo = customUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Custom_User customUser = customUserRepo.findById(username).get();

        return User
                .withUsername(customUser.getUsername())
                .password(customUser.getPassword()).build();
    }
}
