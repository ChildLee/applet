package com.applet.mapper;

import com.applet.entity.SysAccess;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    List<SysAccess> getAccess();

    Boolean createAccess(SysAccess access);

    Boolean deleteAccess(SysAccess access);
}
