package com.showroom.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // The secret password only your server knows
    private final String SECRET_KEY = "secretkey";

    // This method creates the VIP wristband!
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // This goes into the Payload
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Expires in 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // The math that creates the Signature
                .compact();
    }
}