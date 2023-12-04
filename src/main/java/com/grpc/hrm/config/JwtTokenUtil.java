package com.grpc.hrm.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenUtil {

    SecretKey key = Jwts.SIG.HS512.key().build();

    //    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(key)
                .compact();
    }

    public Claims extractAllClaims(String token) throws SignatureException {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    String extractUsername(String token) throws SignatureException {
        return extractAllClaims(token).getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) throws SignatureException {
        return userDetails.getUsername().equals(extractUsername(token));
    }

    public boolean isTokenExpired(String token) throws SignatureException {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
