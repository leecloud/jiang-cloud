package com.jiang.system.feign;

import com.jiang.commoncore.core.constant.ServiceNameConstants;
import com.jiang.system.domain.SysLogininfor;
import com.jiang.system.domain.SysOperLog;
import com.jiang.system.feign.factory.RemoteLogFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName RemoteLogService
 * @Description: 日志Feign服务层
 * @Author jiang
 * @Date 2020/8/6 21:33
 **/
@FeignClient(name = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogService {
    /**
     * 新增远程操作日志
     * @param operLog
     */
    @PostMapping("operLog/save")
     void insertOperlog(@RequestBody SysOperLog operLog);

    /**
     * 新增远程访问日志
     * @param logininfor 参数
     */
    @PostMapping("logininfor/save")
     void insertLoginlog(@RequestBody SysLogininfor logininfor);
}
