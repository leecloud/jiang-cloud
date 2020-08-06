package com.jiang.system.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

/**
 * @ClassName EnableYjFeignClients
 * @Description:
 * @Author jiang
 * @Date 2020/8/6 16:53
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableYjFeignClients {

    String[] value() default {};

    String[] basePackages() default {"com.jiang"};

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
