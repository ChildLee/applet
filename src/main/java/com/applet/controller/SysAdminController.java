package com.applet.controller;

import com.applet.entity.SysAdmin;
import com.applet.service.SysAdminService;
import com.applet.utils.StringUtil;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysAdminController {

    @Autowired
    private SysAdminService sysAdminService;

    @PostMapping("admin")
    public Result createAdmin(SysAdmin admin) {
        if (StringUtil.isNull(admin.getUsername(), admin.getPassword())) {
            return ResultUtil.error(10001);
        }
        admin.setEnabled(true);
        return sysAdminService.createAdmin(admin) ? ResultUtil.success(admin) : null;
    }

    @DeleteMapping("admin")
    public Result deleteAdmin(SysAdmin admin) {
        if (StringUtil.isNull(admin.getId())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(sysAdminService.deleteAdmin(admin));
    }

    @PutMapping("admin")
    public Result updateAdmin(SysAdmin admin) {
        if (StringUtil.isNull(admin.getId(), admin.getUsername(), admin.getPassword())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(sysAdminService.updateAdmin(admin));
    }

    @GetMapping("admin")
    public Result getAdmin() {
        return ResultUtil.success(sysAdminService.getAdmin());
    }
}
