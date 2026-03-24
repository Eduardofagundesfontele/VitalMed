package com.developer.VitalMed.infra.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret; // exemplo: "minhaSuperChaveSecreta123456"

    private Key getSigningKey() {
        // Converter a string secreta em Key
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    // Gerar token
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Extrair email do token
    public String getEmail(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token) // atenção: parseClaimsJws, não parseClaimsJwt
                .getBody();
        return claims.getSubject();
    }

    // Validar token
    public boolean isValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token); // parseClaimsJws obrigatório
            return true;
        } catch (Exception e) {
            System.out.println("Erro JWT: " + e.getMessage());
            return false;
        }
    }
}