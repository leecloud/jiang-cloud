package com.jiang.jiangsystem.system.mapper;

import com.jiang.system.domain.SysOperLog;

/**
 * @ClassName SysOperLogMapper
 * @Description: 操作日志数据层
 * @Author jiang
 * @Date 2020/8/6 21:39
 **/
public interface SysOperLogMapper {
    /**
     * 新增操作日志
     * @param sysOperLog
     */
    void insertOperlog(SysOperLog sysOperLog);
}
