package com.tesys.netwebpage.security;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.tesys.netwebpage.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    private final String SECRET_KEY = "super-secret-key-that-is-at-least-256-bits-long-for-hmac-sha256";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("role", user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
