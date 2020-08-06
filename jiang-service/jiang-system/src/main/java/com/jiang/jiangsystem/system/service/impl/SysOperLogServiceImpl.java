package com.jiang.jiangsystem.system.service.impl;

import com.jiang.jiangsystem.system.mapper.SysOperLogMapper;
import com.jiang.jiangsystem.system.service.SysOperLogService;
import com.jiang.system.domain.SysOperLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName SysOperLogServiceImpl
 * @Description: 操作日志
 * @Author jiang
 * @Date 2020/8/6 22:26
 **/
@Service
public class SysOperLogServiceImpl implements SysOperLogService {
    @Resource
    SysOperLogMapper sysOperLogMapper;
    @Override
    public void insertOperlog(SysOperLog sysOperLog) {
        sysOperLogMapper.insertOperlog(sysOperLog);
    }
}
