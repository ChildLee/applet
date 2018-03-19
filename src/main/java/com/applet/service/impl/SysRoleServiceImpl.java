package com.applet.service.impl;

import com.applet.entity.SysRole;
import com.applet.mapper.SysRoleMapper;
import com.applet.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Boolean createRole(SysRole role) {
        return sysRoleMapper.createRole(role);
    }

    @Override
    public Boolean deleteRole(SysRole role) {
        return sysRoleMapper.deleteRole(role);
    }

    @Override
    public Boolean updateRole(SysRole role) {
        return sysRoleMapper.updateRole(role);
    }

    @Override
    public List<SysRole> getRole() {
        return sysRoleMapper.getRole();
    }

    @Override
    public SysRole getRoleAccesses(SysRole role) {
        return sysRoleMapper.getRoleAccesses(role);
    }
}
