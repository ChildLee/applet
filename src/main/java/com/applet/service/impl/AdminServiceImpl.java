package com.applet.service.impl;

import com.applet.entity.SysAccess;
import com.applet.mapper.AdminMapper;
import com.applet.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<SysAccess> getAccess() {
        return adminMapper.getAccess();
    }

    @Override
    public Boolean createAccess(SysAccess access) {
        return adminMapper.createAccess(access);
    }

    @Override
    public Boolean deleteAccess(SysAccess access) {
        return adminMapper.deleteAccess(access);
    }
}
