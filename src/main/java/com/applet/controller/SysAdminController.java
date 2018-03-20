package com.applet.controller;

import com.applet.entity.SysAdmin;
import com.applet.entity.SysRole;
import com.applet.service.SysAdminService;
import com.applet.utils.StringUtil;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class SysAdminController {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private SysAdminService sysAdminService;

    @PostMapping("admin")
    public Result createAdmin(SysAdmin admin) {
        if (StringUtil.isNull(admin.getUsername(), admin.getPassword())) {
            return ResultUtil.error(10001);
        }
        admin.setEnabled(true);
        return sysAdminService.createAdmin(admin) ? ResultUtil.success(admin) : ResultUtil.error("用户名已存在");
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

    @PostMapping("adminRoles")
    public Result createAdminRoles(Long id, String params) {
        if (StringUtil.isNull(id, params)) {
            return ResultUtil.error(10001);
        }
        SysAdmin admin = null;
        try {
            List<SysRole> roles = mapper.readValue(params, new TypeReference<List<SysRole>>() {
            });
            admin = new SysAdmin();
            admin.setId(id);
            admin.setRoles(roles);
        } catch (IOException e) {
            System.out.println("权限解析错误");
        }
        Boolean bool = sysAdminService.createAdminRole(admin);
        return ResultUtil.success(bool);
    }

    @GetMapping("adminRoles")
    public Result getAdminRoles(SysAdmin admin) {
        if (StringUtil.isNull(admin.getId())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(sysAdminService.getAdminRole(admin));
    }
}
