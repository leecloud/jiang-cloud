package com.jiang.system.feign.factory;

import com.jiang.commoncore.core.domain.Result;
import com.jiang.system.domain.SysUser;
import com.jiang.system.feign.RemoteUserService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName RemoteUserFallbackFactory
 * @Description: feign服务降级处理
 * @Author jiang
 * @Date 2020/8/6 16:16
 **/
@Slf4j
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public SysUser selectSysUserByUsername(String username) {
                return null;
            }

            @Override
            public Result updateUserLoginRecord(SysUser user) {
                return Result.error();
            }
        };
    }
}
