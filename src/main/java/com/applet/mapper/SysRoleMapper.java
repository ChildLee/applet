package com.applet.mapper;

import com.applet.entity.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper {

    Boolean createRole(SysRole role);

    Boolean deleteRole(SysRole role);

    Boolean updateRole(SysRole role);

    List<SysRole> getRole();

    SysRole getRoleAccesses(SysRole role);
}
