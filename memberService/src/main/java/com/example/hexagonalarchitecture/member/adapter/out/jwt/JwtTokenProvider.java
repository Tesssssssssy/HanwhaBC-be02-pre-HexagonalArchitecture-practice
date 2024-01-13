package com.example.hexagonalarchitecture.member.adapter.out.jwt;

import com.example.hexagonalarchitecture.member.application.port.out.LoginMemberPort;
import com.example.hexagonalarchitecture.member.domain.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider implements LoginMemberPort {
    private String jwtSecret;
    private Long accessTokenExpirationMs;
    private Long refreshTokenExpirationMs;

    public JwtTokenProvider() {
        this.jwtSecret = "abcdefghijklmnopqrstuvwxyz0123456789";
        this.accessTokenExpirationMs = 1000L * 30 * 5;
        this.refreshTokenExpirationMs = 1000L * 60 * 60;
    }
    public static Key getSignKey(String secretKey) {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    @Override
    public String generateAccessToken(Member member) {
        Claims claims = Jwts.claims();
        claims.put("id", member.getId());
        claims.put("email",member.getEmail());
        claims.put("nickname", member.getNickname());

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpirationMs))
                .signWith(getSignKey(jwtSecret), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }


    @Override
    public String generateRefreshToken(Member member) {
        Claims claims = Jwts.claims();
        claims.put("id", member.getId());
        claims.put("email",member.getEmail());
        claims.put("nickname", member.getNickname());
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpirationMs))
                .signWith(getSignKey(jwtSecret), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignKey(jwtSecret))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String parseMemberIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignKey(jwtSecret))
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
