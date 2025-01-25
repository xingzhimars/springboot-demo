package com.mars.springboot.demo.common.utils;

import com.mars.springboot.demo.dto.UserToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by geyan on 2025/1/25 18:58
 */
@Slf4j
@Component
public class JwtUtil {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    // 密钥（至少 256 位）
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Value("${jwt.expire}")
    private Long expire;

    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;


    public String generateToken(UserToken userToken) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userToken.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());

        log.info("claims : {}", claims);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .signWith(SECRET_KEY)
                .compact();
    }
}

