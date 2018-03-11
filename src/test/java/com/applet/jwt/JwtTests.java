package com.applet.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
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
    public void verifyToken() throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret")).build();
        DecodedJWT jwt = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiend6IiwiZXhwIjoxNTIwNzczMDU1LCJpYXQiOjE1MjA3NzMwNTQsImFnZSI6IjE4In0._Tx87avy0-3fejYMf0-oBelaa1o7KdoX4TqVgo1SyVA");

        System.out.println(jwt.getClaims().get("name").asString());
        System.out.println(jwt.getClaim("age").asString());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        System.out.println(format.format(jwt.getIssuedAt().getTime()));
        System.out.println(format.format(jwt.getExpiresAt().getTime()));
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
