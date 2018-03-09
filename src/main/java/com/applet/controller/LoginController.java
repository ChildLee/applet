package com.applet.controller;

import com.applet.utils.JwtUtil;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("login")
    public Result login(String username, String password) {
        Map map = new HashMap();
        if (username.trim().equals("sa") && password.trim().equals("sa")) {
            map.put("token", JwtUtil.createToken(username));
            return ResultUtil.success(map);
        }
        return ResultUtil.error(0);
    }

    @GetMapping("a")
    public Result a(String a) {
        System.out.println(a);
        return ResultUtil.success("ok");
    }
}