package com.mx.Usuarios.config;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class JwtUtil {

    private final String SECRET_KEY =
            "miclavesecretamiclavesecretamiclavesecreta";

    private Key getKey() {
        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );
    }

    public String generarToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60
                        )
                )
                .signWith(getKey())
                .compact();
    }

    public String extraerUsername(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}