package com.applet.service;

import com.applet.entity.SysCategory;

import java.util.List;

public interface SysCategoryService {
    Boolean addCategory(SysCategory category);

    List<SysCategory> getCategory(SysCategory category);
}
