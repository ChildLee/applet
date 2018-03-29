package com.applet.service.impl;

import com.applet.entity.SysAdmin;
import com.applet.mapper.LoginMapper;
import com.applet.mapper.SysAdminMapper;
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
    private LoginMapper loginMapper;

    @Autowired
    private SysAdminMapper adminMapper;

    @Override
    public Result login(String username, String password) {
        Map map = null;
        SysAdmin sysAdmin = null;
        try {
            //数据库查密码
            sysAdmin = loginMapper.findByUsername(username);
            System.out.println(sysAdmin);
            //判断账号是否存在
            if (sysAdmin == null) {
                return ResultUtil.error(678);
            }
            //判断账户是否锁定
            else if (!sysAdmin.isEnabled()) {
                return ResultUtil.error(677);
            }
            //判断密码正确性
            else if (password.equals(sysAdmin.getPassword())) {
                map = new HashMap();
                String token = JWT.create()
                        .withClaim("name", username)
                        .withIssuedAt(new Date())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        .sign(Algorithm.HMAC256(secret));

                map.put("token", token);
                map.put("userInfo", sysAdmin);
            } else {
                return ResultUtil.error(678);
            }
        } catch (UnsupportedEncodingException e) {
            log.error("登录生成token时出错,字符编码不受支持");
            return ResultUtil.error(-1);
        }
        adminMapper.updateLoginTime(sysAdmin.getId(), new Date());
        return ResultUtil.success(map);
    }
}
