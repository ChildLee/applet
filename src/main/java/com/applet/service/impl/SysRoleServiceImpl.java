package com.applet.service.impl;

import com.applet.entity.SysRole;
import com.applet.mapper.SysRoleMapper;
import com.applet.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Transactional
    @Override
    public Boolean createRole(SysRole role) {
        Boolean existsRole = sysRoleMapper.isExistsRole(role);
        return existsRole ? false : sysRoleMapper.createRole(role);
    }

    @Transactional
    @Override
    public Boolean deleteRole(SysRole role) {
        return sysRoleMapper.deleteRole(role);
    }

    @Transactional
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

    @Transactional
    @Override
    public Boolean createRoleAccesses(SysRole role) {
        Boolean bool = sysRoleMapper.deleteRoleAccesses(role);
        if (role.getAccesses().size() > 0) {
            bool = sysRoleMapper.createRoleAccesses(role);
        }
        return bool;
    }
}
