package com.applet.service.impl;

import com.applet.entity.SysAdmin;
import com.applet.mapper.SysAdminMapper;
import com.applet.service.SysAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysAdminServiceImpl implements SysAdminService {

    @Autowired
    private SysAdminMapper sysAdminMapper;

    @Transactional
    @Override
    public Boolean createAdmin(SysAdmin admin) {
        return sysAdminMapper.createAdmin(admin);
    }

    @Transactional
    @Override
    public Boolean deleteAdmin(SysAdmin admin) {
        return sysAdminMapper.deleteAdmin(admin);
    }

    @Transactional
    @Override
    public Boolean updateAdmin(SysAdmin admin) {
        return sysAdminMapper.updateAdmin(admin);
    }

    @Override
    public List<SysAdmin> getAdmin() {
        return sysAdminMapper.getAdmin();
    }
}
