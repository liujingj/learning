package com.ljj.malllearning.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ljj
 * @date 2020/9/27
 */
@Component
public class JwtTokenUtil {

    private String secret = "";
    private Long expiration = Long.valueOf(24 * 60 * 60);

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 根据token获取用户名
     *
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * 校验token
     *
     * @param token
     * @param userName
     * @return
     */
    public boolean validateToken(String token, String userName) {
        String user = getUserNameFromToken(token);
        return user.equals(userName) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return new Date().before(getExpiredDateFromToken(token));
    }

    private Date getExpiredDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    /**
     * 根据用户名生成token
     *
     * @param userName
     * @return
     */
    public String generateToken(String userName) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("create", new Date());
        return generateToken(map);
    }

    /**
     * token是否可以刷新
     *
     * @param token
     * @return
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put("create", new Date());
        return generateToken(claims);
    }
}
