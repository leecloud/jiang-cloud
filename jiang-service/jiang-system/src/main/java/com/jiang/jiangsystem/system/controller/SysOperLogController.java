package com.jiang.jiangsystem.system.controller;

import com.jiang.commoncore.core.controller.BaseController;
import com.jiang.jiangsystem.system.service.SysOperLogService;
import com.jiang.system.domain.SysOperLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SysOperLogController
 * @Description: 操作日志记录
 * @Author jiang
 * @Date 2020/8/6 22:25
 **/
@RestController
@RequestMapping("operLog")
public class SysOperLogController extends BaseController {
    @Resource
    SysOperLogService sysOperLogService;

    /**
     * 新增保存操作日志记录
     */
    @PostMapping("save")
    public void addSave(@RequestBody SysOperLog sysOperLog) {
        sysOperLogService.insertOperlog(sysOperLog);
    }
}
