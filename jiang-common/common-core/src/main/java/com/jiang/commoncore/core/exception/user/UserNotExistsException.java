package com.jiang.commoncore.core.exception.user;

/**
 * @ClassName UserNotExistsException
 * @Description: 用户不存在异常
 * @Author jiang
 * @Date 2020/8/6 22:39
 **/
public class UserNotExistsException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}
