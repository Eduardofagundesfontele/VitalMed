package com.developer.VitalMed.infra.security.filter;

import com.developer.VitalMed.infra.security.jwt.JwtService;
import com.developer.VitalMed.infra.security.service.UserDetailsServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter extends GenericFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        // Pega o token do header Authorization
        String token = req.getHeader("Authorization");
        System.out.println("Token recebido: " + token);

        // Remove o prefixo "Bearer " e limpa espaços extras
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7).trim();
        }

        System.out.println("Token limpo: " + token);

        // Verifica se o token é válido
        if (token != null && jwtService.isValid(token)) {
            String email = jwtService.getEmail(token);
            System.out.println("Token válido para o usuário: " + email);

            // Busca o usuário no banco pelo email do token
            var user = userDetailsService.loadUserByUsername(email);

            // Cria a autenticação do Spring Security
            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            // Coloca o usuário autenticado no contexto do Spring
            SecurityContextHolder.getContext().setAuthentication(auth);

        } else if (token != null) {
            System.out.println("Token inválido!");
        } else {
            System.out.println("Nenhum token enviado!");
        }

        // Continua a execução da requisição
        filterChain.doFilter(servletRequest, servletResponse);
    }
}