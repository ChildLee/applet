package com.applet.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JwtUtil {
    /**
     *
     * @param name 用户名
     * @return
     */
    public static String createToken(String name) {
        String token = null;
        try {
            token = JWT.create()
                    .withClaim("name", name)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 1000))
                    .sign(Algorithm.HMAC256("secret"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token;
    }

    public void verifyToken() throws UnsupportedEncodingException {
        JWTVerifier verifier = null;
        DecodedJWT jwt = null;
        verifier = JWT.require(Algorithm.HMAC256("secret")).build();
        jwt = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiend6IiwiZXhwIjoxNTIxMDkxODk3LCJpYXQiOjE1MjA0ODcwOTcsImFnZSI6IjE4In0.4i3JjMZTcWVOalQd_Gbe7uj6cCQYmNQWg2N4OcUezXM");

        System.out.println(jwt.getClaims().get("name").asString());
        System.out.println(jwt.getClaim("age").asString());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        System.out.println(format.format(jwt.getIssuedAt().getTime()));
        System.out.println(format.format(jwt.getExpiresAt().getTime()));
    }
}
