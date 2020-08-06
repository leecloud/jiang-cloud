package com.jiang.jiangsystem.system.service;

import com.jiang.system.domain.SysLogininfor;

/**
 * @ClassName SysLogininforService
 * @Description: 系统访问日志情况信息服务层
 * @Author jiang
 * @Date 2020/8/6 22:20
 **/
public interface SysLogininforService {
    /**
     * 新增系统登录日志
     * @param sysLogininfor 参数对象
     */
    void insertLogininfor(SysLogininfor sysLogininfor);
}
