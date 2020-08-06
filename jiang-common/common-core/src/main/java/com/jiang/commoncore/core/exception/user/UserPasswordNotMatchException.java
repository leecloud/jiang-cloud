package com.jiang.commoncore.core.exception.user;

/**
 * @ClassName UserPasswordNotMatchException
 * @Description: 用户密码不正确或不符合规范异常类
 * @Author jiang
 * @Date 2020/8/6 22:42
 **/
public class UserPasswordNotMatchException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
