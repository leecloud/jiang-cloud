package com.jiang.jiangsystem.system.controller;

import com.jiang.commoncore.core.controller.BaseController;
import com.jiang.commoncore.core.domain.Result;
import com.jiang.jiangsystem.system.service.SysUserService;
import com.jiang.system.domain.SysUser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName SysUserController
 * @Description: 用户
 * @Author jiang
 * @Date 2020/8/6 22:54
 **/
@RestController
@RequestMapping("user")
public class SysUserController extends BaseController {
    @Resource
    SysUserService sysUserService;

    /**
     * 查询用户
     */
    @GetMapping("find/{username}")
    public SysUser findByUsername(@PathVariable("username") String username) {
        return sysUserService.selectUserByLoginName(username);
    }

    /**
     * 记录登陆信息
     *
     * @param sysUser
     * @return
     */
    @PostMapping("update/login")
    public Result updateLoginRecord(@RequestBody SysUser sysUser) {
        return toAjax(sysUserService.updateUser(sysUser));
    }
}
