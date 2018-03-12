package com.applet.service.impl;

import com.applet.entity.SysAdmin;
import com.applet.repository.LoginRepository;
import com.applet.service.LoginService;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Result login(String username, String password) {
        Map map = null;
        try {
            SysAdmin sysAdmin = loginRepository.findByUsername(username);
            String pwd = sysAdmin.getPassword();
            if (!sysAdmin.isEnabled()) {
                return ResultUtil.error(999);
            } else if (password.equals(pwd)) {
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
