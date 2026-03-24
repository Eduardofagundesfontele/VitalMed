package com.developer.VitalMed.controller;

import com.developer.VitalMed.domain.dto.auth.AuthRegisterRequest;
import com.developer.VitalMed.domain.dto.auth.AuthRequest;
import com.developer.VitalMed.domain.model.UserModel;
import com.developer.VitalMed.domain.repository.UserRepository;
import com.developer.VitalMed.infra.security.filter.JwtFilter;
import com.developer.VitalMed.infra.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostMapping(("/login"))
    public String login(@RequestBody AuthRequest request){
        var authToken = new UsernamePasswordAuthenticationToken(request.email(),request.password());

    authenticationManager.authenticate(authToken);

    return jwtService.generateToken(request.email());
    }
    @PostMapping("/register")
    public String register(@RequestBody AuthRegisterRequest request){
        UserModel user = new UserModel();
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(request.role());

        userRepository.save(user);

        return "User created successfully";


    }



}
