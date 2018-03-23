package com.applet.service;

import com.applet.entity.SysAdmin;

import java.util.Date;
import java.util.List;

public interface SysAdminService {

    Boolean createAdmin(SysAdmin admin);

    Boolean deleteAdmin(SysAdmin admin);

    Boolean updateAdmin(SysAdmin admin);

    Boolean updateAdminStatus(SysAdmin admin);

    Boolean updateLoginTime(Long id, Date date);

    List<SysAdmin> getAdmin();

    SysAdmin getAdminRole(SysAdmin admin);

    Boolean createAdminRole(SysAdmin admin);
}
