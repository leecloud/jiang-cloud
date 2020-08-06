package com.jiang.jiangsystem.system.service.impl;

import com.jiang.jiangsystem.system.mapper.SysUserMapper;
import com.jiang.jiangsystem.system.service.SysUserService;
import com.jiang.system.domain.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName SysUserServiceImpl
 * @Description: 用户
 * @Author jiang
 * @Date 2020/8/6 22:55
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    SysUserMapper sysUserMapper;
    @Override
    public SysUser selectUserByLoginName(String username) {
        return sysUserMapper.selectUserByLoginName(username);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(SysUser user) {
//        Long userId = user.getUserId();
        // 删除用户与角色关联
//        userRoleMapper.deleteUserRoleByUserId(userId);
        // 新增用户与角色管理
//        insertUserRole(user);
        // 删除用户与岗位关联
//        userPostMapper.deleteUserPostByUserId(userId);
        // 新增用户与岗位管理
//        insertUserPost(user);
        return sysUserMapper.updateUser(user);
    }
}
