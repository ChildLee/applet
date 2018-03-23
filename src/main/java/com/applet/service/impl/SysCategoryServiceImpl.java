package com.applet.service.impl;

import com.applet.entity.SysCategory;
import com.applet.mapper.SysCategoryMapper;
import com.applet.service.SysCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCategoryServiceImpl implements SysCategoryService {

    @Autowired
    private SysCategoryMapper categoryMapper;

    @Override
    public Boolean addCategory(SysCategory category) {
        return categoryMapper.addCategory(category);
    }

    @Override
    public List<SysCategory> getCategory(SysCategory category) {
        return categoryMapper.getCategory(category);
    }
}
