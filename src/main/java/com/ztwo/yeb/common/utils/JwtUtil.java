package com.ztwo.yeb.common.utils;

import io.jsonwebtoken.*;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Jwt工具类
 *
 * @Author ZTwo
 * @Date 2021/9/11 10:07
 */
@Component
public class JwtUtil {

    //载荷创建时间
    private static final String CLAIM_KEY_CREATED = "created";
    //载荷claim的名称
    private static final String CLAIM_KEY_USERNAME = "sub";
    //jwt加密方式
    private final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
    //jwt令牌的秘钥
    @Value("${jwt.secret}")
    private String secret;
    //jwt的实效时间
    @Value("${jwt.expiration}")
    private Long access_token_expiration;
    //jwt的刷新时间
    @Value("${jwt.expiration}")
    private Long refresh_token_expiration;

    /**
     * 生成token
     *
     * @param userDetails
     * @return [org.springframework.security.core.userdetails.UserDetails]
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 根据token获取usernamne
     *
     * @param token
     * @return [java.lang.String]
     */
    public String generateUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = generateClaimFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 判断token是否有效
     * 1.token中的username与userdetails的username一致
     * 2.token在有效期内
     *
     * @param token
     * @param userDetails
     * @return [java.lang.String, org.springframework.security.core.userdetails.UserDetails]
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = generateUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否可以刷新
     *
     * @param token
     * @return [java.lang.String]
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     *
     * @param token
     * @return [java.lang.String]
     */
    public String refreshToken(String token) {
        Claims claims = generateClaimFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 判断token是否实效
     *
     * @param token
     * @return [java.lang.String]
     */
    private boolean isTokenExpired(String token) {
        return generateClaimFromToken(token).getExpiration().before(new Date());
    }

    /**
     * 根据token获取claims
     *
     * @param token
     * @return [java.lang.String]
     */
    private Claims generateClaimFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 根据载荷生成JwtToken
     *
     * @param claims
     * @return [java.util.Map<java.lang.String,java.lang.Object>]
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALGORITHM, secret)
                .compact();
    }

    /**
     * 生成token实效时间
     *
     * @param
     * @return []
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + access_token_expiration*1000);
    }
}
