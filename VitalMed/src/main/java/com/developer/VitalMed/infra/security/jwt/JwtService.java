package com.developer.VitalMed.infra.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private String secret = "segredo";

    public String generateToken (String email){
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
    public String getEmail(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean isValid(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        return true;
        }catch (Exception e){
            return false;
        }
    }

}
