package com.jiang.commoncore.core.exception.user;

import com.jiang.commoncore.core.exception.base.BaseException;

/**
 * @ClassName UserException
 * @Description: 用户信息异常类
 * @Author jiang
 * @Date 2020/8/6 22:40
 **/
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
