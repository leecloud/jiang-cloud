package com.jiang.jiangsystem.system.service;

import com.jiang.system.domain.SysUser;

/**
 * @ClassName SysUserService
 * @Description: 用户
 * @Author jiang
 * @Date 2020/8/6 22:55
 **/
public interface SysUserService {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    SysUser selectUserByLoginName(String username);

    /**
     * 更新登录信息
     * @param sysUser
     * @return
     */
    int updateUser(SysUser sysUser);
}
