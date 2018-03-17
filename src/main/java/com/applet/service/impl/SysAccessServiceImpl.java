package com.applet.service.impl;

import com.applet.entity.SysAccess;
import com.applet.mapper.SysAccessMapper;
import com.applet.service.SysAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysAccessServiceImpl implements SysAccessService {

    @Autowired
    private SysAccessMapper sysAccessMapper;


    @Override
    public Boolean createAccess(SysAccess access) {
        return sysAccessMapper.createAccess(access);
    }

    @Override
    public Boolean deleteAccess(SysAccess access) {
        return sysAccessMapper.deleteAccess(access);
    }

    @Override
    public Boolean updateAccess(SysAccess access) {
        return sysAccessMapper.updateAccess(access);
    }

    @Override
    public List<SysAccess> getAccess() {
        return sysAccessMapper.getAccess();
    }
}
