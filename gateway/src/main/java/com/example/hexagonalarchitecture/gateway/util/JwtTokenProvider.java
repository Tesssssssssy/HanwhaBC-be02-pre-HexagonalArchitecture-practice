package com.example.hexagonalarchitecture.gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtTokenProvider {
    private String jwtSecret;

    public JwtTokenProvider() {
        this.jwtSecret = "abcdefghijklmnopqrstuvwxyz0123456789";
    }

    public static Key getSignKey(String secretKey) {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String parseMemberIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignKey(jwtSecret))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("id").toString();
    }
}
