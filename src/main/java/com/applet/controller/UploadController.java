package com.applet.controller;

import com.applet.dto.CategoryDTO;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class UploadController {
    @PostMapping("uploadImg")
    public Result uploadImg(MultipartFile file[], CategoryDTO categoryDTO) {
        System.out.println(categoryDTO);
        for (MultipartFile f : file) {
            System.out.println(f.getOriginalFilename());
        }
        return ResultUtil.success("1");
    }
}
