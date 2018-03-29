package com.applet.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public class JwtTests {
    /**
     * 创建JWT
     */
    @Test
    public void createToken() throws UnsupportedEncodingException {
        String token = JWT.create()
                .withClaim("name", "zwz")
                .withClaim("age", "18")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000))
                .sign(Algorithm.HMAC256("secret"));
        System.out.println(token);
    }

    /**
     * 验证JWT
     */
    @Test
    public void verifyToken() {
        DecodedJWT jwt = null;
        try {
            jwt = JWT.require(Algorithm.HMAC256("secret")).build().verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiend6IiwiZXhwIjoxNTIwNzczMDU1LCJpYXQiOjE1MjA3NzMwNTQsImFnZSI6IjE4In0._Tx87avy0-3fejYMf0-oBelaa1o7KdoX4TqVgo1SyVA");
        } catch (JWTVerificationException | UnsupportedEncodingException e) {
            System.out.println("验证出错");
        }
//        System.out.println(jwt.getClaims().get("name").asString());
//        System.out.println(jwt.getClaim("age").asString());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
//        System.out.println(format.format(jwt.getIssuedAt().getTime()));
//        System.out.println(format.format(jwt.getExpiresAt().getTime()));
    }

    /**
     * 解码JWT
     */
    @Test
    public void decodeToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiend6IiwiZXhwIjoxNTIwNzczMDU1LCJpYXQiOjE1MjA3NzMwNTQsImFnZSI6IjE4In0._Tx87avy0-3fejYMf0-oBelaa1o7KdoX4TqVgo1SyVA";
        DecodedJWT jwt = JWT.decode(token);
        Map<String, Claim> claims = jwt.getClaims();
        Claim claim = claims.get("name");
        System.out.println(claim.asString());
    }
}
