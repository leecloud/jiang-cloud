package com.jiang.log.listen;

import com.jiang.log.event.SysLogininforEvent;
import com.jiang.log.event.SysOperLogEvent;
import com.jiang.system.domain.SysLogininfor;
import com.jiang.system.domain.SysOperLog;
import com.jiang.system.feign.RemoteLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @ClassName LogListener
 * @Description: 异步监听日志事件
 * @Author jiang
 * @Date 2020/8/6 21:32
 **/
@Slf4j
@AllArgsConstructor
public class LogListener {
    private final RemoteLogService remoteLogService;

    @Async
    @Order
    @EventListener(SysOperLogEvent.class)
    public void listenOperLog(SysOperLogEvent event) {
        SysOperLog sysOperLog = (SysOperLog) event.getSource();
        remoteLogService.insertOperlog(sysOperLog);
        log.info("远程操作日志记录成功：{}", sysOperLog);
    }

    @Async
    @Order
    @EventListener(SysLogininforEvent.class)
    public void listenLoginifor(SysLogininforEvent event) {
        SysLogininfor sysLogininfor = (SysLogininfor) event.getSource();
        remoteLogService.insertLoginlog(sysLogininfor);
        log.info("远程访问日志记录成功：{}", sysLogininfor);
    }
}
