package com.applet.controller;

import com.applet.service.AdminService;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("findAllUser")
    public Result findAllUser() {
        return ResultUtil.success(adminService.findAllUser());
    }
}
