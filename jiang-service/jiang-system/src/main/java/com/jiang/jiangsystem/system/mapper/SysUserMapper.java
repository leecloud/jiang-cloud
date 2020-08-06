package com.jiang.jiangsystem.system.mapper;

import com.jiang.system.domain.SysUser;

/**
 * @ClassName SysUserMapper
 * @Description: 用户持久层接口
 * @Author jiang
 * @Date 2020/8/6 16:32
 **/
public interface SysUserMapper {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    SysUser selectUserByLoginName(String username);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(SysUser user);
}
