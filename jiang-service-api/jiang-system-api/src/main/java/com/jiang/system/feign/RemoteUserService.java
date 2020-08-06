package com.jiang.system.feign;

import com.jiang.commoncore.core.constant.ServiceNameConstants;
import com.jiang.commoncore.core.domain.Result;
import com.jiang.system.domain.SysUser;
import com.jiang.system.feign.factory.RemoteUserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName RemoteUserService
 * @Description: 用户feign服务层
 * @Author jiang
 * @Date 2020/8/6 16:12
 **/
@FeignClient(name = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    @GetMapping("user/find/{username}")
    SysUser selectSysUserByUsername(@PathVariable("username") String username);

    /**
     * 记录登录信息
     * @param user
     * @return
     */
    @PostMapping("user/update/login")
    Result updateUserLoginRecord(@RequestBody SysUser user);
}
