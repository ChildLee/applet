package com.applet.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

//    @PostMapping("login")
//    public void login(HttpServletResponse response, String username, String password) {
//        System.out.println(username);
//        System.out.println(password);
//        if (username.trim().equals("sa") && password.trim().equals("sa")) {
//            Cookie cookie = new Cookie("token", JwtUtil.createToken(username));
//            cookie.setMaxAge(30 * 60);// 设置为30min
//            cookie.setPath("/");
//            response.addCookie(cookie);
//        }
//    }

    @PostMapping("a")
    public String a(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return "aaa111";
    }
}
