package com.jiang.system.feign.factory;

import com.jiang.system.domain.SysLogininfor;
import com.jiang.system.domain.SysOperLog;
import com.jiang.system.feign.RemoteLogService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName RemoteLogFallbackFactory
 * @Description: 日志feign远程调用服务降级
 * @Author jiang
 * @Date 2020/8/6 21:34
 **/
@Slf4j
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService> {
    @Override
    public RemoteLogService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new RemoteLogService(){

            @Override
            public void insertOperlog(SysOperLog operLog) {

            }

            @Override
            public void insertLoginlog(SysLogininfor logininfor) {

            }
        };
    }
}
