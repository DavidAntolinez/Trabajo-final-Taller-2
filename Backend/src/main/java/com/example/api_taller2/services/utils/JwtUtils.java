package com.example.api_taller2.services.utils;

import com.example.api_taller2.Models.Entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtUtils {
    private static final String secret = "meduermoHIJUEPUTAAAAAAAAAcomemelaspelotasspringsecuritymamahuevo";

    public static String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public static <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public static Claims extractAllClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getBody();
        }catch (SignatureException ex) {
            throw new JwtException("Invalid JWT signature");
        }


    }

    public static Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    private static boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public static String generateToken(String username,String password) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("password", password);
        return createToken(claims,username);
    }

    private static String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+100*60*60*10))
                .signWith(SignatureAlgorithm.HS256,secret).compact();

    }

    public static boolean validateToken(String token, Usuario user) {
        final String username2 = extractUsername(token);
        return (username2.equals(user.getUsername()) && !isTokenExpired(token));
    }

    public static boolean validateTokenMap(Map<String, String> requestMap) {
        return requestMap.containsKey("token");
    }

    public static boolean validateIdMap(Map<String, String> requestMap) {
        return requestMap.containsKey("id");
    }
}
