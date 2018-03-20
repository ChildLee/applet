package com.applet.mapper;

import com.applet.entity.SysAdmin;
import com.applet.entity.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysAdminMapper {

    Boolean createAdmin(SysAdmin admin);

    Boolean deleteAdmin(SysAdmin admin);

    Boolean updateAdmin(SysAdmin admin);

    List<SysAdmin> getAdmin();

    SysRole getAdminRoles(SysAdmin admin);

    Boolean deleteAdminRoles(SysAdmin admin);

    Boolean createAdminRoles(SysAdmin admin);
}
