package com.app.oauth.util;

import io.jsonwebtoken.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtTokenUtil {
    @Value("${jwt.secret}")
    private String secretKey;

    // Access 토큰 생성
    public String generateAccessToken(Map<String, String> claims) {
        String id = claims.get("id");
        String memberEmail = claims.get("memberEmail");

        //평균 1분 ~ 5분
        long expirationTimeInMillis = 1000 * 60 * 60 * 24;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTimeInMillis);

        // JWT를 발급한 곳
        claims.put("issuer", "a class");

        return Jwts
                .builder()
                .claims(claims) // 클레임 추가
                .expiration(expirationDate) // 시간
                .signWith(SignatureAlgorithm.HS256, secretKey)  // sha-256 알고리즘
                .setHeaderParam("typ", "JWT") // 타입 JWT
                .compact();
    }

    // Refresh 토큰 생성
    public String generateRefreshToken(Map<String, String> claims) {
        String id = claims.get("id");
        String memberEmail = claims.get("memberEmail");

        //평균 1주일 ~ 한 달
        long expirationTimeInMillis = 1000 * 60 * 60 * 24 * 30;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTimeInMillis);

        // JWT를 발급한 곳
        claims.put("issuer", "a class");

        return Jwts
                .builder()
                .claims(claims) // 클레임 추가
                .expiration(expirationDate) // 시간
                .signWith(SignatureAlgorithm.HS256, secretKey)  // sha-256 알고리즘
                .setHeaderParam("typ", "JWT") // 타입 JWT
                .compact();
    }

    // 토큰 파싱(data => claim)
    public Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("만료시간 초과 오류");
        } catch (UnsupportedJwtException e) {
            throw new RuntimeException("JWT type이 오류");
        } catch (MalformedJwtException e) {
            throw new RuntimeException("token 정보 오류");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("claim 오류");
        }
    }

    // 토큰 유효성 검사

    public Map<String, Object> validateToken(String token) {
        Map<String, Object> result = new HashMap<>();
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            result.put("success", true);
            result.put("message", "토큰 파싱 완료");
            return result;

        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
            return result;
        }
    }
}
