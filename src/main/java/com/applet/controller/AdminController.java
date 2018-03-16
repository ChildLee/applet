package com.applet.controller;

import com.applet.entity.SysAccess;
import com.applet.service.AdminService;
import com.applet.utils.StringUtil;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("access")
    public Result getAccess() {
        return ResultUtil.success(adminService.getAccess());
    }

    @PostMapping("access")
    public Result createAccess(SysAccess access) {
        if (StringUtil.isNull(access.getName().trim(), access.getName().trim())) {
            return ResultUtil.error(10001);
        }
        return adminService.createAccess(access) ? ResultUtil.success(access) : null;
    }

    @DeleteMapping("access")
    public Result deleteAccess(SysAccess access) {
        if (StringUtil.isNull(access.getId())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(adminService.deleteAccess(access));
    }
}
