package com.applet.controller;

import com.applet.entity.SysAccess;
import com.applet.service.SysAccessService;
import com.applet.utils.StringUtil;
import com.applet.utils.result.Result;
import com.applet.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysAccessController {

    @Autowired
    private SysAccessService sysAccessService;

    @PostMapping("access")
    public Result createAccess(SysAccess access) {
        if (StringUtil.isNull(access.getName(), access.getName())) {
            return ResultUtil.error(10001);
        }
        return sysAccessService.createAccess(access) ? ResultUtil.success(access) : null;
    }

    @DeleteMapping("access")
    public Result deleteAccess(SysAccess access) {
        if (StringUtil.isNull(access.getId())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(sysAccessService.deleteAccess(access));
    }

    @PutMapping("access")
    public Result updateAccess(SysAccess access) {
        if (StringUtil.isNull(access.getId(), access.getName(), access.getPath())) {
            return ResultUtil.error(10001);
        }
        return ResultUtil.success(sysAccessService.updateAccess(access));
    }

    @GetMapping("access")
    public Result getAccess() {
        return ResultUtil.success(sysAccessService.getAccess());
    }
}
