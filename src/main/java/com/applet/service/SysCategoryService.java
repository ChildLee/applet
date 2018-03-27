package com.applet.service;

import com.applet.entity.SysCategory;

import java.util.List;

public interface SysCategoryService {
    Boolean addCategory(SysCategory category);

    Boolean deleteCategory(SysCategory category);

    Boolean updateCategory(SysCategory category);

    Boolean updateCategoryImg(SysCategory category);

    List<SysCategory> getCategory(SysCategory category);
}
