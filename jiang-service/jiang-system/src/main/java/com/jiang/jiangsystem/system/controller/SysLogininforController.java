package com.jiang.jiangsystem.system.controller;

import com.jiang.commoncore.core.controller.BaseController;
import com.jiang.jiangsystem.system.service.SysLogininforService;
import com.jiang.system.domain.SysLogininfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysLogininforController
 * @Description: 系统访问记录
 * @Author jiang
 * @Date 2020/8/6 21:48
 **/
@RestController
@RequestMapping("logininfor")
public class SysLogininforController extends BaseController {
    @Autowired
    SysLogininforService sysLogininforService;

    /**
     * 新增保存系统访问记录
     */
    @PostMapping("save")
    public void addSave(@RequestBody SysLogininfor sysLogininfor) {
        sysLogininforService.insertLogininfor(sysLogininfor);
    }
}
