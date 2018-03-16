package com.applet.service;

import com.applet.entity.SysAccess;

import java.util.List;

public interface AdminService {
    List<SysAccess> getAccess();

    Boolean createAccess(SysAccess access);

    Boolean deleteAccess(SysAccess access);
}
