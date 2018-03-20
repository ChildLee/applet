package com.applet.controller;

import com.applet.entity.SysAccess;
import com.applet.entity.SysRole;
import com.applet.service.SysRoleService;
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
public class SysRoleController {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("role")
    public Result createRole(SysRole role) {
        if (StringUtil.isNull(role.getName(), role.getName())) {
            return ResultUtil.error(10001);
        }
        return sysRoleService.createRole(role) ? ResultUtil.success(role) : ResultUtil.error("角色已存在");
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
    public Result createRoleAccesses(Long id, String params) {
        if (StringUtil.isNull(id, params)) {
            return ResultUtil.error(10001);
        }
        SysRole role = null;
        try {
            List<SysAccess> accesses = mapper.readValue(params, new TypeReference<List<SysAccess>>() {
            });
            role = new SysRole();
            role.setId(id);
            role.setAccesses(accesses);
        } catch (IOException e) {
            System.out.println("权限解析错误");
        }
        Boolean bool = sysRoleService.createRoleAccesses(role);
        return ResultUtil.success(bool);
    }

    @GetMapping("roleAccesses")
    public Result getRoleAccesses(SysRole role) {
        if (StringUtil.isNull(role.getId())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(sysRoleService.getRoleAccesses(role));
    }
}
