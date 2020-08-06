package com.jiang.log.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName SysOperLogEvent
 * @Description:
 * @Author jiang
 * @Date 2020/8/6 21:00
 **/
public class SysOperLogEvent extends ApplicationEvent {
    private static final long serialVersionUID = 8905017895058642111L;
    public SysOperLogEvent(Object source) {
        super(source);
    }
}
