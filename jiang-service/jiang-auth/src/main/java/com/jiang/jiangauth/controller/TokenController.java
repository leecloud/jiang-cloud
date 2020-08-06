package com.jiang.jiangauth.controller;

import com.jiang.commoncore.core.domain.Result;
import com.jiang.jiangauth.form.LoginForm;
import com.jiang.jiangauth.service.AccessTokenService;
import com.jiang.jiangauth.service.SysLoginService;
import com.jiang.system.domain.SysUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenController
 * @Description: 登录
 * @Author jiang
 * @Date 2020/8/6 16:55
 **/
@RestController
public class TokenController {
    @Resource
    AccessTokenService accessTokenService;
    @Resource
    SysLoginService sysLoginService;

    @PostMapping("login")
    public Result login(@RequestBody LoginForm form) {
        // 用户登录
        SysUser user = sysLoginService.login(form.getUsername(), form.getPassword());
        // 获取登录token
        return Result.ok(accessTokenService.createToken(user));
    }

    @PostMapping("logout")
    public Result logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        SysUser user = accessTokenService.queryToken(token);
        if (null != user) {
            sysLoginService.logout(user.getLoginName());
            accessTokenService.expireToken(user.getUserId());
        }
        return Result.ok();
    }
}
