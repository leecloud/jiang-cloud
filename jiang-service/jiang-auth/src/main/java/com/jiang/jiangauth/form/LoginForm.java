package com.jiang.jiangauth.form;

import lombok.Data;

/**
 * @ClassName LoginForm
 * @Description: 登录表单
 * @Author jiang
 * @Date 2020/8/6 16:56
 **/
@Data
public class LoginForm {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
