package com.applet.controller;

import com.applet.entity.SysRole;
import com.applet.service.SysRoleService;
import com.applet.utils.StringUtil;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class SysRoleController {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("role")
    public Result createRole(SysRole role) {
        if (StringUtil.isNull(role.getName(), role.getName())) {
            return ResultUtil.error(10001);
        }
        return sysRoleService.createRole(role) ? ResultUtil.success(role) : null;
    }

    @DeleteMapping("role")
    public Result deleteRole(SysRole role) {
        if (StringUtil.isNull(role.getId())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(sysRoleService.deleteRole(role));
    }

    @PutMapping("role")
    public Result updateRole(SysRole role) {
        if (StringUtil.isNull(role.getId(), role.getName())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(sysRoleService.updateRole(role));
    }

    @GetMapping("role")
    public Result getRole() {
        return ResultUtil.success(sysRoleService.getRole());
    }

    @PostMapping("roleAccesses")
    public Result createRoleAccesses(Integer id, String access) {
        System.out.println(access);
        if (StringUtil.isNull(id, access)) {
            return ResultUtil.error(10001);
        }
        try {
            List jsonList = mapper.readValue(access, List.class);
            System.out.println(jsonList);
        } catch (IOException e) {
            System.out.println("权限数组解析错误");
        }


        return null;
    }

    @GetMapping("roleAccesses")
    public Result getRoleAccesses(SysRole role) {
        if (StringUtil.isNull(role.getId())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(sysRoleService.getRoleAccesses(role));
    }
}
