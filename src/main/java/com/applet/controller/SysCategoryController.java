package com.applet.controller;

import com.applet.dto.CategoryDTO;
import com.applet.entity.SysCategory;
import com.applet.service.SysCategoryService;
import com.applet.utils.FtpUtil;
import com.applet.utils.StringUtil;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SysCategoryController {

    @Autowired
    private SysCategoryService categoryService;

    @PostMapping("category")
    public Result addCategory(CategoryDTO categoryDTO, MultipartFile file[]) {
        if (StringUtil.isNull(categoryDTO.getName())) {
            return ResultUtil.error(10001);
        }
        String imgArr = FtpUtil.fileUpload(file);
        if (StringUtil.isNull(imgArr)) return ResultUtil.error("图片上传失败,请检查图片");
        SysCategory category = new SysCategory();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName().trim());
        category.setLevel((long) 0);
        category.setImage(imgArr);
        return ResultUtil.success(categoryService.addCategory(category));
    }

    @PostMapping("categoryImg")
    public Result editCategoryImg(CategoryDTO categoryDTO, MultipartFile file[]) {
        System.out.println(categoryDTO);
        if (StringUtil.isNull(categoryDTO.getId(), categoryDTO.getImage())) {
            return ResultUtil.error(10001);
        }
        String imgArr = FtpUtil.fileUpload(categoryDTO.getImage(), file);
        if (StringUtil.isNull(imgArr)) return ResultUtil.error("图片上传失败,请检查图片");
        SysCategory category = new SysCategory();
        category.setId(categoryDTO.getId());
        category.setImage(imgArr);
        return ResultUtil.success(categoryService.updateCategoryImg(category));
    }

    @DeleteMapping("category")
    public Result deleteCategory(CategoryDTO categoryDTO) {
        System.out.println(categoryDTO);
        if (StringUtil.isNull(categoryDTO.getId())) {
            return ResultUtil.error(10001);
        }
        SysCategory category = new SysCategory();
        category.setId(categoryDTO.getId());
        if (categoryService.deleteCategory(category)) {
            FtpUtil.fileDelete(categoryDTO.getImage());
        }
        return ResultUtil.success(true);
    }

    @PutMapping("category")
    public Result updateCategory(CategoryDTO categoryDTO) {
        System.out.println(categoryDTO);
        if (StringUtil.isNull(categoryDTO.getId(), categoryDTO.getName())) {
            return ResultUtil.error(10001);
        }
        SysCategory category = new SysCategory();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return ResultUtil.success(categoryService.updateCategory(category));
    }

    @GetMapping("category")
    public Result getCategory(CategoryDTO categoryDTO) {
        if (StringUtil.isNull(categoryDTO.getId())) {
            return ResultUtil.error(10001);
        }
        SysCategory category = new SysCategory();
        category.setId(categoryDTO.getId());
        return ResultUtil.success(categoryService.getCategory(category));
    }
}
