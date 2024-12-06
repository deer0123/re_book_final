package com.re_book.common.auth;

import com.re_book.user.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private int expiration;

    @Value("${jwt.secretKeyRt}")
    private String secretKeyRt;

    @Value("${jwt.expirationRt}")
    private int expirationRt;

    // 토큰 생성 메서드
    public String createToken(String id, String role, String name) {
        Claims claims = Jwts.claims().setSubject(id);
        claims.put("role", role);
        claims.put("name", name); // name 추가
        Date date = new Date();

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(date)
            .setExpiration(new Date(date.getTime() + expiration * 60 * 1000L))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

    public String createRefreshToken(String id, String role,String name) {
        Claims claims = Jwts.claims().setSubject(id);
        claims.put("role", role);
        claims.put("name", name); // name 추가
        Date date = new Date();

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(date)
            .setExpiration(new Date(date.getTime() + expirationRt * 60 * 1000L))
            .signWith(SignatureAlgorithm.HS256, secretKeyRt)
            .compact();
    }

    // 토큰 검증 및 정보 반환 메서드
    public TokenUserInfo validateAndGetTokenUserInfo(String token) throws Exception {
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .getBody();

        log.info("claims : {}", claims);

        return TokenUserInfo.builder()
            .id(claims.getSubject())
            .role(Role.valueOf(claims.get("role", String.class)))
            .name(claims.get("name", String.class)) // name 추가
            .build();
    }
}