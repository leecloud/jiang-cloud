package com.jiang.jiangsystem.system.service.impl;

import com.jiang.jiangsystem.system.mapper.SysLogininforMapper;
import com.jiang.jiangsystem.system.service.SysLogininforService;
import com.jiang.system.domain.SysLogininfor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName SysLogininforServiceImpl
 * @Description: 系统访问日志情况信息
 * @Author jiang
 * @Date 2020/8/6 22:21
 **/
@Service
public class SysLogininforServiceImpl implements SysLogininforService {
    @Resource
    SysLogininforMapper logininforMapper;
    @Override
    public void insertLogininfor(SysLogininfor sysLogininfor) {
        logininforMapper.insertLogininfor(sysLogininfor);
    }
}
