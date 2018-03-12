package com.applet.controller;

import com.applet.service.LoginService;
import com.applet.utils.StringUtil;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public Result login(String username, String password) {
        if (StringUtil.isNull(username.trim(), password.trim())) {
            return ResultUtil.error(10001);
        }
        return loginService.login(username, password);
    }
}