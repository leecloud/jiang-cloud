package com.jiang.jiangauth.service;

import com.jiang.commoncore.core.constant.Constants;
import com.jiang.commoncore.core.constant.ShiroConstants;
import com.jiang.commoncore.core.constant.UserConstants;
import com.jiang.commoncore.core.exception.base.BaseException;
import com.jiang.commoncore.core.exception.user.UserNotExistsException;
import com.jiang.commoncore.core.exception.user.UserPasswordNotMatchException;
import com.jiang.commoncore.core.util.DateUtils;
import com.jiang.commoncore.core.util.IpUtils;
import com.jiang.commoncore.core.util.MessageUtils;
import com.jiang.commoncore.core.util.ServletUtils;
import com.jiang.commoncore.enums.UserStatus;
import com.jiang.log.publish.PublishFactory;
import com.jiang.system.domain.SysUser;
import com.jiang.system.feign.RemoteUserService;
import com.jiang.system.util.PasswordUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName SysLoginService
 * @Description: 登录业务逻辑
 * @Author jiang
 * @Date 2020/8/6 20:42
 **/
@Component
public class SysLoginService {
    @Resource
    RemoteUserService userService;

    public SysUser login(String username, String password) {
        if (StringUtils.isAnyBlank(username, password)) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("not.null"));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
                    MessageUtils.message("user.password.not.match"));
            throw new UserPasswordNotMatchException();
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
                    MessageUtils.message("user.password.not.match"));
            throw new UserPasswordNotMatchException();
        }
        // 查询用户信息
        SysUser user = userService.selectSysUserByUsername(username);
        // if (user == null && maybeMobilePhoneNumber(username))
        // {
        // user = userService.selectUserByPhoneNumber(username);
        // }
        // if (user == null && maybeEmail(username))
        // {
        // user = userService.selectUserByEmail(username);
        // }
        if (user == null) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.not.exists"));
            throw new UserNotExistsException();
        }
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
                    MessageUtils.message("user.password.delete"));
            throw new BaseException("user.password.delete");
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
                    MessageUtils.message("user.blocked", user.getRemark()));
            throw new BaseException("用户锁定");
        }
        if (!PasswordUtil.matches(user, password)) {
            throw new UserPasswordNotMatchException();
        }
        PublishFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success"));
        recordLoginInfo(user);
        return user;
    }

    /**
     * 记录登录信息
     * @param user
     */
    public void recordLoginInfo(SysUser user) {
        user.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        user.setLoginDate(DateUtils.getNowDate());
        userService.updateUserLoginRecord(user);
    }

    /**
     * 注销
     * @param loginName
     */
    public void logout(String loginName) {
        PublishFactory.recordLogininfor(loginName, Constants.LOGOUT, MessageUtils.message("user.logout.success"));
    }
}
