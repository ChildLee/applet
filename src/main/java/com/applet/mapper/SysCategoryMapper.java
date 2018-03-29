package com.applet.mapper;

import com.applet.entity.SysCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysCategoryMapper {
    Boolean addCategory(SysCategory category);

    Boolean deleteCategory(SysCategory category);

    Boolean updateCategory(SysCategory category);

    Boolean updateCategoryImg(SysCategory category);

    List<SysCategory> getCategory(SysCategory category);
}
