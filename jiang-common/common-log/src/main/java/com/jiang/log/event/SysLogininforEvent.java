package com.jiang.log.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName SysLogininforEvent
 * @Description: 系统日志事件
 * @Author jiang
 * @Date 2020/8/6 20:59
 **/
public class SysLogininforEvent extends ApplicationEvent {

    private static final long serialVersionUID = -9084676463718966036L;
    public SysLogininforEvent(Object source) {
        super(source);
    }
}
