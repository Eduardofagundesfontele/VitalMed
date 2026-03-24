package com.developer.VitalMed.infra.security.filter;

import com.developer.VitalMed.infra.security.jwt.JwtService;
import com.developer.VitalMed.infra.security.service.UserDetailsServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class JwtFilter extends GenericFilter {

 
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String token = req.getHeader("Athorization");
        if (token != null && token.startsWith("Bearer")) {
            token = token.replace("Bearer", "");
        }
        if (jwtService.isValid(token)) {
            String email = jwtService.getEmail(token);

            var user = userDetailsService.loadUserByUsername(email);

            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    filterChain.doFilter(servletRequest,servletResponse);

    }
}
