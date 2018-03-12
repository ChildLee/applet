package com.applet.service.impl;

import com.applet.service.LoginService;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Value("${application.token.secret}")
    private String secret;

    @Override
    public Result login(String username, String password) {
        System.out.println(secret);
        Map map = null;
        //数据库查
        String pwd = "sa";
        try {
            if (password.equals(pwd)) {
                map = new HashMap();
                String token = JWT.create()
                        .withClaim("name", username)
                        .withIssuedAt(new Date())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        .sign(Algorithm.HMAC256(secret));
                map.put("token", token);
            } else {
                return ResultUtil.error(678);
            }
        } catch (UnsupportedEncodingException e) {
            log.error("登录生成token时出错,字符编码不受支持");
        }
        return ResultUtil.success(map);
    }
}
