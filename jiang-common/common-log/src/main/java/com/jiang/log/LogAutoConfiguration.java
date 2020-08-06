package com.jiang.log;

import com.jiang.log.aspect.OperLogAspect;
import com.jiang.log.listen.LogListener;
import com.jiang.system.feign.RemoteLogService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName LogAutoConfiguration
 * @Description:
 * @Author jiang
 * @Date 2020/8/6 22:19
 **/
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {
    private final RemoteLogService logService;

    @Bean
    public LogListener sysOperLogListener() {
        return new LogListener(logService);
    }

    @Bean
    public OperLogAspect operLogAspect() {
        return new OperLogAspect();
    }
}
