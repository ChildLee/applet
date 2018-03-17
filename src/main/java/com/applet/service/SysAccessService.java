package com.applet.service;

import com.applet.entity.SysAccess;

import java.util.List;

public interface SysAccessService {

    Boolean createAccess(SysAccess access);

    Boolean deleteAccess(SysAccess access);

    Boolean updateAccess(SysAccess access);

    List<SysAccess> getAccess();
}
