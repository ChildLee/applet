package com.applet.mapper;

import com.applet.entity.SysAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    SysAdmin findAllUser();
}
