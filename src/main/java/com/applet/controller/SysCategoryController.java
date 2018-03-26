package com.applet.controller;

import com.applet.dto.CategoryDTO;
import com.applet.entity.SysCategory;
import com.applet.service.SysCategoryService;
import com.applet.utils.StringUtil;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SysCategoryController {

    @Autowired
    private SysCategoryService categoryService;

    @PostMapping("category")
    public Result addCategory(CategoryDTO categoryDTO, MultipartFile file[]) {
        System.out.println(categoryDTO);
        for (MultipartFile f : file) {
            System.out.println(f.getOriginalFilename());
        }
        return ResultUtil.success("666");
//        if (StringUtil.isNull(categoryDTO.getName())) {
//            return ResultUtil.error(10001);
//        }
//        SysCategory category = new SysCategory();
//        category.setId(categoryDTO.getId());
//        category.setName(categoryDTO.getName().trim());
//        category.setLevel((long) 0);
//        return ResultUtil.success(categoryService.addCategory(category));
    }

    @GetMapping("category")
    public Result getCategory(CategoryDTO categoryDTO) {
        System.out.println(categoryDTO);
        if (StringUtil.isNull(categoryDTO.getId())) {
            return ResultUtil.error(10001);
        }
        SysCategory category = new SysCategory();
        category.setId(categoryDTO.getId());
        return ResultUtil.success(categoryService.getCategory(category));
    }
}
