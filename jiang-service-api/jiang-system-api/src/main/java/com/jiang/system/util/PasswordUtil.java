package com.jiang.system.util;

import com.jiang.commoncore.core.util.Md5Utils;
import com.jiang.system.domain.SysUser;

/**
 * @ClassName PasswordUtil
 * @Description: 密码工具类
 * @Author jiang
 * @Date 2020/8/6 22:48
 **/
public class PasswordUtil {
    public static boolean matches(SysUser user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
    }

    public static String encryptPassword(String username, String password, String salt) {
        return Md5Utils.hash(username + password + salt);
    }
}
