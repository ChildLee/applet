package com.applet.service;

import com.applet.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    Boolean createRole(SysRole role);

    Boolean deleteRole(SysRole role);

    Boolean updateRole(SysRole role);

    List<SysRole> getRole();

    SysRole getRoleAccesses(SysRole role);
}
