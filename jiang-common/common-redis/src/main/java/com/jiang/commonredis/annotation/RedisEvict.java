package com.jiang.commonredis.annotation;

import java.lang.annotation.*;

/**
 * @ClassName RedisEvict
 * @Description: redis删除注解
 * @Author jiang
 * @Date 2020/8/6 17:47
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisEvict {
    String key();

    String fieldKey();
}
