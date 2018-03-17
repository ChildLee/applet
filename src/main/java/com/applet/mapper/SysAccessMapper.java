package com.applet.mapper;

import com.applet.entity.SysAccess;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysAccessMapper {

    Boolean createAccess(SysAccess access);

    Boolean deleteAccess(SysAccess access);

    Boolean updateAccess(SysAccess access);

    List<SysAccess> getAccess();
}
