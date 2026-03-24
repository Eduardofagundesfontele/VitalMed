package com.developer.VitalMed.infra.security.service;

import com.developer.VitalMed.domain.model.UserModel;
import com.developer.VitalMed.domain.repository.UserRepository;
import com.developer.VitalMed.infra.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        UserModel user = repository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found"));
        return new UserDetailsImpl(user);
    }
}
