package com.applet.mapper;

import com.applet.entity.SysAdmin;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SysAdminMapper {

    Boolean createAdmin(SysAdmin admin);

    Boolean deleteAdmin(SysAdmin admin);

    Boolean updateAdmin(SysAdmin admin);

    Boolean updateAdminStatus(SysAdmin admin);

    Boolean isExistsUsername(SysAdmin admin);

    Boolean updateLoginTime(Long id, Date date);

    List<SysAdmin> getAdmin();

    SysAdmin getAdminRoles(SysAdmin admin);

    Boolean deleteAdminRoles(SysAdmin admin);

    Boolean createAdminRoles(SysAdmin admin);
}
