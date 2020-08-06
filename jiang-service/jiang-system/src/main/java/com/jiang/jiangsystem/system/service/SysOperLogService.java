package com.jiang.jiangsystem.system.service;

import com.jiang.system.domain.SysOperLog;

/**
 * @ClassName SysOperLogService
 * @Description: 操作日志
 * @Author jiang
 * @Date 2020/8/6 22:26
 **/
public interface SysOperLogService {
    /**
     * 新增操作日志
     * @param sysOperLog
     */
    void insertOperlog(SysOperLog sysOperLog);
}
