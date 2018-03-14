package com.applet.service.impl;

import com.applet.entity.SysAdmin;
import com.applet.mapper.AdminMapper;
import com.applet.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public SysAdmin findAllUser() {
        return adminMapper.findAllUser();
    }
}
